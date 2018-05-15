package com.tl.example.Group;

import com.tl.example.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {
    @Test
    public void groupDeletionTest() {
        app.goToGroupsPage();
        int before = app.getGroupCount();
        app.selectGroup();
        app.deleteGroup();
        app.returnToGroupsPage();
        int after = app.getGroupCount();
        Assert.assertEquals(after, before-1);
    }

}
