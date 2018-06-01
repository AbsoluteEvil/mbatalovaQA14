package com.tl.example.appManager;

import com.tl.example.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupsPage() {
        click(By.xpath("//a[@href='group.php']"));
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void initModifyGroup() {
        click(By.xpath("//*[@value='Edit group']"));
    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new GroupData()
                .withName("Name")
                .withHeader("Header")
                .withFooter("Footer"));
        submitModification();
        returnToGroupsPage();
    }

    public void selectAllGroups() {
        List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for ( WebElement el : els ) {
            if ( !el.isSelected() ) {
                el.click();
            }
        }
    }

    public boolean isGroupExist(final String groupName) {
        return isElementPresent(By.xpath("//select[@name='to_group']/option[text() = '" + groupName + "']"));
    }
}
