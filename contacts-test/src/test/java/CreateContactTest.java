//importLib
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateContactTest {
 //MakeDriver
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  //beforeEveryTestOpenChromeDriver
  public void setUp() throws Exception {
    driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateContact() throws Exception {
    //openSite
    driver.get("http://localhost/addressbook/");
    //login
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.id("LoginForm")).submit();
    //goToAddPage
    driver.findElement(By.linkText("add new")).click();
    //fillFirstname
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("Maria");
    //fillLastname
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Batalova");
    //submit
    driver.findElement(By.name("submit")).click();
   }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    //checkThatElementWasAdded
    driver.findElement(By.linkText("home page")).click();
  }
/* For future projects
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  */
}
