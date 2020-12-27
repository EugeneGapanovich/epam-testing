package by.gapanovich.framework.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public static WebElement waitWebElement(WebDriver driver,WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
