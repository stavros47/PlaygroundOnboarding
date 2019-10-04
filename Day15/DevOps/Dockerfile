FROM ubuntu
MAINTAINER Stavros Argyrou <stavris.47@gmail.com>

ENV http_proxy http://192.168.101.52:8080
ENV https_proxy http://192.168.101.52:8080

RUN apt-get update && apt-get install -y default-jdk git
RUN apt-get install -y maven
