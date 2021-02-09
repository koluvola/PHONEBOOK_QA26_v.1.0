package com.telran.application;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class HelperBase {


    WebDriver wd;

    //TakesScreenshot takesScreenshot= ((TakesScreenshot) wd);
    ///File screenFile=takesScreenshot.getScreenshotAs(OutputType.FILE);

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void delay(int milles) {
        try {
            Thread.sleep(milles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void takeScreenShot(String pathToFile) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenShot = new File(pathToFile + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp, screenShot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);

    }

    public void click(By locator) {
        wd.findElement(locator).click();

    }
}
