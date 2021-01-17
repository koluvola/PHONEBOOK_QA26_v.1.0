package com.telran.application;

import com.telran.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void clearContacts() {
        LocalStorage local = ((WebStorage) wd).getLocalStorage();
        String token = local.getItem("token");
        System.out.println(token);
        try {
            URL url = new URL("https://contacts-telran.herokuapp.com/api/clear");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            con.addRequestProperty("Authorization", token);
            con.connect();

            con.getInputStream();
            wd.navigate().refresh();
            delay(2000);
        } catch (Exception e) {
            e.printStackTrace();


        }

    }

    public void clearContactsWeb() {
        while (!wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty()) {
            List<WebElement> contacts = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));

            contacts.get(0).click();
            delay(500);
            wd.findElement(By.xpath("//button[.='Remove']")).click();
            delay(2000);
        }

    }

    public void clickAddButton() {
        click(By.cssSelector("[href='/add']"));

    }

    public void clickContactButton() {
        click(By.cssSelector("[href='/contacts']"));
    }

    public void clickSaveBatton() {
        click(By.xpath("//button[contains(.,'Save')]"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());


    }

    public void fillContactForm1(String name, String lname, String phone, String emal, String address, String desc) {
        type(By.cssSelector("[placeholder='Name']"), name);
        type(By.cssSelector("[placeholder='Last Name']"), lname);
        type(By.cssSelector("[placeholder='email']"), emal);
        type(By.cssSelector("[placeholder='Phone']"), phone);
        type(By.cssSelector("[placeholder='Address']"), address);
        type(By.cssSelector("[placeholder='description']"), desc);


    }

    public int getContactSize() {
        return wd.findElements(By.cssSelector("h2")).size();
    }

    public boolean isNameExist(String name) {
        List<WebElement> elements = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : elements) {
            if (el.getText().equals(name)) {
                return true;
            }
        }
        return false;

    }
}

