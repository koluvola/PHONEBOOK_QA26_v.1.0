package com.telran.tests;

import com.telran.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    public String email = "Mon447233@mail.com";

    public String password = "Mon12$447233";


    @Test
    public void loginTest() throws InterruptedException {
        app.getUser().openLogRegForm();
        app.getUser().fillRegLogForm(new User().withEmail(email).withPassword(password));
        app.getUser().clickLoginButton();
        app.getUser().delay(2000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

}
