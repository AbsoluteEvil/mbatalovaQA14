package com.tl.example.tests;

import com.tl.example.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
    @Test
    public void groupModificationTests(){
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initModifyContact();
        app.getContactHelper().fillContactForm(new ContactData("Maria", "Batalova", "8(985)968-89-08", "m4shk4@gmail.com"));
        app.getContactHelper().submitContactModification();
        app.returnHome();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);
    }
}
