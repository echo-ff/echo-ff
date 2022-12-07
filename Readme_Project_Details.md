**Framework Used:**
Selenium + Maven + TestNG

**Pakages And Classes**

**1. Utilities Package**

Description: This Package contains classes for Helping

Classes : DataProvider.java (Reads data from properties file as we are not hard coding the urls rather fetching them from properties file),
Helper.java (contains methods like fetching text of a WebElements etc), BrowserFactory.java (for setting up and quiting Webdriver)

**2. baseClass Package**

Description : Contains Base Class which includes Before Suite and After Suite Methods for Setting up the Test

Classes : ** BaseClass.java

**3. TestCases Package**

Description : Contains two Classes (Wiki and IMDB), which further contains page specific locators and methods

Classes :  Wiki.java, IMDB.java

**4. TestPages Package**

Description: Cointains Test Case Class (VerifyDateAndCountry.java)

Classes: VerifyDateAndCountry.java

**DATA :**

Fetching url from pageURLs.properties file using DataProvider.java class

**Test Report**

Using Spark Extent Report to record the Test results. Location: ./Reports/Reports.html

**POM.xml and TestNG.xml**

pom.xml contains dependencies and plugin AND TestNG.xml contains classes to execute


