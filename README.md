# AutomationTestProject
> This project is prepared to test demoQA text box feature test scenarios.

> Framework Dependencies: Java-Maven, Selenium, Cucumber, JUnit

> Demo file is included: (Demo_SelmaIrmak.mp4)

> Tests html report is included. Download all the cucumber-html-reports file content and click on the file report-feature_1891380625

## Table of Contents
* pom.xml file
* configuration.properties file
* .feature file
* pages package (Page Object Model-POM)
* runners package
* step_definitions package
* utilities package
* test reports and target folder
* How to run the tests?


## pom.xml file
- This file includes the information, configuration details and dependencies used by Maven to build the project. 
- Public dependencies are used.


## configuration.properties file
- This file is the central repository for the common data used in the tests.
- It gives us the advantage to change data from one place instead of going into test files and change data one by one.
- Data is read by ConfigurationReader class which is under the utilities package.


## .feature file
- Test scenarios are written in feature files in Gherkin language format (Given, When, Then)
- Gherkin language is giving us advantage to read test case steps easily without investigating codes especially for the non-technical personnel. 
- Scenarios can be tagged as @smoke, @regression, @test3 to run specific test cases only.
- Scenario Outline is used to run same test case with different data. Data is taken from Examples Table. Instead of writing many similar scenarios, you can write only one test case with dynamic data.
- In scenarios parameters are used to make the scenarios dynamic to used again in other test cases.


## pages package (Page Object Model-POM)
- Page Object Model is used in this package.
- Locators stored in one class which is named of the specific page it belongs, to be able use reuse them easily.
- We can create object from that class and call locators which are stored as WebElement variables.
- When a locator value is changed, we don´t have to investigate all the test suite, we can change the locator from its page class.
- POM increases the code reusebility and make the maintenance easy. Also increases readability and reliability of the code.

## runners package
- CukesRunner runs the tests and produces report based on its configuration.
- We configure Cukesrunner by giving feature file and scripts location and input tags if we want to run specific tests.
- Configuring the plugin will provide us a pretty HTML report.
- We can run tests via clicking Run menu and selecting Run 'CukesRunner'button (Run->Run 'CukesRunner') on the top menu of IntelliJ . If we run the tests from here, we will have a default HTM report which is not a detailed one.
- In addition we can run tests from maven verify. In this case we will have a detailed pretty HTML report because we used another report dependency in pom.xml file.
- FailedTestRunner keeps the failed tests and when we run tests from FailedTestRunner, only failed tests run which helps us to not wait for the passed tests for a second run.

## step_definitions package
- We implement our coding in this file.
- Methods are created with the name of the feature file steps and gets parameters dynamically.
- Hooks is used for setUp and teardown methods. setUp is a before method which runs before every test scenario. teardown is an after method which runs after every test scenario which takes a screenshot if test fails and closes the browsers.

## utilities package
- Reusable methods which can be used in any test case are stored in BrowserUtils. We can call a method from this class and use in any test case. I added some examples as scroll method. BrowserUtils increases the code reusebility a lot.
- ConfigurationReader reads the data in configuration.properties file and uses the data wherever it needed. data can be updated from configuration.properties file intead of updating from every test case.
- Driver is the setup of the WedDriver. ChromeDriver or other browser drives can be created automatically calling Driver.get() method.

## test reports and target folder
- Maven sure file plugin in pom.xml generates reports.
- We can use 2 types of report. Default HTML reports of the framework is not detailed so that we use open source dependecy which is a detailed pretty HTML report.
- In order to get a pretty HTML report we have to run the tests from mvn verify.
- Pretty html report is added into project files.

## How to run the tests?
- Run from CukesRunner: SetUp the configuration, delete tags line and click Run menu and select Run 'CukesRunner'button (Run->Run 'CukesRunner') on the top menu of IntelliJ  run all tests. To run specific tests enter the tags of tests which are put in feature file.
- Run from Maven verify: SetUp the configuration from Cukes runner, open maven lifecycle (from the right pane of IntelliJ) and select Verify.
- Run from command line with Maven: Maven should be installed, then go to the test project directory and do mvn verify

## End.

