package com.example.k8s.demo;


public class LeakTest {

    public static void main(String[] args) throws Exception {
        int i = 0;
        String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<env:Envelope\n" +
                "    xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "    xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">\n" +
                "    <env:Header></env:Header>\n" +
                "    <env:Body>\n" +
                "        <importProductSeasonAssignment\n" +
                "            xmlns=\"http://v3.integration.api.hubsoft.com\"\n" +
                "            xmlns:corecom=\"http://xmlns.oracle.com/EnterpriseObjects/Core/Common/V2\"\n" +
                "            xmlns:corecomcustebo=\"http://xmlns.oracle.com/EnterpriseObjects/Core/Custom/CommonEBO/V1\"\n" +
                "            xmlns:corecomebo=\"http://xmlns.oracle.com/EnterpriseObjects/Core/CommonEBO/V1\"\n" +
                "            xmlns:dvm=\"http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue\"\n" +
                "            xmlns:ebo=\"http://xmlns.oracle.com/EnterpriseObjects/Core/EBO/Item/V2\"\n" +
                "            xmlns:req=\"http://request.v3.integration.api.hubsoft.com\"\n" +
                "            xmlns:ws=\"http://v3.integration.api.hubsoft.com\">\n" +
                "            <ws:productList>\n" +
                "                <req:ProductDTO>\n" +
                "                    <req:classificationCode>\n" +
                "                        <ws:string>KIDS'</ws:string>\n" +
                "                        <ws:string>FOOTWEAR</ws:string>\n" +
                "                        <ws:string>BOOT</ws:string>\n" +
                "                    </req:classificationCode>\n" +
                "                    <req:classificationDesc>\n" +
                "                        <ws:string>KIDS'</ws:string>\n" +
                "                        <ws:string>FOOTWEAR</ws:string>\n" +
                "                        <ws:string>BOOT</ws:string>\n" +
                "                    </req:classificationDesc>\n" +
                "                    <req:productColor>\n" +
                "                        <req:ProductColorDTO>\n" +
                "                            <req:colorCode>ZRTN</req:colorCode>\n" +
                "                            <req:colorDesc>ZIGGY ROSE TAN</req:colorDesc>\n" +
                "                            <req:introDate>2021-01-25</req:introDate>\n" +
                "                            <req:orderMultiple>0</req:orderMultiple>\n" +
                "                            <req:productNumber>1116671Y-ZRTN</req:productNumber>\n" +
                "                            <req:salesCategoryCode>FOOTWEAR</req:salesCategoryCode>\n" +
                "                            <req:sizeChartCode>732</req:sizeChartCode>\n" +
                "                            <req:sizeChartDesc>Y 4-7 WHOLE SIZES - BBC</req:sizeChartDesc>\n" +
                "                            <req:sizes>\n" +
                "                                <req:SizeDTO>\n" +
                "                                    <req:sizeCode>04</req:sizeCode>\n" +
                "                                    <req:sizeSequence>2</req:sizeSequence>\n" +
                "                                    <req:seasonCode>S21,BULK-SS21</req:seasonCode>\n" +
                "                                    <req:sku>1116671Y-ZRTN-04</req:sku>\n" +
                "                                    <req:upc>194715724907</req:upc>\n" +
                "                                </req:SizeDTO>\n" +
                "                                <req:SizeDTO>\n" +
                "                                    <req:sizeCode>02</req:sizeCode>\n" +
                "                                    <req:sizeSequence>1</req:sizeSequence>\n" +
                "                                    <req:seasonCode>S21,BULK-SS21</req:seasonCode>\n" +
                "                                    <req:sku>1116671Y-ZRTN-02</req:sku>\n" +
                "                                    <req:upc>194715724945</req:upc>\n" +
                "                                </req:SizeDTO>\n" +
                "                                <req:SizeDTO>\n" +
                "                                    <req:sizeCode>06</req:sizeCode>\n" +
                "                                    <req:sizeSequence>3</req:sizeSequence>\n" +
                "                                    <req:seasonCode>S21,BULK-SS21</req:seasonCode>\n" +
                "                                    <req:sku>1116671Y-ZRTN-06</req:sku>\n" +
                "                                    <req:upc>194715724952</req:upc>\n" +
                "                                </req:SizeDTO>\n" +
                "                                <req:SizeDTO>\n" +
                "                                    <req:sizeCode>06.5</req:sizeCode>\n" +
                "                                    <req:sizeSequence>4</req:sizeSequence>\n" +
                "                                    <req:seasonCode>S21,BULK-SS21</req:seasonCode>\n" +
                "                                    <req:sku>1116671Y-ZRTN-06.5</req:sku>\n" +
                "                                    <req:upc>194715724938</req:upc>\n" +
                "                                </req:SizeDTO>\n" +
                "                            </req:sizes>\n" +
                "                        </req:ProductColorDTO>\n" +
                "                    </req:productColor>\n" +
                "                    <req:productName>Y MIDFORM UNIVERSAL</req:productName>\n" +
                "                    <req:productReference>1116671Y</req:productReference>\n" +
                "                </req:ProductDTO>\n" +
                "            </ws:productList>\n" +
                "            <ws:serviceConfig>\n" +
                "                <ws:entry>\n" +
                "                    <ws:key>access.key</ws:key>\n" +
                "                    <ws:value>hx7cIl11DJ</ws:value>\n" +
                "                </ws:entry>\n" +
                "            </ws:serviceConfig>\n" +
                "        </importProductSeasonAssignment>\n" +
                "    </env:Body>\n" +
                "</env:Envelope>";
        while (true) {
            System.err.println("---------------" + i);
            ServiceMonitorLogTask.addTaskLog(i++ + "=================" + payload);
//            if (i == 7000) {
//                ServiceMonitorLogTask.addTaskLog(i++ + "=================" + payload);
//            }
            //TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
