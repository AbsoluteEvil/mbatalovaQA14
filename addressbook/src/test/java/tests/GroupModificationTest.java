package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {
    @Test
    public void groupModificationTests(){
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup();
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initModifyGroup();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("newName")
                .withFooter("newHeader")
                .withFooter("newFooter"));
        app.getGroupHelper().submitModification();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);
    }
}