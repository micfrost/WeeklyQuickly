package dev.micfro.weeklyquikclyapp.controller;

import dev.micfro.weeklyquikclyapp.model.Product;
import dev.micfro.weeklyquikclyapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//@RequestMapping("/product")
public class ProductController {

    public ProductService productService;

    private List<Product> products;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

        List<Product> startProducts = List.of(
                new Product("Apple", "Fresh apples", "/images/product/fruit/apple.webp"),
                new Product("Carrot", "Organic carrots", "/images/product/fruit/apple.webp"),
                new Product("Chicken Breast", "Free-range chicken breast", "/images/product/fruit/apple.webp"),
                new Product("Cheddar Cheese", "Aged cheddar cheese", "/images/product/fruit/apple2.webp"),
                new Product("Baguette", "French baguette", "/images/product/fruit/apple2.webp")
        );

        // Save the list of start products to the database
        for (Product startProduct : startProducts) {
            productService.saveProduct(startProduct);
        }

        this.products = productService.getAllProducts();
    }

    // Show all products
    @GetMapping("/product/list")
    public String products(Model model) {
        model.addAttribute("products", products);
        return "product-list";
    }

    // Add a product
    @GetMapping("/product/add")
    public String addProduct() {
        return "form";
    }

    // Add a product process
    @PostMapping("/product/add")
    public String addProductProcess() {
        return "add-success";
    }

}
