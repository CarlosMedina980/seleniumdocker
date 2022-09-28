FROM openjdk:18-jdk-alpine3.15

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

#ADD .jar under target host
# into this image
ADD target/selenium-docker-tests.jar selenium-docker.jar
ADD target/selenium-docker.jar  selenium-docker-tests.jar
ADD target/libs libs

# ADD suite files
ADD book-flight-module.xml  book-flight-module.xml
ADD search-module.xml   search-module.xml

# ADD healtcheck script
ADD healthcheck.sh    healthcheck.sh

ENTRYPOINT sh healthcheck.sh