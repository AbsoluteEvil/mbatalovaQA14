package appManager;

import model.ContactData;
import org.openqa.selenium.WebElement;
import tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        if (contactData.getGroup() != null) {
            groupCheckAndSelect(contactData);
        }
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
//        attach(By.name("photo"), contactData.getPhoto());

    }

    public void groupCheckAndSelect(ContactData contactData) {
        if (isElementPresent(By.name("new_group")) &&
                isElementPresent(By.xpath("//select[@name='new_group']/option[text()='" + contactData.getGroup() + "']"))) {
            new Select(driver.findElement(By.name("new_group")))
                    .selectByVisibleText(contactData.getGroup());
        } else if (isElementPresent(By.name("new_group"))) {
            TestBase.app.getGroupHelper().createGroupWithThisName(contactData.getGroup());
            TestBase.app.getNavigationHelper().returnHome();
            initContactCreation();
            new Select(driver.findElement(By.name("new_group")))
                    .selectByVisibleText(contactData.getGroup());
        }
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

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact() {
        initContactCreation();
        fillContactForm(new ContactData()
                .withName("name")
                .withLastname("lastname")
                .withMobile("89999999999")
                .withEmail("mail@mail.ru"));
        submit();
    }


    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath("./td[2]")).getText();
            String name = element.findElement(By.xpath("./td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withName(name).withLastname(lastname);
            contacts.add(contact);
        }
        return contacts;

    }

    public void selectContactByIndex(int index) {
        driver.findElements(By.xpath("//*[@type='checkbox']")).get(index).click();
    }

    public void editContactByIndex(int index) {
        index += 2;
        click(By.xpath("//tr[" + index + "]/td[8]"));
    }
}
