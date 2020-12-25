package by.gapanovich.framework.model;

import java.util.Objects;

public class Product {
    private String name;
    private String url;

    public Product(String name, String url){
        this.name = name;
        this.url = url;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(name, product.name) &&
                Objects.equals(url, product.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
