package lt.sda.store.configuration;

import lt.sda.store.model.ProductType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProductConfig {

    @Bean
    public Map<ProductType, Double> allProductsPrices(ProductPrice productPrice) {
        Map<ProductType, Double> allProductPrices = new HashMap<>();
        allProductPrices.put(ProductType.APPLE, productPrice.getApplePrice());
        allProductPrices.put(ProductType.CARROT, productPrice.getCarrotPrice());
        allProductPrices.put(ProductType.ORANGE, productPrice.getOrangePrice());
        allProductPrices.put(ProductType.POTATO, productPrice.getPotatoPrice());
        return allProductPrices;
    }

    @Bean
    public Map<ProductType, Integer> productsStocks (ProductStock productStock){
        Map<ProductType, Integer> productsStocks = new HashMap<>();
        productsStocks.put(ProductType.APPLE, productStock.getApple());
        productsStocks.put(ProductType.CARROT, productStock.getCarrot());
        productsStocks.put(ProductType.ORANGE, productStock.getOrange());
        productsStocks.put(ProductType.POTATO, productStock.getPotato());
        return productsStocks;
    }
}
