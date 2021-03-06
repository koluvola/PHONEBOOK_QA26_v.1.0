package com.telran.application;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    String browser;
    ContactHelper contact;
    UserHelper user;
    WebDriver wd;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public UserHelper getUser() {
        return user;
    }

    public void init() {

        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);

        wd.get("https://contacts-app.tobbymarshall815.vercel.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new UserHelper(wd);
        contact = new ContactHelper(wd);
    }

    public void stop() {
        wd.quit();
    }
}
