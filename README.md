# API Test Automation Project

## Table of Contents
- [API Test Automation Project](#api-test-automation-project)
  - [Table of Contents](#table-of-contents)
  - [Summary](#summary)
  - [Technologies and Tools](#technologies-and-tools)
  - [Requirements](#requirements)
  - [Project structure](#project-structure)
  - [Dependencies](#dependencies)
  - [Scenario](#scenario)
  - [API Reference](#api-reference)
    - [API](#api)
    - [Endpoint](#endpoint)
    - [Expected Responses](#expected-responses)
      - [Json](#json)
      - [Response Code](#response-code)
  - [Test Cases](#test-cases)
    - [Response Code](#response-code-1)
    - [Existence of Fields](#existence-of-fields)
    - [Json Schema](#json-schema)
  - [Basic usage](#basic-usage)
    - [URL Configuration](#url-configuration)
    - [Running](#running)
    - [Reporting](#reporting)
  - [Credits](#credits)

## Summary
This project is intended to create automated test cases for a specific API using a variety of tools to validate specified tests and create a test execution summary report.

## Technologies and Tools
* Java
* Maven
* Serenity
* Cucumber
* JUnit
* Hamcrest

## Requirements
In order to utilize this project you need to have the following installed locally:
* Maven 3
* Java 1.8

## Project structure
````
pom.xml
+ .idea
+ src
    + main
    |   + java
    |   |   + com
    |   |       + testautomation
    |   |           + api
    |   |               + interactions
    |   |               + questions
    |   |               + tasks
    |   |               + utils
    |   |                   + constants
    |   |                   + resources
    |   + resources
    + test
        + java
        |   + com
        |       + testautomation
        |           + api
        |               + runners
        |                   + stepdefinitons
        |                       + hook
        + resources
            + features
            + schemas
````

## Dependencies
This project uses Maven to manage all dependencies and plugins under the POM.xml file. If you want to add a new dependency / plugin, you should add the dependency in the file and compile your project again.

## Scenario
This project has been created using Serenity and Cucumber, so the test cases are created mapping the defined features using Gherkin language.
Keywords used:
* $Given$
* $When$
* $Then$
* $And$

The feature file **"get_users.feature"** contains the scenario with the corresponding feature description.
Gherkin language is used to "speak" the same language between business teams and technical teams.

Taking advantage of Serenity capabilities, the Screenplay pattern is used.

## API Reference
Learn more about this API [on the official site](https://reqres.in/)

### API
The URL used to access the API is:
````
https://reqres.in/
````
### Endpoint
All the automated tests are intended to use this endpoint. However, you can change some parameters (page number and expected response code) through the scenario definiton in the **"get_users.feature"** file. 
````
/api/users?page=2
````
### Expected Responses
The expected responses at this time are:

#### Json
This is a REST API and for this endpoint a Json response is expected.
````json
{
    "page": 2,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
    "data": [
        {
            "id": 7,
            "email": "michael.lawson@reqres.in",
            "first_name": "Michael",
            "last_name": "Lawson",
            "avatar": "https://reqres.in/img/faces/7-image.jpg"
        },
        {
            "id": 8,
            "email": "lindsay.ferguson@reqres.in",
            "first_name": "Lindsay",
            "last_name": "Ferguson",
            "avatar": "https://reqres.in/img/faces/8-image.jpg"
        },
        {
            "id": 9,
            "email": "tobias.funke@reqres.in",
            "first_name": "Tobias",
            "last_name": "Funke",
            "avatar": "https://reqres.in/img/faces/9-image.jpg"
        },
        {
            "id": 10,
            "email": "byron.fields@reqres.in",
            "first_name": "Byron",
            "last_name": "Fields",
            "avatar": "https://reqres.in/img/faces/10-image.jpg"
        },
        {
            "id": 11,
            "email": "george.edwards@reqres.in",
            "first_name": "George",
            "last_name": "Edwards",
            "avatar": "https://reqres.in/img/faces/11-image.jpg"
        },
        {
            "id": 12,
            "email": "rachel.howell@reqres.in",
            "first_name": "Rachel",
            "last_name": "Howell",
            "avatar": "https://reqres.in/img/faces/12-image.jpg"
        }
    ],
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
````

#### Response Code
For a successful request we expect this response code: 
````json
200
````

## Test Cases
A main scenario was created in the feature file to generate the test case validation, which is intended to check response code and fields existence.
The steps are defined in the **"GetUsersStepDefinitions"** class. 

### Response Code
The response code is taken from the feature file where a **200** response code is expected from the response. This code can be changed in the feature file according to the needs.

### Existence of Fields
This test is intended to check the fields existence for each user retrieved.
The following fields are expected for each user:
* id
* email
* first_name
* last_name
* avatar

### Json Schema
One additional test case has been created to validate the Json schema. It compares the retrieved Json with the schema file **"GetUsersJsonSchema.json"**defined under the schemas folder.

## Basic usage
This project uses Maven and a custom defined Runner to run all the defined test cases.
Verify you have all the dependencies before you run anything:
````
mvn compile
````
This command will execute:
* Clean: handles project cleaning
* Validate: validate the project is correct and all necessary information is available
* Compile: compile the source code of the project

To know more about the Maven build lifecycle please check the [official documentation](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)

### URL Configuration
The URL is specified in the **"serenity.conf"** file and varies according to the environment used.

### Running
To run all defined test cases, you should executed the defined Runner to be able to get results. This runner file **"GetRunners"** is under **"test/java/com.testautomation.api.runners"** path.
Right click on the **"GetRunnersFile"** and select **"Run"** to execute the file.

### Reporting
This project uses the Maven Serenity plugin to be able to generate the reports. To generate a new report, you can: 
1. Use the interface if you are using IntelliJ, clicking the **Serenity:aggregate** option under **Plugins/Serenity** path.
2. Use the console to execute the task using the following command:
````
mvn serenity:aggregate
````
The Serenity reports will be generated in **target/site/serenity/index.html**.

## Credits
By: **Diego Peña**
