## **To Run From CMD:**

**Prerequisite**: Maven Should be Installed. To Install Maven, This is a Guide - https://maven.apache.org/install.html

**Make sure JDK is specified instead of JRE**

**Steps**: Open cmd **>>** Nevigate to Project Directory **>>** Exectute following command "mvn clean install test -DsuiteFiles=testng.xml

**Check Report**: Open Project Folder >> Reports >> Open "Reports.html" in browser

 ********************************************************************************************
 
 
 
## **To Run from IDE**

Prerequisits: Java Should be Installed 

Open any IDE (i.e. Eclipse) >> Clone Project >> Run pom.xml file as Mavel Build **[Base Directory: Location of the Project !!!IMPORTANT!!! AND GOAL: mvn test -DsuiteFiles=testng.xml]]** >> Then Check Report.html

**Make sure JDK is specified instead of JRE in Build path**

********************************************************************************************


## **Run on Jenkins Server**

Host repository on GitHub/Bitbucket

Install Jenkins on Server >> Create Jenkins Job with details like 

**Configure**

  Description : Demo Project
  
  Repositoy: https://github.com/echo-ff/echo-ff.git
  
  Credentials : Not Required as it is public
  
  Root POM : pom.xml
  
  Time of Build like EEE, d MMM yyyy, HH:mm
  
  Branch to Build : Master
  
  Build Periodically if want to run the build everyday { H 6  * * * }
  
  Goals and options : clean install test -DsuiteFile=XMLFiles/testng.xml
  
**Post Build**
  Sent Extent Report to Email
  
  Recipients : recipent's email
  
  Index page[s] : ** /Reports/Reports.html
  
  Etc. 
