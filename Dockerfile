FROM java:8-jdk-alpine
MAINTAINER ted.yan@deckers.com
COPY ./target/demo-0.0.1-SNAPSHOT.jar /usr/local/demo/demo.jar

ENTRYPOINT exec java $JAVA_OPTS  -jar /usr/local/demo/demo.jar