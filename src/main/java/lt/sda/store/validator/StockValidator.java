package lt.sda.store.validator;

import lt.sda.store.model.ProductType;

import java.util.Map;

public class StockValidator {

    public void validateStock(Map<ProductType, Integer> productsStocks,
                              Map<ProductType, Integer> shoppingCart) {
        for (ProductType productType : shoppingCart.keySet()){
            if (productsStocks.get(productType) < shoppingCart.get(productType)) {
                throw new RuntimeException("Insufficient quantity of " + productType);
            }
        }
    }
}
