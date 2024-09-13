package com.argentrose;

import java.util.Objects;
import java.util.StringJoiner;

public class Product {
    public static final int MINIMUM_QUALITY = 0;
    public static final int MAXIMUM_QUALITY = 50;
    public static final int SELLIN_LAST_DAY = 0;
    public static final int QUALITY_FACTOR_BY_EXPIRATION = 2;
    private final String description;
    private int sellIn;
    private int quality;

    public Product(String description, int sellIn, int quality) {
        this.description = description;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void decreaseQualityBy(int decrement) {
        if(isExpired()){
            decrement = decrement * QUALITY_FACTOR_BY_EXPIRATION;
        }
        quality = Math.max(MINIMUM_QUALITY, quality - decrement);
    }

    public void increaseQualityBy(int increment) {
        if(isExpired()){
           increment = increment * QUALITY_FACTOR_BY_EXPIRATION;
        }
        quality = Math.min(MAXIMUM_QUALITY, quality + increment);
    }

    public void dropQualityToMinimum() {
        quality = MINIMUM_QUALITY;
    }

    public void decreaseSellIn() {
        sellIn -= 1;
    }

    public boolean isExpired() {
        return sellIn < SELLIN_LAST_DAY;
    }

    public boolean sellInIsLessThan(int days) {
        return sellIn < days;
    }

    public boolean isAgedBrie() {
        return description.equals("Aged Brie");
    }

    public boolean isLanzaroteWine() {
        return description.equals("Lanzarote Wine");
    }

    public boolean isTheatrePasses() {
        return description.equals("Theatre Passes");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return sellIn == product.sellIn && quality == product.quality && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, sellIn, quality);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("description='" + description + "'")
                .add("sellIn=" + sellIn)
                .add("quality=" + quality)
                .toString();
    }

}
