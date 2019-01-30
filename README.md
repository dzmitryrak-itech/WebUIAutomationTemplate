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

* ```mvn clean install -DsuiteXmlFile=testng-properties.xml allure:serve``` - to run tests
* ```allure serve target/allure-results``` - to view test report
* ```mvn versions:display-plugin-updates``` - check for latest updated from Maven repo

# Details

Tests can be run in parallel using testng.xml files. Parallel execution is implemented by test class
In details:

Each class should have annotation to read properties about device from the xml file
```
    @org.testng.annotations.Parameters(value={"deviceName","udid", "platform", "version"})
    @BeforeClass
    public void openDriver (@Optional("Pixel_2_Android_9") String deviceName, @Optional("emulator-5554") String udid,
                            @Optional("Android") String platform,@Optional("9.0") String version) {
        setCustomCapabilities(deviceName, udid, platform, version);
    }
```

Appium Server is started programmatically for each class separately. 
Webdriver is started for each test method.