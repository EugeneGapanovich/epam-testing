package by.gapanovich.framework.page;

import by.gapanovich.framework.wait.CustomWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id = "pricers_max")
    private WebElement inputUpperPriceLimitField;

    @FindBy(xpath = "//div[@class='filter_fly']//u[text()='Показать']")
    private WebElement buttonShowList;

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
        CustomWait.waitWebElement(driver, buttonFieldSort).click();
        return this;
    }

    public ListProductPage buttonSortStartWithExpensiveClick(){
        CustomWait.waitWebElement(driver, buttonSortStartWithExpensive).click();
        return this;
    }

    public ListProductPage buttonSortStartWithCheapClick(){
        CustomWait.waitWebElement(driver, buttonSortStartWithCheap).click();
        return this;
    }

    public ListProductPage buttonApplyDiscountsClick(){
        CustomWait.waitWebElement(driver, buttonApplyDiscounts).click();
        return this;
    }

    public List<WebElement> getProductsDiscounts(){
        return driver.findElements(discountFieldLocator);
    }

    public List<WebElement> getProductsPrice(){
       return driver.findElements(priceFieldLocator);
    }

    public ListProductPage insertValueInInputUpperPriceLimitField(String price){
        CustomWait.waitWebElement(driver, inputUpperPriceLimitField).sendKeys(Keys.chord(Keys.CONTROL, "a"), price);
        return this;
    }

    public ListProductPage buttonShowListClick(){
        CustomWait.waitWebElement(driver, buttonShowList).click();
        return this;
    }

    @Override
    public ListProductPage openPage() {
        driver.navigate().to(pageUrl);
        logger.info("List product page opened");
        return this;
    }
}
