package com.tl.example.tests;

import com.tl.example.model.ContactData;
import com.tl.example.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ContactCreationTest extends TestBase {

    @Test
    public void testCreateContact() {
        app.getNavigationHelper().returnHome();
        int before = app.getContactHelper().getContactCount();
        File photo = new File("src/test/resources/cat.jpg");
        System.out.println(photo.exists());
        //HOMEWORK
        String groupName= new String("newGroup");
        if(!app.getGroupHelper().isGroupExist(groupName)){
            app.getNavigationHelper().goToGroupsPage();
            app.getGroupHelper().initGroupCreation();
            app.getGroupHelper().fillGroupForm(new GroupData().withName(groupName));
            app.getContactHelper().submit(By.name("submit"));
            app.getNavigationHelper().returnHome();
        }
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData()
                .withName("AnyLongName")
                .withLastname("AnyLongLastName")
                .withMobile("8(985)999-99-99")
                .withEmail("myemail@gmail.com")
                .withPhoto(photo)
                .withGroup(groupName));
        app.getContactHelper().submit(By.name("submit"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void testCreateEmptyContact() {
        app.getNavigationHelper().returnHome();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData());
        app.getContactHelper().submit(By.name("submit"));
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }
}
