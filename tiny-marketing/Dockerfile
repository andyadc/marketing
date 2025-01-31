# base image
FROM openjdk:8-jre-slim

MAINTAINER andyadc

ENV PARAMS=""

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/tiny-marketing.jar /tiny-marketing.jar

ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /tiny-marketing.jar $PARAMS"]

