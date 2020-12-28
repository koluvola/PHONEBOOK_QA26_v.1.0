package com.telran;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationTest(){

        openLogRegForm();
        String email= "Mon"+System.currentTimeMillis()+"mail.com";
        String password="Mon12$"+System.currentTimeMillis();
        //remember data for login!!!
        System.out.println(email + " " + password);
        fillRegLogForm(email, "Test12345$");
        clickRegButton();
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));


    }
}
