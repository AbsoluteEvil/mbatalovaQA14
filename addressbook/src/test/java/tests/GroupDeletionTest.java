package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {
    @Test
    public void groupDeletionTest() {
        app.getNavigationHelper().goToGroupsPage();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before-1);
    }

    @Test
    public void allGroupsDeletionTest() {
        app.getNavigationHelper().goToGroupsPage();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup();
        }
        app.getGroupHelper().selectAllGroups();
        app.getGroupHelper().deleteGroup();
        Assert.assertEquals(app.getGroupHelper().getGroupCount(), 0);
    }
}