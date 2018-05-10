import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase{

    @Test
    public void testCreateGroupLongName(){
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("name", "header", "footer");
        submit();
        returnToGroupsPage();
        System.out.println("testCreateGroupLongName passed");
    }
    @Test
    public void testCreateGroupShortName(){
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("n", "h", "f");
        submit();
        returnToGroupsPage();
        System.out.println("testCreateGroupShortName passed");
    }
    @Test (priority = 3,enabled = true)
    public void testCreateGroupEmpty(){
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm("", "", "");
        submit();
        returnToGroupsPage();
        System.out.println("testCreateGroupEmpty passed");
    }
}
