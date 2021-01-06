package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationTest(){

        app.getUser().openLogRegForm();
        String email= "Mon"+System.currentTimeMillis()+"@mail.com";
        String password="Mon12$"+System.currentTimeMillis();
        System.out.println(email + " " + password);
        app.getUser().fillRegLogForm(email, "Test12345$");
        app.getUser().clickRegButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));


    }
}
