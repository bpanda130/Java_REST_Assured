## JSONPlaceHolder-API-Automation

###Project Description
    - Project have implementation to fetch results from a configurable api endpoint
    - Validating the Response with all, possible status code.
    - Fetch required User, Post and Comment details based on the input parameter and validate the email formating for the same.
    - Covered Positive and Negetive scenarios for User and Post GET APIs.

###Project Component
    - Test mentioned in assignment document is automated in FreeNowApiChallengeTest.java inside src/test/java package.
    - Apart from these, also covered Positive and Negative tests for User and Posts APIs.
    - application.properties    : holds all required input param present inside src/main/resources/properties/dev

###External Library
    Java, JUnit5, Spring, Maven and RestAssured

### Execution paramerters
### Maven
```sh 
//To Execute all the Testcases
mvn clean test -Denvironment=dev

//To Execute required Tag
mvn clean test -Denvironment=dev -Dgroups=<Tag Name>
```
####Tag:
    All             : All the Testcase
    Positive        : Positive Scenarios
    Negative        : Negative Scenarios
    AssignmentTask  : Given assignment Testcase
    Posts           : All Posts APIs
    Users           : All Users APIs


