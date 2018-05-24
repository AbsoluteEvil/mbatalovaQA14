package com.tl.example.tests;

import com.tl.example.appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.start();

    }
    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
