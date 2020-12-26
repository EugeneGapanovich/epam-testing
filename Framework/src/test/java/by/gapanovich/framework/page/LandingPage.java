package by.gapanovich.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final static String PAGE_URL = "https://sila.by/";

    @FindBy(xpath = "//div[@class='top']//input[@type='text']")
    private WebElement inputField;

    @FindBy(xpath = "//div[@class='top']//input[@type='submit']")
    private WebElement buttonSearch;

    public LandingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LandingPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public LandingPage insertTextInInputField(String text){
        waitWebElement(inputField).sendKeys(Keys.chord(Keys.CONTROL, "a"),text);
        return this;
    }

    public SearchResultPage buttonSearchClick(){
        waitWebElement(buttonSearch).click();
        return new SearchResultPage(driver);
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
