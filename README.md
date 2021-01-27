# Container

## Create tomcat image

##### Step1: Login

```shell script
sudo docker login
```

This is login hub.docker.com


##### Step2: Build image

```shell script
docker build -f Dockerfile -t yan357/jdk-8-tomcat-centos-7:v1 --rm=true .
```


##### Step3: Push image

```shell script
docker push yan357/jdk-8-tomcat-centos-7:v1
```

This is upload image to https://hub.docker.com/, if upload to other repositories, need the other params, such as aws cli.


```

##### Remove container

```shell script
docker rm ${CONTAINER_ID}
```
##### Remove image - not working

```shell script
docker images | grep -E "yan357/tomcat" | awk ‘{print $3}‘ | uniq | xargs -I {} docker rmi --force {}
```


## Create app image

##### Step1: Build image

```shell script
docker build -f Dockerfile -t yan357/docean-app-docker:v1.7 --rm=true .
```

docker build -f Dockerfile -t yan357/docean-utils-docker:v1 --rm=true .

##### Step2: Push image

```shell script
docker push yan357/docean-app-docker:v1.7
```

##### Run

```shell script
docker run -p 9091:8080 --name docean-app-docker yan357/docean-app-docker:v1.7
```

docker run -p 9091:8080 --name docean-app-docker yan357/docean-utils-docker:v1

##### Logs

```shell script
$ docker logs [OPTIONS] CONTAINER
  Options:
        --details        显示更多的信息
    -f, --follow         跟踪实时日志
        --since string   显示自某个timestamp之后的日志，或相对时间，如42m（即42分钟）
        --tail string    从日志末尾显示多少行日志， 默认是all
    -t, --timestamps     显示时间戳
        --until string   显示自某个timestamp之前的日志，或相对时间，如42m（即42分钟）
```


aws eks --profile cn-northwest-1 --region cn-northwest-1 update-kubeconfig --name test1

/Users/ted.yan/WorkSpaces/Demo/gitops-test/Prometheus/deploy.yml
kubectl create deployment python-web-app --image=012345678.dkr.ecr.us-east-1.amazonaws.com/python-web:latest

------------------


```shell script
aws ecr get-login-password --region cn-northwest-1 --profile cn-northwest-1 | docker login --username AWS --password-stdin 941002153439.dkr.ecr.cn-northwest-1.amazonaws.com.cn

docker build -f Dockerfile -t 941002153439.dkr.ecr.cn-northwest-1.amazonaws.com.cn/test:9.0.0 --rm=true .

docker push 941002153439.dkr.ecr.cn-northwest-1.amazonaws.com.cn/test:9.0.0

docker run -p 9091:8080 --name demo 941002153439.dkr.ecr.cn-northwest-1.amazonaws.com.cn/test:5.0.0

```


```shell script
helm install prometheus-operator stable/prometheus-operator -n monitoring

helm upgrade prometheus-operator stable/prometheus-operator --values=values_servicemonitor.yml -n monitoring

kubectl patch svc prometheus-operator-grafana -n monitoring -p '{"spec": {"type": "LoadBalancer"}}'

kubectl patch svc prometheus-operator-prometheus -n monitoring -p '{"spec": {"type": "LoadBalancer"}}'

kubectl patch svc prometheus-operator-alertmanager -n monitoring -p '{"spec": {"type": "LoadBalancer"}}'
```