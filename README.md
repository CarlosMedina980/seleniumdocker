# seleniumdocker
This is a repository for study purposes with docker implementation


Maven Generation of Jar:

mvn clean package -DskipTests


Docker commands:

docker build -t=cajameve980/seleniumdocker .

docker run -it --entrypoint=/bin/sh cajameve980/seleniumdocker 

Test Ng:

parallel="tests"

Windows Execution from Jar:
java -cp ".\selenium-docker.jar;.\selenium-docker-tests.jar;libs\*" -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG  $MODULE
java -cp ".\selenium-docker.jar;.\selenium-docker-tests.jar;libs\*" org.testng.TestNG ..\book-flight-module.xml

 


Linux Execution from Jar:
java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST=192.168.1.16 org.testng.TestNG  search-module.xml


docker run -e HUB_HOST=192.168.1.16 -e MODULE=search-module.xml cajameve980/seleniumdocker

Run tests form Docker container:

docker run -d -e HUB_HOST=192.168.1.16 -e MODULE=search-module.xml -v   -v C:\Users\cajam\Documents\QAAutomation\Output:/usr/share/udemy/test-output cajameve980/seleniumdocker 

Running test from docker compose file

docker-compose up --scale firefox=4 --scale chrome=4  