package com.tl.example;

import com.tl.example.Contact.ContactData;
import com.tl.example.Group.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver driver;

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void returnToGroupsPage() {
        driver.findElement(By.xpath("//a[@href='group.php']")).click();
    }

    public void submit() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData group) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(group.getName());
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(group.getHeader());
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(group.getFooter());
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void goToGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void login(String login, String pass) {
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(login);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void openSite(String url) {
        driver.get(url);
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

    public void stop() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void deleteGroup() {
        driver.findElement(By.name("delete")).click();
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

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initModifyGroup() {
        driver.findElement(By.xpath("//*[value='Edit group']")).click();
    }

    public void submitGroupModification() {
        driver.findElement(By.cssSelector("[name=update]")).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void initModifyContact() {
        driver.findElement(By.xpath("//*[@title='Edit']")).click();
    }

    public void submitContactModification() {
        driver.findElement(By.cssSelector("[name=update]")).click();
    }

    public void returnHome() {
        driver.findElement(By.xpath("//a[@href='./']")).click();
    }
}
