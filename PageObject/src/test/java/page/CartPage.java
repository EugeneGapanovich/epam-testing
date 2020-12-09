package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='tb_popup_korz']/div/div/span")
    private WebElement item;

    @FindBy(xpath = "//input[@id='promocode']")
    private WebElement inputField;

    @FindBy(xpath = "//div[@class='btn_promocode_popup active']")
    private WebElement buttonSubmitPromocode;

    @FindBy(xpath = "//div[@class='popup_alert_text']/p")
    private WebElement promocodeResultWindow;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getItemName(){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(item)).getText();
    }

    public void insertPromocodeValue(String promocode){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(inputField)).sendKeys(promocode);
    }

    public void buttonSubmitPromocodeClick(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(buttonSubmitPromocode)).click();
    }

    public String getTextFromPromocodeResultWindow(){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(promocodeResultWindow)).getText();
    }
}
