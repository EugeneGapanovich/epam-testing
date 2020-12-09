package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='btn_zak']")
    private WebElement buttonAddItemToCart;

    public ItemPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url){
        driver.get(url);
    }

    public CartPage buttonAddItemToCartClick(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(buttonAddItemToCart)).click();
        return new CartPage(driver);
    }
}
