package by.gapanovich.framework.page;

import by.gapanovich.framework.wait.CustomWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[text()='Мультиварка REDMOND RMC-M90 ']")
    private WebElement item;

    @FindBy(id = "promocode")
    private WebElement inputField;

    @FindBy(xpath = "//div[@class='btn_promocode_popup active']")
    private WebElement buttonSubmitPromoCode;

    @FindBy(xpath = "//div[@class='popup_alert_text']/p")
    private WebElement promoCodeResultWindow;

    @FindBy(xpath = "//div[@class='kol']/u")
    private WebElement buttonDelete;

    @FindBy(xpath = "//div[@class='plus']")
    private WebElement buttonIncreaseNumberOfItems;

    @FindBy(xpath = "//div[@class='kol']/span")
    private WebElement viewCountItems;

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getItemName(){
        return CustomWait.waitWebElement(driver, item).getText();
    }

    public CartPage insertPromoCodeValue(String promoCode){
        CustomWait.waitWebElement(driver, inputField).sendKeys(Keys.chord(Keys.CONTROL, "a"), promoCode);
        return this;
    }

    public CartPage buttonSubmitPromoCodeClick(){
        CustomWait.waitWebElement(driver, buttonSubmitPromoCode).click();
        return this;
    }

    public String getTextFromPromoCodeResultWindow(){
        return CustomWait.waitWebElement(driver, promoCodeResultWindow).getText();
    }

    public CartPage buttonDeleteItemFromCartClick(){
        CustomWait.waitWebElement(driver, buttonDelete).click();
        return this;
    }

    public ItemPage buttonAlertWindowAcceptClick(){
        driver.switchTo().alert().accept();
        return new ItemPage(driver);
    }

    public CartPage buttonIncreaseNumberOfItemsClick(){
        CustomWait.waitWebElement(driver, buttonIncreaseNumberOfItems).click();
        return this;
    }

    public String getTextFromViewCountItems(){
        return CustomWait.waitWebElement(driver, viewCountItems).getText();
    }

    @Override
    public CartPage openPage() {
        return this;
    }
}
