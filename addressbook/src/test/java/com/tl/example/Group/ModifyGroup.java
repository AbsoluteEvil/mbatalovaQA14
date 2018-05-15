package com.tl.example.Group;

import com.tl.example.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyGroup extends TestBase {
    @Test
    public void groupModificationTests(){
        int before = app.getGroupCount();
        app.selectGroup();
        app.initModifyGroup();
        app.fillGroupForm(new GroupData("1","2","3"));
        app.submitGroupModification();
        app.returnToGroupsPage();
        int after = app.getGroupCount();
        Assert.assertEquals(after,before);
    }
}
