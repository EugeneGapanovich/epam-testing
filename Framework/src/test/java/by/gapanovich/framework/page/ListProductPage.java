package by.gapanovich.framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ListProductPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private String pageUrl;

    @FindBy (className = "sorted_btns_select")
    private WebElement buttonFieldSort;

    @FindBy(className = "btn4")
    private WebElement buttonSortStartWithExpensive;

    @FindBy(className = "btn9")
    private WebElement buttonSortStartWithCheap;

    @FindBy(className = "btn6")
    private WebElement buttonApplyDiscounts;

    private By discountFieldLocator = By.xpath("//div[@class='tov_prew']/p");
    private By priceFieldLocator = By.xpath("//div[@class='price']/div/b[1]");

    public ListProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ListProductPage(WebDriver driver, String pageUrl){
        super(driver);
        this.pageUrl = pageUrl;
        PageFactory.initElements(this.driver, this);
    }

    public ListProductPage buttonFieldSortClick(){
        waitWebElement(buttonFieldSort).click();
        return this;
    }

    public ListProductPage buttonSortStartWithExpensiveClick(){
        waitWebElement(buttonSortStartWithExpensive).click();
        return this;
    }

    public ListProductPage buttonSortStartWithCheapClick(){
        waitWebElement(buttonSortStartWithCheap).click();
        return this;
    }

    public ListProductPage buttonApplyDiscountsClick(){
        waitWebElement(buttonApplyDiscounts).click();
        return this;
    }

    public List<WebElement> getProductsDiscounts(){
        return driver.findElements(discountFieldLocator);
    }

    public List<WebElement> getProductsPrice(){
       return driver.findElements(priceFieldLocator);
    }

    @Override
    public ListProductPage openPage() {
        driver.navigate().to(pageUrl);
        logger.info("List product page opened");
        return this;
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
