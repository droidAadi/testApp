# Most Popular Articles App
This application displays the Most Popular Articles on NY Times using the NY Times Most Popular Articles API.
It is based on MVVM pattern and utilizes Retrofit library for network operation. It also includes the static code analyser tool i.e. **Lint** and **SonarQube** configuration so as to keep a constant check on code quality.

## Prerequisites
- Android Studio 3.x version
- Java 7 or above
- GitHub access
- Signup on NY Times developer portal to get an API key, which is required to access the NY Times API. Link is provided below:
  > https://developer.nytimes.com/get-started,
- Sonar Qube Setup -> Can be downloaded from https://www.sonarqube.org/downloads/


## Getting Started
- Clone the repository from the given URL and import the project in Android Studio.

  > Use **git clone** https://github.com/droidAadi/testApp.git from terminal/cmd window.
  
- Once you import, the project building will start automatically. Alternatively, you can use following command as well to build the project manuallly from command line/terminal window.

  > **gradlew build**
  
- Post successful building of the project, add the obtained API key from https://developer.nytimes.com/get-started in **gradle.properties** file.

  > **apiSecretProp = YOUR_API_KEY**
  
- **NOTE: For now, the default is key is already shipped with the project. But it is advisable to replace the existing key with your own key.**
  
- Run the application on Emulator or Device directly from Android Studio.

- If you face any issues while running it from Android Studio, you can generate the apk manually from Android Studio via below menu option and install it on the device/emulator via adb command from command line tools.

  > **Build -> Build Bundle/APK -> Build APK.**
  
  > **adb install PATH_OF_APK**

## Code Quality Setup
- We have added three scripts (under scripts folder) in this project which cater to different needs :-

  **a) script_lint.gradle** - This contains script for running lint tool via **gradlew command**. We have another folder in root directory with the name lint which contains a file named **rules_line.xml**. This file can be used to customize the existing lint rules.
If reqiured, you can add CheckStyle, PMD, findbugs scripts here as well depending upon your requirement.

> This script can be run via **_gradlew clean lint_**.

> After successful execution of the command, the lint report can be viewed at **$project.buildDir/outputs/lint/lint.html**

  **b) script_sonar.gradle**- This script triggers the sonar-qube report generation. Complete sonar report is pushed to your Sonar server (which is a localhost:9000 for this project). You can also view code coverage report on SonarQube Server.
  
> This script can be run individually via **_gradlew sonarqube -Dsonar.host.url=http://localhost:9000/_** 

> Results can be viewed at localhost:9000 after succesful build.

  **c) script_jacoco.gradle** - This contains the jacoco configuration for tests coverage calculation.
  
  > This script can be run individually via **_gradlew clean test createDebugCoverageReport jacocoTestReport_**.
  
  > Report gets generated at **$project.buildDir/outputs/reports/coverage/debug/index.html**. 
  
  > Since Jacoco might not work properly with Android Gradle Plugin 3.x versions, you can manually check if the unit-test cases are passing or failing at **$project.buildDir/reports/tests/testDebugUnitTest/index.html**
  
Also, the jacoco script and sonar script can be run together as well, so that test coverage report gets pushed along with sonarqube results in one go.
  
  > This can be done via **_gradlew clean jacocoTestReport sonarqube_**
  
  

**NOTE: Jacoco may or may not work with Android Gradle plugin 3.x versions. Due to this, you might encounter issues while running the jacoco script. Also, due to this reason, the coverage report might not get generated and pushed onto SonarQube server.**
