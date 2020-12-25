package by.gapanovich.framework.test;

import by.gapanovich.framework.model.Product;
import by.gapanovich.framework.model.PromoCode;
import by.gapanovich.framework.page.ItemPage;
import by.gapanovich.framework.service.ProductCreator;
import by.gapanovich.framework.service.PromoCodeCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartTests extends CommonConditions {
    private Product product = ProductCreator.withNameAndUrlFromProperty();
    private PromoCode promoCode = PromoCodeCreator.withValueFromProperty();

    @Test
    public void addItemToCartTest(){
        String expectedItemName = "Мультиварка REDMOND RMC-M90 (код товара 38583)";
        String actualItemName = new ItemPage(driver, product.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .getItemName();
        assertThat(actualItemName, is(equalTo(expectedItemName)));
    }

    @Test
    public void enterIncorrectPromoCodeInCartTest(){
        String expectedPromoCodeResult = "Промокод недействителен!";
        String actualPromoCodeResult = new ItemPage(driver, product.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .insertPromocodeValue(promoCode.getValue())
                .buttonSubmitPromocodeClick()
                .getTextFromPromocodeResultWindow();
        assertThat(actualPromoCodeResult, is(equalTo(expectedPromoCodeResult)));
    }

    @Test
    public void deleteItemFromCartTest(){
        String expectedCartFieldText = "В корзине пусто";
        String actualCartFieldText = new ItemPage(driver, product.getUrl())
                .openPage()
                .buttonAddItemToCartClick()
                .buttonDeleteItemFromCartClick()
                .buttonAlertWindowAcceptClick()
                .getTextFromCartField();
        assertThat(actualCartFieldText, is(equalTo(expectedCartFieldText)));
    }

}
