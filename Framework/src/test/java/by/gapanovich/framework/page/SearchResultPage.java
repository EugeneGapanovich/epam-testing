package by.gapanovich.framework.page;

import by.gapanovich.framework.wait.CustomWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage{

    @FindBy(className = "not_find")
    private WebElement viewSearchResultField;

    public SearchResultPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getTextFromViewSearchResultField(){
        return CustomWait.waitWebElement(driver, viewSearchResultField).getText();
    }

    @Override
    protected SearchResultPage openPage() {
        return this;
    }
}
