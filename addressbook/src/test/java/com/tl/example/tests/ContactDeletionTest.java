package com.tl.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void firstContactDeletionTest() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.acceptAlert();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before,after-1);
    }

    @Test
    public void allContactsDeletionTest() {
        app.getContactHelper().selectAllContacts();
        app.getContactHelper().initContactDeletion();
        app.acceptAlert();
        Assert.assertEquals(app.getContactHelper().getContactCount(),0);
    }
}
