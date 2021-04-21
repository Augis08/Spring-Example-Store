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

    @Autowired
    public ProductService(Map<ProductType, Double> allProductsPrices,
                          Map<ProductType, Integer> productsStocks) {
        this.allProductsPrices = allProductsPrices;
        this.productsStocks = productsStocks;
    }

    public Map<ProductType, Double> getAllProductPrices() {
        return allProductsPrices;
    }

    public Double getPrice(ProductType product) {
        return allProductsPrices.get(product);
    }

    public Double calculateCartPrice(Map<ProductType, Integer> shoppingCart) {
        double sum = 0;
        for (Map.Entry<ProductType, Integer> productTypeAndAmount : shoppingCart.entrySet()) {
            ProductType product = productTypeAndAmount.getKey();
            Integer value = productTypeAndAmount.getValue();
            sum += value * getPrice(product);
        }
        return sum;
    }

    public Map<ProductType, Integer> getAllProductsStock() {
        return productsStocks;
    }

    public void adjustProductQuantity(Map<ProductType, Integer> shoppingCart) {
        new StockValidator().validateStock(productsStocks, shoppingCart);
        shoppingCart.forEach((product, amount) -> productsStocks.put(product, productsStocks.get(product) - amount));
        }
}
