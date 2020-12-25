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
    private WebElement buttonSubmitPromocode;

    @FindBy(xpath = "//div[@class='popup_alert_text']/p")
    private WebElement promocodeResultWindow;

    @FindBy(xpath = "//div[@class='kol']/u")
    private WebElement buttonDelete;

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

    public CartPage insertPromocodeValue(String promocode){
        waitWebElement(inputField).sendKeys(promocode);
        return this;
    }

    public CartPage buttonSubmitPromocodeClick(){
        waitWebElement(buttonSubmitPromocode).click();
        return this;
    }

    public String getTextFromPromocodeResultWindow(){
        return waitWebElement(promocodeResultWindow).getText();
    }

    public CartPage buttonDeleteItemFromCartClick(){
        waitWebElement(buttonDelete).click();
        return this;
    }

    public ItemPage buttonAlertWindowAcceptClick(){
        driver.switchTo().alert().accept();
        return new ItemPage(driver);
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
