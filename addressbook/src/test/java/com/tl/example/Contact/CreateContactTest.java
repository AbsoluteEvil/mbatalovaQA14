package com.tl.example.Contact;

import com.tl.example.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {

    @Test
    public void testCreateContact() {
        int before = app.getContactCount();
        app.initContactCreation();
        app.fillContactForm(new ContactData("Maria", "Batalova", "8(985)968-89-08", "m4shk4@gmail.com"));
        app.submit();
        int after = app.getContactCount();
        Assert.assertEquals(after,before+1);
    }

    @Test
    public void testCreateEmptyContact() {
        int before = app.getContactCount();
        app.initContactCreation();
        app.submit();
        int after = app.getContactCount();
        Assert.assertEquals(after,before+1);
    }
}
