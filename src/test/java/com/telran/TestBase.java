package com.telran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd=new ChromeDriver();
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void click(By locator){
        wd.findElement(locator).click();

    }
    public void openLogRegForm(){
        click(By.cssSelector("[href='/login']"));
    }

    public void type(By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);

    }
    public void fillRegLogForm(String email, String password){
        type(By.xpath("//input[1]"),email);
        type(By.xpath("//input[2]"),password);

    }
    public void clickRegButton(){
        click(By.xpath("//*[text()=' Registration']"));
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }



    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
