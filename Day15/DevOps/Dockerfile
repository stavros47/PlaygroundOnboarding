FROM ubuntu
MAINTAINER Stavros Argyrou <stavris.47@gmail.com>

ENV http_proxy http://192.168.101.52:8080
ENV https_proxy http://192.168.101.52:8080
ENV no_proxy_hosts localhost,127.0.0.1,10.236.52.183

RUN apt-get update && apt-get install -y default-jdk git maven
