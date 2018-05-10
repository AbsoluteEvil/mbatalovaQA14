import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Elements {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void elementsTest(){
        driver.get("https://www.google.ru/");
       driver.findElement(By.xpath("//*[@id='gsr']")).click();
        driver.navigate().refresh();
        driver.findElement(By.id("gsr")).click();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        //exit
        driver.quit();
    }
}
