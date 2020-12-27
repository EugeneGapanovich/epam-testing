package by.gapanovich.framework.test;

import by.gapanovich.framework.page.LandingPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProductTests extends CommonConditions {
    private static final String LANDING_PAGE_URL = "https://sila.by/";
    private static final String PRODUCT_SEARCH_NAME = "RANDOM-TEXT";

    @Test
      public void searchNonExistentProduct(){
        String expectedSearchResultText = "По запросу «RANDOM-TEXT» ничего не найдено";
        String actualSearchResultText = new LandingPage(driver, LANDING_PAGE_URL)
                .openPage()
                .insertTextInInputField(PRODUCT_SEARCH_NAME)
                .buttonSearchClick()
                .getTextFromViewSearchResultField();
        assertThat(actualSearchResultText, is(equalTo(expectedSearchResultText)));
    }
}
