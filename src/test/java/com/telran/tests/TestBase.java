package com.telran.tests;

import com.telran.application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {


    ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        app.init();
    }
    @BeforeMethod
    public void startLogger(Method method){
        logger.info("Start test: "+method.getName());
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method method){
        logger.info("Stop test: "+method.getName());
    }


}
