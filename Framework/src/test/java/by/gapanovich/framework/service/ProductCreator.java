package by.gapanovich.framework.service;

import by.gapanovich.framework.model.Product;

public class ProductCreator {
    public static final String TESTDATA_PRODUCT_NAME = "testdata.product.name";
    public static final String TESTDATA_PRODUCT_URL = "testdata.product.url";
    public static final String TESTDATA_PRODUCT_PROMOCODE = "testdata.product.promocode";

    public static Product withNameAndUrlFromProperty(){
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_NAME),
                TestDataReader.getTestData(TESTDATA_PRODUCT_URL),
                TestDataReader.getTestData(TESTDATA_PRODUCT_PROMOCODE));
    }
}
