FROM openjdk:8u191-jre-alpine3.8

# Workspace
WORKDIR /usr/share/udemy

#ADD .jar under target host
# into this image
ADD target/selenium-docker-tests.jar selenium-docker.jar
ADD target/selenium-docker.jar  selenium-docker.tests.jar
ADD target/libs libs

# ADD suite files
ADD book-flight-module.xml  book-flight-module.xml
ADD search-module.xml   search-module.xml

ENTRYPOINT java -cp ".\selenium-docker.jar;.\selenium-docker-tests.jar;libs\*" -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG  ..\book-flight-module.xml