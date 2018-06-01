package com.tl.example.tests;

import com.tl.example.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testCreateGroupLongName(){
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("Name")
                .withHeader("Header")
                .withFooter("Footer"));
        app.getGroupHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before+1);

    }
    @Test
    public void testCreateGroupShortName(){
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("n")
                .withHeader("h")
                .withFooter("f"));
        app.getGroupHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        System.out.println("testCreateGroupShortName passed");
    }

    @Test (priority = 3,enabled = true)
    public void testCreateGroupEmpty(){
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData());
        app.getGroupHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        System.out.println("testCreateGroupEmpty passed");
    }
}
