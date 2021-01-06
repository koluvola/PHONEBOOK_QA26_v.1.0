package com.telran.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper user;

    public UserHelper getUser() {
        return user;
    }

    public void start() {
        wd=new ChromeDriver();
        wd.get("https://contacts-app.tobbymarshall815.vercel.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user= new UserHelper(wd);
    }

    public  void stop() {
        wd.quit();
    }
}
