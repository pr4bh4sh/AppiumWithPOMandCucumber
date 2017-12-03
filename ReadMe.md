## How to execute/run project
#### With Cucumber
1. Clone project- ```git clone git@github.com:pr4bh4sh/AppiumWithPOM.git```
2. Execute test - ```./gradlew cucumber```
3. Open result - ```open reports/cucumber/cucumber-html-report/index.html```

#### With TestNG
1. Clone project- ```git clone git@github.com:pr4bh4sh/AppiumWithPOM.git```
2. Execute test - ```./gradlew testNG```
3. Open result - ```open reports/extent.html```

### Note
- For this project Appium server is started from command line manually. Appium server can be stared programatically from
`AppiumDriverLocalService`
- In current implementation ScreenShots are taken only in case of failure.
- Pages does not have all locator, only the required one to complete the scenario are collected.
- HomePage can be broken down into 4 sub-pages.(Browse, Groups, Activity, MyProfile). Similar for other pages
- Step definition are written in single file for this project, they should be written per functionality/screen.
- When executing task testNG, generated report(Extent report) has some configuration issues. Because of this the test suite is marked as pass even when the test has failed. Could not find out where though.

### Possible Enhancement
- Analytic automation
- Integrate with Flick for
  1. Video recording
  2. Animated GIF creation