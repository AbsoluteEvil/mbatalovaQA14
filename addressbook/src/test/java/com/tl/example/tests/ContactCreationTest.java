package com.tl.example.tests;

import com.tl.example.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateContact() {
        app.getNavigationHelper().returnHome();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("AnyLongName", "AnyLongLastName", "8(985)999-99-99", "myemail@gmail.com"));
        app.getContactHelper().submit();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }

    @Test
    public void testCreateEmptyContact() {
        app.getNavigationHelper().returnHome();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().submit();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }
}
