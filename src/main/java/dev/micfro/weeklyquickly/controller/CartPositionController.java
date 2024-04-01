package dev.micfro.weeklyquickly.controller;

import dev.micfro.weeklyquickly.service.CartPositionService;
import dev.micfro.weeklyquickly.service.CartService;
import dev.micfro.weeklyquickly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartPositionController {

    private final ProductService productService;
    private final CartPositionService cartPositionService;
    private final CartService cartService;


    @Autowired
    public CartPositionController(ProductService productService, CartPositionService cartPositionService, CartService cartService) {
        this.productService = productService;
        this.cartPositionService = cartPositionService;
        this.cartService = cartService;



    }


    @GetMapping("/cartposition-list")
    public String showCartPositions(Model model) {
        model.addAttribute("cartpositions", cartPositionService.findAllCartPositions());
        return "cartposition-list";
    }

}
