package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CartPage;
import page.ItemPage;

public class PageObjectTest {
    public WebDriver driver;
    public ItemPage itemPage;
    public CartPage cartPage;

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
        itemPage = new ItemPage(driver);
        itemPage.openPage("https://sila.by/bt/multivarki/REDMOND/rmc-m90");
        String actualItemName = itemPage.buttonAddItemToCartClick().getItemName();
        String expectedItemName = "Мультиварка REDMOND RMC-M90 (код товара 38583)";
        Assert.assertEquals(actualItemName, expectedItemName);
    }

    @Test
    public void searchInputItemTest(){
        itemPage = new ItemPage(driver);
        itemPage.openPage("https://sila.by/bt/multivarki/REDMOND/rmc-m90");
        cartPage = itemPage.buttonAddItemToCartClick();
        cartPage.insertPromocodeValue("RANDOM-PROMOCODE");
        cartPage.buttonSubmitPromocodeClick();

        String expectedPromocodeResult = "Промокод недействителен!";
        String actualPromocodeResult = cartPage.getTextFromPromocodeResultWindow();
        Assert.assertEquals(actualPromocodeResult, expectedPromocodeResult);
    }

}
