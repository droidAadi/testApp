# Most Popular Articles App
This application displays the Most Popular Articles on NY Times using the NY Times Most Popular Articles API.
It is based on MVVM pattern and utilizes Retrofit for network operation.


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

a) script_lint.gradle - This contains lint configuration for now. If reqiured, you can add CheckStyle, PMD, findbugs configuration here as well. We have another folder in root directory with the name lint which contains a file named 
rules_line.xml. This file can be used to customize the existing lint rules.

b) script_jacoco.gradle - This contains the jacoco configuration for tests coverage calculation. [NOTE: Jacoco has stopped working with Android 3.0+ versions]

c) script_sonar.gradle- This scrip triggers the sonar-qube report generation.

## Commands to Run the scripts
- Lint: gradlew lint. After successful execution of the command, the lint report can be viewed in $project.buildDir/outputs/lint/lint.html
- SonarQube: gradlew sonarqube -Dsonar.host.url=http://localhost:9000/
- Jacoco: gradlew clean connectedAndroidTest test jacocoTestReport. This report can be viewed in app/build/reports/
