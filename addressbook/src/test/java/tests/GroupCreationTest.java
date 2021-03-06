package tests;

import model.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTest extends TestBase {


    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData()
                    .withName(split[0])
                    .withHeader(split[1])
                    .withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testCreateGroup(GroupData group) {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName(group.getName())
                .withHeader(group.getHeader())
                .withFooter(group.getFooter()));
        app.getGroupHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void testCreateGroupShortName() {
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().initGroupCreation();
        GroupData group = new GroupData().withName("n")
                .withHeader("h")
                .withFooter("f");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        System.out.println("testCreateGroupShortName passed");
        Assert.assertEquals(after.size(), before.size() + 1);
        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.withId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    @Test(priority = 3, enabled = true)
    public void testCreateGroupEmpty() {
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData());
        app.getGroupHelper().submit();
        app.getGroupHelper().returnToGroupsPage();
        System.out.println("testCreateGroupEmpty passed");
    }
}
