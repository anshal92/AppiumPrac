# AppiumPrac

Framework details:
  - **Language:** Java 11
  - **Build Tool:** Gradle
  - **TestRunner:** TestNG
  - **Test Framework:** Appium java 9.1.0 -> Appium 2


How to run:
  - First build project using ```./gradlew clean build -x test --debug --stacktrace```
  - To run the test first configure "src/test/resources/AppiumProperties.config" with the following:
      - default.version = version of android
      - default.deviceName = device name using "adb devices"
      - default.androidHome = Android Home path using "echo $ANDROID_HOME"
      - default.androidSdkRoot = Android SDK path using "echo $ANDROID_SDK_ROOT"
      - default.javaHome = Java Home Path using "echo $JAVA_HOME"
  - The UI test case would require a apk of coindcx in "src/test/resources/apk/" path. Please add it.
  - Run the UI test by clicking on the run icon beside the FirstTest Class.
  - To Coding questions are in the following class and can be run directly:
      - Compare 2 Arrays - CompareArray.java
      - Print alternate chars from String - PrintAltChar.java
      - Print the frequency of each character in an array. - PrintFreqOfChar.java

How to see reports:
  - Report can be found on the following location post running tests:
    
    ```testNgReport = ${userprojectDir}/build/reports/tests/test/index.html```
