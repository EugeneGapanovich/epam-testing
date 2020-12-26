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
    private static final String PAGE_URL = "https://sila.by/av/televizory";

    @FindBy (className = "sorted_btns_select")
    private WebElement buttonFieldSort;

    @FindBy(className = "btn4")
    private WebElement buttonSortStartWithExpensive;

    @FindBy(className = "btn9")
    private WebElement buttonSortStartWithCheap;

    @FindBy(className = "btn6")
    private WebElement buttonApplyDiscounts;

    /*@FindBy(xpath = "//div[@class='tov_prew']/p")
    private WebElement viewDiscountField;*/

    public ListProductPage(WebDriver driver){
        super(driver);
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
        return driver.findElements(By.xpath("//div[@class='tov_prew']/p"));
    }

    public List<WebElement> getProductsPrice(){
       return driver.findElements(By.xpath("//div[@class='price']/div/b[1]"));
    }

    @Override
    public ListProductPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    private WebElement waitWebElement(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
