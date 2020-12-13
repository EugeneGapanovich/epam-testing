package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends Page{
    private final int WAIT_TIME_SECONDS = 10;

    @FindBy(xpath = "//div[@class='btn_zak']")
    private WebElement buttonAddItemToCart;

    public ItemPage(WebDriver driver){
        super(driver);
    }

    @Override
    public ItemPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public CartPage buttonAddItemToCartClick(){
        new WebDriverWait(driver, WAIT_TIME_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(buttonAddItemToCart)).click();
        return new CartPage(driver);
    }
}
