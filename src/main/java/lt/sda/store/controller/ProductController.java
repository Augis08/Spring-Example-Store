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
        productService.adjustProductQuantity(shoppingCart);
        return productService.calculateCartPrice(shoppingCart);
    }

    @GetMapping(value = "/stocks")
    public Map<ProductType, Integer> getAllProductsStock() {
        return productService.getAllProductsStocks();
    }
 }
