# Purpose

Improve skills in mobile application testing

# Tutorials

* Appium from the scratch: https://www.swtestacademy.com/appium-tutorial/
* IOS and Android integration inside PageObjects https://github.com/eliasnogueira/appium-parallel-execution/blob/master/src/main/java/com/eliasnogueira/po/MainScreenPageObject.java

# Technology Stack

Java + Maven + Selenoid + Appium

# GIT strategy

* master - for production-ready version (merges to master by Project Owner only)
* develop - integration branch for feature-development
* other branches - should be created from develop and merged to it after completion

# How to

* ```mvn clean test``` - to run tests
* ```allure serve target/allure-results``` - to view test report
* ```mvn versions:display-plugin-updates``` - check for latest updated from Maven repo
