package tests;

import appManager.GroupHelper;
import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {
    @Test
    public void groupModificationTestsByIndex(){
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        if(!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup();
        }
        int index = before.size() - 1;
        app.getGroupHelper().selectGroupByIndex(index);
        app.getGroupHelper().initModifyGroup();
        GroupData group=new GroupData()
                .withId(before.get(index).getId())
                .withName("newName")
                .withHeader("newHeader")
                .withFooter("newFooter");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitModification();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        before.add(group);
        System.out.println("Before "+ before);
        System.out.println("After "+ after);
        Assert.assertEquals(new HashSet(before),new HashSet(after));
    }
}
