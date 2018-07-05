package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {
    @Test
    public void groupModificationTests() {
        app.getNavigationHelper().returnHome();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        app.getContactHelper().editContactByIndex(index);
        ContactData contact=new ContactData()
                .withId(before.get(index).getId())
                .withName("name")
                .withLastname("lastname");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitModification();
        app.getNavigationHelper().returnHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        before.add(contact);
        Assert.assertEquals(new HashSet(before),new HashSet(after));
    }
}
