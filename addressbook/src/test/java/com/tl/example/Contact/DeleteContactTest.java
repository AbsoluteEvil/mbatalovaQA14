package com.tl.example.Contact;

import com.tl.example.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

    @Test
    public void firstContactDeletionTest() {
        int before = app.getContactCount();
        app.selectContact();
        app.initContactDeletion();
        app.acceptAlert();
        int after = app.getContactCount();
        Assert.assertEquals(before,after-1);
    }

    @Test
    public void allContactsDeletionTest() {
        app.selectAllContacts();
        app.initContactDeletion();
        app.acceptAlert();
        Assert.assertEquals(app.getContactCount(),0);
    }
}
