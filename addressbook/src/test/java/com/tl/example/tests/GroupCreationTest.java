package com.tl.example.tests;

import com.tl.example.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testCreateGroupLongName(){
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("name", "header", "footer"));
        app.getContactHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();

        Assert.assertEquals(after,before+1);

    }
    @Test
    public void testCreateGroupShortName(){
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("n", "h", "f"));
        app.getContactHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        System.out.println("testCreateGroupShortName passed");
    }
    @Test (priority = 3,enabled = true)
    public void testCreateGroupEmpty(){
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
        app.getContactHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        System.out.println("testCreateGroupEmpty passed");
    }
}
