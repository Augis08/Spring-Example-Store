package lt.sda.store.controller;

import lt.sda.store.model.ProductType;
import lt.sda.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Map<ProductType, Double> getAllPrices() {
        return productService.getAllProductPrices();
    }

    @GetMapping(value = "/{product}")
    public Double getPrice(@PathVariable ProductType product) {
        return productService.getPrice(product);
    }

    @PostMapping(value = "/cart")
    public Double calculateCartPrice(@RequestBody Map<ProductType, Integer> shoppingCart) {
        return productService.calculateCartPrice(shoppingCart);
    }

    @PostMapping(value = "/buy")
    public Map<ProductType, Integer> buyProducts(@RequestBody Map<ProductType, Integer> shoppingCart) {
        productService.updateProductsStocks(shoppingCart);
        return productService.getAllProductsStocks();
    }

    @GetMapping(value = "/stocks")
    public Map<ProductType, Integer> getAllProductsStocks() {
        return productService.getAllProductsStocks();
    }
}
