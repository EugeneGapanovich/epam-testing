package by.gapanovich.framework.test;

import by.gapanovich.framework.driver.DriverManager;
import by.gapanovich.framework.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        DriverManager.closeDriver();
    }
}
