package com.argentrose;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArgentRoseStore {

    private final List<Product> products;

    public ArgentRoseStore() {
        products = new ArrayList<>();
    }

    public void add(Product... products){
        Collections.addAll(this.products, products);
    }

    public void update() {
        products.forEach(this::update);
    }

    private void update(Product product) {
        product.decreaseSellIn();
        updateQuality(product);
    }

    private void updateQuality(Product product) {
        if(product.isAgedBrie()){
            updateAgedBrieQuality(product);
        }
        else if(product.isLanzaroteWine()){
            updateLanzaroteWineQuality(product);
        }
        else if(product.isTheatrePasses()){
            updateTheatrePassesQuality(product);
        }
        else{
            updateRegularProductQuality(product);
        }
    }

    private void updateRegularProductQuality(Product product) {
        product.decreaseQualityBy(2);
    }

    private void updateTheatrePassesQuality(Product product) {
        if(product.isExpired()){
            product.dropQualityToMinimum();
        }else if(product.sellInIsLessThan(5)){
            product.increaseQualityBy(3);
        }
        else {
            product.increaseQualityBy(1);
        }
    }

    private void updateLanzaroteWineQuality(Product product) {
        product.increaseQualityBy(2);
    }

    private void updateAgedBrieQuality(Product product) {
        product.increaseQualityBy(1);
    }
}
