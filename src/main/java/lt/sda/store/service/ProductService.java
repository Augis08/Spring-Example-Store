package lt.sda.store.service;

import lt.sda.store.model.ProductType;
import lt.sda.store.validator.StockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {
    Map<ProductType, Double> allProductsPrices;
    Map<ProductType, Integer> productsStocks;
    StockValidator stockValidator;


    @Autowired
    public ProductService(Map<ProductType, Double> allProductsPrices,
                          Map<ProductType, Integer> productsStocks,
                          StockValidator stockValidator) {
        this.allProductsPrices = allProductsPrices;
        this.productsStocks = productsStocks;
        this.stockValidator = stockValidator;
    }

    public Map<ProductType, Double> getAllProductPrices() {
        return allProductsPrices;
    }

    public Double getPrice(ProductType product) {
        return allProductsPrices.get(product);
    }

    public Double calculateCartPrice(Map<ProductType, Integer> shoppingCart) {
        stockValidator.validateStock(productsStocks, shoppingCart);
        return shoppingCart
                .entrySet()
                .stream()
                .mapToDouble(productTypeAndAmount
                        -> getPrice(productTypeAndAmount.getKey()) * productTypeAndAmount.getValue())
                .sum();
    }

    public Map<ProductType, Integer> getAllProductsStocks() {
        return productsStocks;
    }

    public void updateProductsStocks(Map<ProductType, Integer> shoppingCart) {
        stockValidator.validateStock(productsStocks, shoppingCart);
        shoppingCart.forEach((product, amount) -> productsStocks.put(product, productsStocks.get(product) - amount));
    }
}
