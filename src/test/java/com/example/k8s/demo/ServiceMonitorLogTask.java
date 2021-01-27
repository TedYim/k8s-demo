package com.example.k8s.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ServiceMonitorLogTask {

    private static ServiceMonitorLogTask LOG_TASK = new ServiceMonitorLogTask();

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMonitorLogTask.class);

    private List<ServiceMonitorLogTaskHandler> serviceMonitorLogTaskHandlers = new ArrayList<>();

    private int handlerSize = 3;

    private ExecutorService executorService = Executors.newFixedThreadPool(handlerSize);

    private ServiceMonitorLogTask() {
        for (int i = 0; i < handlerSize; i++) {
            serviceMonitorLogTaskHandlers.add(new ServiceMonitorLogTaskHandler());
        }

    }


    private class ServiceMonitorLogTaskHandler implements Runnable {

        public ServiceMonitorLogTaskHandler() {
            executorService.submit(this);
        }

        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();


        public void run() {

            while (true) {
                try {
                    System.out.println("================" + queue.take());
                } catch (InterruptedException e) {
                    LOGGER.error("ServiceMonitor addTaskLog meet some exception", e);
                }
            }
        }
    }

    public static void addTaskLog(String serviceMonitor) {
        if (serviceMonitor != null) {

            ServiceMonitorLogTaskHandler hand = LOG_TASK.serviceMonitorLogTaskHandlers.get(new Random().nextInt(LOG_TASK.handlerSize));

            try {
                hand.queue.put(serviceMonitor);
            } catch (InterruptedException e) {
                LOGGER.error("ServiceMonitor addTaskLog meet some exception", e);
            }
        }
    }
}
