package com.tl.example.tests;

import com.tl.example.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateContact() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Maria", "Batalova", "8(985)968-89-08", "m4shk4@gmail.com"));
        app.getContactHelper().submit();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }

    @Test
    public void testCreateEmptyContact() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().submit();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }
}
