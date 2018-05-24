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
        submit(By.xpath("//*[@href='edit.php']"));
    }

    public void selectContact() {
        submit(By.xpath("//*[@type='checkbox']"));
    }

    public void selectAllContacts() {
        submit(By.xpath("//*[@onclick='MassSelection()']"));
    }

    public void initContactDeletion() {
        submit(By.xpath("//*[@value='Delete']"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initModifyContact() {
        submit(By.xpath("//*[@title='Edit']"));
    }

    public void submitContactModification() {
        submit(By.cssSelector("[name=update]"));
    }

    public void submit(By locator) {
        click(locator);
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact() {
        initContactCreation();
        fillContactForm(new ContactData()
                .setName("name")
                .setLastname("lastname")
                .setMobile("89999999999")
                .setEmail("mail@mail.ru"));
        submit(By.name("submit"));
    }
}
