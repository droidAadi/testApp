# Most Popular Articles App
This application displays the Most Popular Articles on NY Times using the NY Times Most Popular Articles API.
It is based on MVVM pattern and utilizes Retrofit library for network operation. It also includes the static code analyser tool i.e. **Lint** and **SonarQube** configuration so as to keep a constant check on code quality.

## Prerequisites
- Android Studio installation
- Java 7 or above
- GitHub setup
- Need to signup for an API key
at: https://developer.nytimes.com/get-started,
- Sonar Qube Setup -> Can be downloaded from https://www.sonarqube.org/downloads/


## Getting Started
- Clone the reository from the given URL and import the project in Android Studio.
  > Use **git clone** https://github.com/droidAadi/testApp.git from terminal/cmd window.
- Add the obtained API key in **gradle.properties** file 
  > **apiSecretProp = YOUR_API_KEY**
- Build and Run the application on Emulator or Device.
- If you face any issues while running it from Android Studio, you can generate the apk manually via following command and install it on the device/emulator via adb command from command line tools.
  > **Build -> Build Bundle/APK -> Build APK.**

## Code Quality Setup
- We have added three scripts (under scripts folder) in this project which cater to different needs :-

  **a) script_lint.gradle** - This contains script for running lint tool via **gradlew command**. We have another folder in root directory with the name lint which contains a file named **rules_line.xml**. This file can be used to customize the existing lint rules.
If reqiured, you can add CheckStyle, PMD, findbugs scripts here as well depending upon your requirement.

  **b) script_sonar.gradle**- This script triggers the sonar-qube report generation. Complete sonar report is pushed to your Sonar server (which is a localhost:9000 for this project).

  **c) script_jacoco.gradle** - This contains the jacoco configuration for tests coverage calculation.

**NOTE: Jacoco has stopped working with Android Gradle plugin 3.x versions. Due to this, you might encounter issues while running the jacoco script. Also, due to this reason, the coverage report will not be generated and pushed onto SonarQube server.
Open issue link with Android Orchestrator :https://issuetracker.google.com/issues/72758547**

## Commands to Run the scripts
- **Lint**: **_gradlew lint_** 
> After successful execution of the command, the lint report can be viewed in $project.buildDir/outputs/lint/lint.html
- **SonarQube:** **_gradlew sonarqube -Dsonar.host.url=http://localhost:9000/_**
> Results can be viewed at localhost:9000 after succesful build.
- **Jacoco:** **_gradlew clean test jacocoTestReport_**
> This report can be viewed in app/build/reports/
