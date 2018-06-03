package com.tl.example.tests;

import com.tl.example.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]split = line.split(";");
            list.add(new Object[]{ new GroupData()
                    .withName(split[0])
                    .withHeader(split[1])
                    .withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testCreateGroupLongName(GroupData group){
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
