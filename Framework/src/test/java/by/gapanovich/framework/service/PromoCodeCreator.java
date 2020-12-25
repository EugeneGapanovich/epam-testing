package by.gapanovich.framework.service;

import by.gapanovich.framework.model.Product;
import by.gapanovich.framework.model.PromoCode;

public class PromoCodeCreator {
    public static final String TESTDATA_PROMOCODE_VALUE = "testdata.promocode.value";

    public static PromoCode withValueFromProperty(){
        return new PromoCode(TestDataReader.getTestData(TESTDATA_PROMOCODE_VALUE));
    }
}
