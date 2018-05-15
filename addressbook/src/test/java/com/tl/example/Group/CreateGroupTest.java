package com.tl.example.Group;

import com.tl.example.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase {

    @Test
    public void testCreateGroupLongName(){
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("name", "header", "footer"));
        app.submit();
        app.returnToGroupsPage();
        int after = app.getGroupCount();

        Assert.assertEquals(after,before+1);

    }
    @Test
    public void testCreateGroupShortName(){
        app.goToGroupsPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("n", "h", "f"));
        app.submit();
        app.returnToGroupsPage();
        System.out.println("testCreateGroupShortName passed");
    }
    @Test (priority = 3,enabled = true)
    public void testCreateGroupEmpty(){
        app.goToGroupsPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("", "", ""));
        app.submit();
        app.returnToGroupsPage();
        System.out.println("testCreateGroupEmpty passed");
    }
}
