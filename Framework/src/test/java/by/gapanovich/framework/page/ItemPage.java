package by.gapanovich.framework.page;

import by.gapanovich.framework.wait.CustomWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private String productUrl;

    @FindBy(xpath = "//div[@class='btn_zak']")
    private WebElement buttonAddItemToCart;

    @FindBy(xpath = "//div[@class='top']//span[@class='top_korz']")
    private WebElement cartField;

    public ItemPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ItemPage(WebDriver driver, String productUrl){
        super(driver);
        this.productUrl = productUrl;
        PageFactory.initElements(this.driver, this);
    }

    public CartPage buttonAddItemToCartClick(){
       CustomWait.waitWebElement(driver, buttonAddItemToCart).click();
       return new CartPage(driver);
    }

    public String getTextFromCartField(){
        return CustomWait.waitWebElement(driver, cartField).getText();
    }

    @Override
    public ItemPage openPage() {
        driver.navigate().to(productUrl);
        logger.info("Item page opened");
        return this;
    }
}
