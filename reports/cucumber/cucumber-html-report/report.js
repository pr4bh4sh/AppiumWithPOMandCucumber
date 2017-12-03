$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("productListing.feature");
formatter.feature({
  "line": 1,
  "name": "Product Listing",
  "description": "",
  "id": "product-listing",
  "keyword": "Feature"
});
formatter.before({
  "duration": 31532548855,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Listing a product by taking its picture",
  "description": "",
  "id": "product-listing;listing-a-product-by-taking-its-picture",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "I login using \"google\" as \"Test Acct\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I want to sell a product",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I take a picture of it",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I select the category as \"Everything Else\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I set following details for the product",
  "rows": [
    {
      "cells": [
        "name",
        "condition",
        "description",
        "price"
      ],
      "line": 9
    },
    {
      "cells": [
        "Test",
        "Used",
        "rarely used",
        "50.25"
      ],
      "line": 10
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I submit and approve my listing",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I should be able to view the listing \"Test\" under \"Recent\" of category \"Everything Else\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "google",
      "offset": 15
    },
    {
      "val": "Test Acct",
      "offset": 27
    }
  ],
  "location": "ProductListSteps.java:32"
});
formatter.result({
  "duration": 5151611922,
  "status": "passed"
});
formatter.match({
  "location": "ProductListSteps.java:44"
});
formatter.result({
  "duration": 4114878043,
  "status": "passed"
});
formatter.match({
  "location": "ProductListSteps.java:48"
});
formatter.result({
  "duration": 6093580746,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Everything Else",
      "offset": 26
    }
  ],
  "location": "ProductListSteps.java:53"
});
formatter.result({
  "duration": 13231826929,
  "error_message": "org.openqa.selenium.NoSuchElementException: Can\u0027t locate an element by this strategy: Locator map: \n- native content: \"By.chained({By.className: android.widget.ListView})\" \n- html content: \"by id or name \"categoryContainer\"\"\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:102)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:61)\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.findElement(\u003cgenerated\u003e)\n\tat com.assignment.appium.pages.BasePage.scrollInsideElementByText(BasePage.java:49)\n\tat com.assignment.appium.pages.AddProductToSellPage.selectCategory(AddProductToSellPage.java:73)\n\tat steps.ProductListSteps.lambda$new$3(ProductListSteps.java:54)\n\tat ✽.And I select the category as \"Everything Else\"(productListing.feature:7)\nCaused by: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction@149debbb (tried for 1 second(s) with 500 MILLISECONDS interval)\n\tat org.openqa.selenium.support.ui.FluentWait.timeoutException(FluentWait.java:263)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:231)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.waitFor(AppiumElementLocator.java:76)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.findElement(AppiumElementLocator.java:95)\n\tat io.appium.java_client.pagefactory.interceptors.InterceptorOfASingleElement.intercept(InterceptorOfASingleElement.java:61)\n\tat io.appium.java_client.android.AndroidElement$$EnhancerByCGLIB$$b598166c.findElement(\u003cgenerated\u003e)\n\tat com.assignment.appium.pages.BasePage.scrollInsideElementByText(BasePage.java:49)\n\tat com.assignment.appium.pages.AddProductToSellPage.selectCategory(AddProductToSellPage.java:73)\n\tat steps.ProductListSteps.lambda$new$3(ProductListSteps.java:54)\n\tat steps.ProductListSteps$$Lambda$4/1168019749.accept(Unknown Source)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:497)\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\n\tat cucumber.runtime.java.Java8StepDefinition.execute(Java8StepDefinition.java:115)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat cucumber.runtime.Runtime.run(Runtime.java:122)\n\tat cucumber.api.cli.Main.run(Main.java:36)\n\tat cucumber.api.cli.Main.main(Main.java:18)\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.chained({By.className: android.widget.ListView})\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.6.0\u0027, revision: \u00276fbf3ec767\u0027, time: \u00272017-09-27T15:28:36.4Z\u0027\nSystem info: host: \u0027MacBookWorm.local\u0027, ip: \u0027fe80:0:0:0:1477:8d55:f789:1cac%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.13.1\u0027, java.version: \u00271.8.0_40\u0027\nDriver info: driver.version: AndroidDriver\n\tat io.appium.java_client.pagefactory.bys.builder.ByChained.findElement(ByChained.java:72)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:348)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:58)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\n\tat io.appium.java_client.pagefactory.bys.ContentMappedBy.findElement(ContentMappedBy.java:36)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:348)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:58)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\n\tat io.appium.java_client.android.AndroidDriver$$FastClassBySpringCGLIB$$6daf998c.invoke(\u003cgenerated\u003e)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:747)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor.invoke(MethodBeforeAdviceInterceptor.java:52)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)\n\tat org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)\n\tat io.appium.java_client.events.DefaultAspect.doAround(DefaultAspect.java:532)\n\tat sun.reflect.GeneratedMethodAccessor14.invoke(Unknown Source)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:497)\n\tat org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:643)\n\tat org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:632)\n\tat org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:70)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)\n\tat org.springframework.aop.aspectj.AspectJAfterAdvice.invoke(AspectJAfterAdvice.java:47)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)\n\tat org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:92)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\n\tat io.appium.java_client.android.AndroidDriver$$EnhancerBySpringCGLIB$$e9a15142.findElement(\u003cgenerated\u003e)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator.lambda$0(AppiumElementLocator.java:96)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$$Lambda$155/313149846.get(Unknown Source)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:150)\n\tat io.appium.java_client.pagefactory.AppiumElementLocator$WaitingFunction.apply(AppiumElementLocator.java:1)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:208)\n\t... 25 more\n",
  "status": "failed"
});
formatter.match({
  "location": "ProductListSteps.java:57"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ProductListSteps.java:65"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Test",
      "offset": 38
    },
    {
      "val": "Recent",
      "offset": 51
    },
    {
      "val": "Everything Else",
      "offset": 72
    }
  ],
  "location": "ProductListSteps.java:69"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 2454581424,
  "status": "passed"
});
});