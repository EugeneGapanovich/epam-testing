package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.ItemPage;

public class PageObjectTest {
    private static  WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void addItemToCartTest(){
        String expectedItemName = "Мультиварка REDMOND RMC-M90 (код товара 38583)";
        String actualItemName = new ItemPage(driver)
                .openPage("https://sila.by/bt/multivarki/REDMOND/rmc-m90")
                .buttonAddItemToCartClick()
                .getItemName();
        Assert.assertEquals(actualItemName, expectedItemName);
    }

    @Test
    public void enterIncorrectPromocodeTest(){
        String expectedPromocodeResult = "Промокод недействителен!";
        String actualPromocodeResult = new ItemPage(driver)
                .openPage("https://sila.by/bt/multivarki/REDMOND/rmc-m90")
                .buttonAddItemToCartClick()
                .insertPromocodeValue("RANDOM-PROMOCODE")
                .buttonSubmitPromocodeClick()
                .getTextFromPromocodeResultWindow();
        Assert.assertEquals(actualPromocodeResult, expectedPromocodeResult);
    }

}
