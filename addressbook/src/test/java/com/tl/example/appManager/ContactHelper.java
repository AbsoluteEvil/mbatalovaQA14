package com.tl.example.appManager;

import com.tl.example.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper {
    private WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void fillContactForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getName());
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void initContactCreation() {
        driver.findElement(By.xpath("//*[@href='edit.php']")).click();
    }

    public void selectContact() {
        driver.findElement(By.xpath("//*[@type='checkbox']")).click();
    }

    public void selectAllContacts() {
        driver.findElement(By.xpath("//*[@onclick='MassSelection()']")).click();
    }

    public void initContactDeletion() {
        driver.findElement(By.xpath("//*[@value='Delete']")).click();

    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initModifyContact() {
        driver.findElement(By.xpath("//*[@title='Edit']")).click();
    }

    public void submitContactModification() {
        driver.findElement(By.cssSelector("[name=update]")).click();
    }

    public void submit() {
        driver.findElement(By.name("submit")).click();
    }
}
