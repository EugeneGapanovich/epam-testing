package by.gapanovich.framework.model;

import java.util.Objects;

public class Product {
    private String name;
    private String url;
    private String promoCode;

    public Product(String name, String url){
        this.name = name;
        this.url = url;
    }

    public Product(String name, String url, String promoCode){
        this.name = name;
        this.url = url;
        this.promoCode = promoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(name, product.name) &&
                Objects.equals(url, product.url) &&
                Objects.equals(promoCode, product.promoCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, promoCode);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", promoCode='" + promoCode + '\'' +
                '}';
    }
}
