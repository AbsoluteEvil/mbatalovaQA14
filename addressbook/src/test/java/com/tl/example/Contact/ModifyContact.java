package com.tl.example.Contact;

import com.tl.example.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyContact extends TestBase {
    @Test
    public void groupModificationTests(){
        int before = app.getContactCount();
        app.initModifyContact();
        app.fillContactForm(new ContactData("Maria", "Batalova", "8(985)968-89-08", "m4shk4@gmail.com"));
        app.submitContactModification();
        app.returnHome();
        int after = app.getGroupCount();
        Assert.assertEquals(after,before);
    }
}
