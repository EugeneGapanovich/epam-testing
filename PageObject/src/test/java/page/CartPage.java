package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Page {
    public static final int WAIT_TIME_SECONDS = 10;

    @FindBy(xpath = "//*[text()='Мультиварка REDMOND RMC-M90 ']")
    private WebElement item;

    @FindBy(xpath = "//input[@id='promocode']")
    private WebElement inputField;

    @FindBy(xpath = "//div[@class='btn_promocode_popup active']")
    private WebElement buttonSubmitPromocode;

    @FindBy(xpath = "//div[@class='popup_alert_text']/p")
    private WebElement promocodeResultWindow;

    public CartPage(WebDriver driver){
        super(driver);
    }

    @Override
    public CartPage openPage(String url) {
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

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIME_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
