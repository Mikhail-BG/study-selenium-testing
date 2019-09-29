# Study Selenium Testing

Pet project for learning Selenium WebDriver. 

Tests run on https://the-internet.herokuapp.com/

### Prerequisites

* Requires web driver. 
The path has to be set up parameter **geckodriver** 
_/resources/setup/lnx.properties_ and _/resources/setup/win.properties_
```
lnx.properties 
geckodriver=/etc/geckodriver/geckodriver

win.properties
geckodriver=geckodriver/win/geckodriver.exe
```

* Requires _selenium-server-standalone jar_, has to be put in _/grid/_. 
_startHub.sh_ and _startNode.sh_ has to be re-configured, they depends on jar version.

```
current version: selenium-server-standalone-3.141.59.jar
```

* To run with Selenium GRID requires to set up Node host parameter **gridnodeurl**
in _/resources/environment/localsetup/lnx.properties_ and _/resources/environment/localsetup/win.properties_

```
lnx.properties 
gridnodeurl=http://[HOST_IP]:5556/wd/hub

win.properties
gridnodeurl=http://[HOST_IP]:5556/wd/hub
```

* To run on Selenoid set environment variable "Environment" = "selenoid". 
Use _/resources/environment/selenoid.properties_ to set Selenoid hub.

````
selenoid.properties
HubUrl=[HOST_IP]]/wd/hub
enableVNC=true
````

## Deployment

Built With

* [geckodriver](https://github.com/mozilla/geckodriver/releases) - Latest Geckodriver
* [selenium grid](https://docs.seleniumhq.org/download/) - Selenium Server

## Running the tests

Test run configured under _src/test/resources/testng.xml_

* To run tests with Selenium GRID run scripts in correct order:
```
first: startHub.sh
second: startNode.sh
```