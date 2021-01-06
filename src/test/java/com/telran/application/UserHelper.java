package com.telran.application;

import com.telran.application.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);

    }

    public void openLogRegForm(){
        click(By.cssSelector("[href='/login']"));
    }

    public void fillRegLogForm(String email, String password){
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);

    }
    public void clickRegButton(){
        click(By.xpath("//*[text()=' Registration']"));
    }
}
