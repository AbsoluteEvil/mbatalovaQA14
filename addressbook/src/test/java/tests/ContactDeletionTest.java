package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void firstContactDeletionTest() {
        app.getNavigationHelper().returnHome();
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getGroupHelper().initDeletion();
        app.getGroupHelper().acceptAlert();
        app.getNavigationHelper().returnHome();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before-1);
    }

    @Test
    public void allContactsDeletionTest() {
        app.getNavigationHelper().returnHome();
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact();
        }
        app.getContactHelper().selectAllContacts();
        app.getGroupHelper().initDeletion();
        app.getGroupHelper().acceptAlert();
        Assert.assertEquals(app.getContactHelper().getContactCount(), 0);
    }

    @Test
    public void contactDeletionByIndexTest() {
        app.getNavigationHelper().returnHome();
        if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContactByIndex(before.size() - 1);
        app.getGroupHelper().initDeletion();
        app.getGroupHelper().acceptAlert();
        app.getNavigationHelper().returnHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before,after);
    }
}
