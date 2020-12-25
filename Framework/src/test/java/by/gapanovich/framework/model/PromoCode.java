package by.gapanovich.framework.model;

import java.util.Objects;

public class PromoCode {
    private String value;

    public PromoCode(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PromoCode promoCode = (PromoCode) object;
        return Objects.equals(value, promoCode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                "value='" + value + '\'' +
                '}';
    }
}
