import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

    @Test
    public void firstContactDeletionTest() {
        selectContact();
        deleteContact();
    }

    @Test
    public void allContactsDeletionTest() {
        selectAllContacts();
        deleteContact();
    }

    @Test
    public void ContactsDeletionByMailTest() {
        selectContactByMail("m4shk4@gmail.com");
        deleteContact();
    }
}
