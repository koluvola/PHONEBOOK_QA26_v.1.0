package com.telran.tests;

import com.telran.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationTest() {

        app.getUser().openLogRegForm();
        int i = (int) ((System.currentTimeMillis() / 1000) / 3600);
        String email = "Mon" + i+6 + "@mail.com";
        String password = "Mon12$" + i+6;
        System.out.println(email + " " + password);
        app.getUser().fillRegLogForm(new User().withEmail(email).withPassword(password));
        //app.getUser().dilay(60000);
        app.getUser().clickRegButton();
        app.getUser().delay(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));


    }
}
