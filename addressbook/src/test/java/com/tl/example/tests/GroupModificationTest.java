package com.tl.example.tests;

import com.tl.example.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {
    @Test
    public void groupModificationTests(){
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initModifyGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("1","2","3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);
    }
}
