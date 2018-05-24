package com.tl.example.tests;

import com.tl.example.model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateContact() {
        app.getNavigationHelper().returnHome();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData()
                .setName("AnyLongName")
                .setLastname("AnyLongLastName")
                .setMobile("8(985)999-99-99")
                .setEmail("myemail@gmail.com"));
        app.getContactHelper().submit(By.name("submit"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }

    @Test
    public void testCreateEmptyContact() {
        app.getNavigationHelper().returnHome();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().submit(By.name("submit"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }
}
