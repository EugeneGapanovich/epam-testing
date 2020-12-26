package by.gapanovich.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @FindBy(xpath = "//input[@id='promocode']")
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

    @Override
    public CartPage openPage() {
        return null;
    }

    public String getItemName(){
        return waitWebElement(item).getText();
    }

    public CartPage insertPromoCodeValue(String promoCode){
        waitWebElement(inputField).sendKeys(promoCode);
        return this;
    }

    public CartPage buttonSubmitPromoCodeClick(){
        waitWebElement(buttonSubmitPromoCode).click();
        return this;
    }

    public String getTextFromPromoCodeResultWindow(){
        return waitWebElement(promoCodeResultWindow).getText();
    }

    public CartPage buttonDeleteItemFromCartClick(){
        waitWebElement(buttonDelete).click();
        return this;
    }

    public ItemPage buttonAlertWindowAcceptClick(){
        driver.switchTo().alert().accept();
        return new ItemPage(driver);
    }

    public CartPage buttonIncreaseNumberOfItemsClick(){
        waitWebElement(buttonIncreaseNumberOfItems).click();
        return this;
    }

    public String getTextFromViewCountItems(){
        return waitWebElement(viewCountItems).getText();
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
