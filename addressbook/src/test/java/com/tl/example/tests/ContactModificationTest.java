package com.tl.example.tests;

import com.tl.example.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
    @Test
    public void groupModificationTests() {
        app.getNavigationHelper().returnHome();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initModifyContact();
        app.getContactHelper().fillContactForm(new ContactData()
                .setName("Maria")
                .setLastname("Batalova")
                .setMobile("8(985)968-89-08")
                .setEmail("m4shk4@gmail.com")
        );
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnHome();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
