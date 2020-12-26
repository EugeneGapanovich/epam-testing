package by.gapanovich.framework.test;

import by.gapanovich.framework.page.ListProductPage;
import by.gapanovich.framework.util.DoubleUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SortingTest extends CommonConditions {

    @Test
    public void sortStartWithCheapTest(){
        List<WebElement> products = new ListProductPage(driver)
                .openPage()
                .buttonFieldSortClick()
                .buttonSortStartWithCheapClick()
                .getProductsPrice();

        assertThat(DoubleUtil.parseStringToDouble(products.get(0).getText()),
                is(lessThanOrEqualTo(DoubleUtil.parseStringToDouble(products.get(1).getText()))));

        assertThat(DoubleUtil.parseStringToDouble(products.get(1).getText()),
                is(lessThanOrEqualTo(DoubleUtil.parseStringToDouble(products.get(products.size()-1).getText()))));

        assertThat(DoubleUtil.parseStringToDouble(products.get(products.size()-2).getText()),
                is(lessThanOrEqualTo(DoubleUtil.parseStringToDouble(products.get(products.size()-1).getText()))));
    }

    @Test
    public void sortStartWithExpensiveTest(){
        List<WebElement> products = new ListProductPage(driver)
                .openPage()
                .buttonFieldSortClick()
                .buttonSortStartWithExpensiveClick()
                .getProductsPrice();

        assertThat(DoubleUtil.parseStringToDouble(products.get(0).getText()),
                is(greaterThanOrEqualTo(DoubleUtil.parseStringToDouble(products.get(1).getText()))));

        assertThat(DoubleUtil.parseStringToDouble(products.get(1).getText()),
                is(greaterThanOrEqualTo(DoubleUtil.parseStringToDouble(products.get(products.size()-1).getText()))));

        assertThat(DoubleUtil.parseStringToDouble(products.get(products.size()-2).getText()),
                is(greaterThanOrEqualTo(DoubleUtil.parseStringToDouble(products.get(products.size()-1).getText()))));
    }

    @Test
    public void sortProductsWithDiscountsTest(){
        List<WebElement> discounts = new ListProductPage(driver)
                .openPage()
                .buttonApplyDiscountsClick()
                .buttonFieldSortClick()
                .buttonSortStartWithExpensiveClick()
                .getProductsDiscounts();

        assertThat(discounts.get(0).getText(),is(equalTo("СКИДКА 28%")));
        assertThat(discounts.get(discounts.size()-1).getText(), is(equalTo("СКИДКА 22%")));
    }

}
