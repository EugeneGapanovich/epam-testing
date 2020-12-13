import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddingItemToCartTest {
    private WebDriver webDriver;
    public static final String URL = "https://sila.by/bt/multivarki/REDMOND/rmc-m90";

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        webDriver.get(URL);
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        webDriver.quit();
        webDriver = null;
    }

    @Test
    public void addingItemToCartTest(){
        String expectedItemName = "Мультиварка REDMOND RMC-M90 (код товара 38583)";
        WebElement buttonAddItemToCart = webDriver.findElement(By.xpath("//div[@class='btn_zak']"));
        buttonAddItemToCart.click();
        WebElement item = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tb_popup_korz']/div/div/span")));
        String actualItemName = item.getText();
        System.out.println("Expected имя:" + expectedItemName);
        System.out.println("Actual имя:" + actualItemName);
        Assert.assertEquals(expectedItemName, actualItemName);

    }
}
