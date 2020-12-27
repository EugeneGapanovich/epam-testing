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

public class LandingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private String pageUrl;

    @FindBy(xpath = "//div[@class='top']//input[@type='text']")
    private WebElement inputField;

    @FindBy(xpath = "//div[@class='top']//input[@type='submit']")
    private WebElement buttonSearch;

    public LandingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public LandingPage(WebDriver driver, String pageUrl){
        super(driver);
        this.pageUrl = pageUrl;
        PageFactory.initElements(this.driver, this);
    }

    public LandingPage insertTextInInputField(String text){
        CustomWait.waitWebElement(driver, inputField).sendKeys(Keys.chord(Keys.CONTROL, "a"),text);
        return this;
    }

    public SearchResultPage buttonSearchClick(){
        CustomWait.waitWebElement(driver, buttonSearch).click();
        return new SearchResultPage(driver);
    }

    @Override
    public LandingPage openPage() {
        driver.navigate().to(pageUrl);
        logger.info("Landing page opened");
        return this;
    }
}
