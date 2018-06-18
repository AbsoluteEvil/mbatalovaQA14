package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
