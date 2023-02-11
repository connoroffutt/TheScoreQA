# TheScoreQA Project - For theScore QA challenge

POM.xml file included in project. To initialize the test please follow the following steps:

1.) Install newest version of stable Maven (if not already installed): find further instructions here https://www.baeldung.com/install-maven-on-windows-linux-mac
2.) Download all files in this git repository
3.) In the BaseTestFeatures file there is a before class called "configureAppium", alter that text to point at your appium main.js. NOTE: in Windows this may be inside a hidden folder.
4.) start your android emulator or android device
5.) via the command prompt go to the root folder likely titled "TheScoreQA"
6.) run the command "mvn package", this will initialize the pom file and run the tests provided.
7.) Test pass will show in the command prompt window
8.) You can find test results in the test-output folder, these include many different standardized reports



