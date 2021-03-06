package tests;


import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ContactCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData()
                    .withName(split[0])
                    .withLastname(split[1])
                    .withEmail(split[2])
                    .withMobile(split[3])
                    .withGroup(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testCreateContact(ContactData contacts) {
        app.getNavigationHelper().returnHome();
        int before = app.getContactHelper().getContactCount();
        // File photo = new File("src/test/resources/cat.jpg");
        // System.out.println(photo.exists());
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData()
                .withName(contacts.getName())
                .withLastname(contacts.getLastname())
                .withMobile(contacts.getMobile())
                .withEmail(contacts.getEmail())
                .withGroup(contacts.getGroup()));
        app.getContactHelper().submit();
        app.getNavigationHelper().returnHome();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void testCreateContactShortName() {
        app.getNavigationHelper().returnHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        ContactData contact = new ContactData()
                .withName("n")
                .withLastname("l")
                ;
        app.getContactHelper().fillContactForm(contact);
        app.getGroupHelper().submit();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        int max = 0;
        for (ContactData c : after) {
            if (c.getId() > max) {
                max = c.getId();
            }
        }
        contact.withId(max);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
