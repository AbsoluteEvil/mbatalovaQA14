import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase {
    @Test
    public void groupDeletionTest() {
        goToGroupsPage();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();
    }

}
