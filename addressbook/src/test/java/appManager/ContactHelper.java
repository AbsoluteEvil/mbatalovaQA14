package appManager;

import model.ContactData;
import tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData) {
        if (isElementPresent(By.name("new_group"))&&
                isElementPresent(By.xpath("//select[@name='new_group']/option[text()='"+contactData.getGroup()+"']"))) {
            new Select(driver.findElement(By.name("new_group")))
                    .selectByVisibleText(contactData.getGroup());
        } else if (isElementPresent(By.name("new_group"))){
             TestBase.app.getGroupHelper().createGroupWithThisName(contactData.getGroup());
            TestBase.app.getNavigationHelper().returnHome();
            initContactCreation();
            new Select(driver.findElement(By.name("new_group")))
                    .selectByVisibleText(contactData.getGroup());
        }
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
//        attach(By.name("photo"), contactData.getPhoto());

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


}
