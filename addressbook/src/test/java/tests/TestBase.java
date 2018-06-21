package tests;

import appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(GroupCreationTest.class);
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.start();

    }
    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Start " +m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop "+m.getName());
    }
}
