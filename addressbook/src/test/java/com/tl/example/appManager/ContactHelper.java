package com.tl.example.appManager;

import com.tl.example.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
    }

    public void initContactCreation() {
        click(By.xpath("//*[@href='edit.php']"));
    }

    public void selectContact() {
        click(By.xpath("//*[@type='checkbox']"));
    }

    public void selectAllContacts() {
        click(By.xpath("//*[@onclick='MassSelection()']"));
    }

    public void initContactDeletion() {
        click(By.xpath("//*[@value='Delete']"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initModifyContact() {
        click(By.xpath("//*[@title='Edit']"));
    }

    public void submitContactModification() {
        click(By.cssSelector("[name=update]"));
    }

    public void submit() {
        click(By.name("submit"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact() {
        initContactCreation();
        fillContactForm(new ContactData("name","lastname","89999999999","mail@mail.ru"));
        submit();
    }
}
