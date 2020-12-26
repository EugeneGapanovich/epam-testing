package by.gapanovich.framework.test;

import by.gapanovich.framework.page.LandingPage;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProductTests extends CommonConditions {

    @Test
      public void searchNonExistentProduct(){
        String expectedSearchResultText = "По запросу «RANDOM-TEXT» ничего не найдено";
        String actualSearchResultText = new LandingPage(driver, "https://sila.by/")
                .openPage()
                .insertTextInInputField("RANDOM-TEXT")
                .buttonSearchClick()
                .getTextFromViewSearchResultField();
        assertThat(actualSearchResultText, is(equalTo(expectedSearchResultText)));
    }
}
