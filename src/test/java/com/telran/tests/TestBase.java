package com.telran.tests;

import com.telran.application.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.start();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
