import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {

    @Test
    public void testCreateContact() {
        openAddressbook();
        goToAddPage();
        fillContactForm("Maria", "Batalova", "8(985)968-89-08", "m4shk4@gmail.com");
        submit();
        System.out.println("testCreateContact passed");
    }

    @Test
    public void testCreateEmptyContact() {
        openAddressbook();
        goToAddPage();
        submit();
        System.out.println("testCreateEmptyContact passed");
    }
}
