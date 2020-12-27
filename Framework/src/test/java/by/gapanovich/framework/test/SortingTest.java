package by.gapanovich.framework.test;

import by.gapanovich.framework.page.ListProductPage;
import by.gapanovich.framework.util.DoubleUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SortingTest extends CommonConditions {

    private static final String TVS_URL = "https://sila.by/av/televizory";
    private static final String MULTICOOKER_URL = "https://sila.by/bt/multivarki";
    private static final String UPPER_PRICE_LIMIT = "250.00";

    @Test
    public void sortStartWithCheapTest(){
        List<WebElement> products = new ListProductPage(driver, TVS_URL)
                .openPage()
                .buttonFieldSortClick()
                .buttonSortStartWithCheapClick()
                .getProductsPrice();

        List<WebElement> copyProducts = products;
        copyProducts.sort(Comparator.comparing(product -> DoubleUtil.parseStringToDouble(product.getText())));

        boolean areTwoElementsEqual = true;
        for (int i = 0; i < products.size(); i++) {
            if (DoubleUtil.parseStringToDouble(products.get(i).getText()) !=
                   DoubleUtil.parseStringToDouble(copyProducts.get(i).getText())) {
                areTwoElementsEqual = false;
                break;
            }
        }

        Assert.assertTrue(areTwoElementsEqual);
    }

    @Test
    public void sortStartWithExpensiveTest(){
        List<WebElement> products = new ListProductPage(driver, TVS_URL)
                .openPage()
                .buttonFieldSortClick()
                .buttonSortStartWithExpensiveClick()
                .getProductsPrice();

        List<WebElement> copyProducts = products;
        copyProducts.sort(Comparator.comparing(product -> DoubleUtil.parseStringToDouble(product.getText())));
        Collections.reverse(copyProducts);

        boolean areTwoElementsEqual = true;
        for (int i = 0; i < products.size(); i++) {
            if (DoubleUtil.parseStringToDouble(products.get(i).getText()) !=
                    DoubleUtil.parseStringToDouble(copyProducts.get(i).getText())) {
                areTwoElementsEqual = false;
                break;
            }
        }

        Assert.assertTrue(areTwoElementsEqual);
    }

    @Test
    public void sortProductsWithDiscountsTest(){
        List<WebElement> discounts = new ListProductPage(driver, TVS_URL)
                .openPage()
                .buttonApplyDiscountsClick()
                .buttonFieldSortClick()
                .buttonSortStartWithExpensiveClick()
                .getProductsDiscounts();

        assertThat(discounts.get(0).getText(),is(equalTo("СКИДКА 28%")));
        assertThat(discounts.get(discounts.size()-1).getText(), is(equalTo("СКИДКА 22%")));
    }

    @Test
    public void sortProductsByUpperPriceLimit(){
        List<WebElement> products = new ListProductPage(driver, MULTICOOKER_URL)
                .openPage()
                .insertValueInInputUpperPriceLimitField(UPPER_PRICE_LIMIT)
                .buttonShowListClick()
                .buttonFieldSortClick()
                .buttonSortStartWithExpensiveClick()
                .getProductsPrice();

        Assert.assertTrue(DoubleUtil.parseStringToDouble(UPPER_PRICE_LIMIT) >=
                DoubleUtil.parseStringToDouble(products.get(0).getText()));
    }
}
