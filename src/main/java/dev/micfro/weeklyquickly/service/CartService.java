package dev.micfro.weeklyquickly.service;

import dev.micfro.weeklyquickly.model.Cart;
import dev.micfro.weeklyquickly.repository.CartRepository;
import dev.micfro.weeklyquickly.repository.CustomerRepository;
import dev.micfro.weeklyquickly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }



    // CRUD

    // CREATE

    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }


    // READ

    public Cart findCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public Cart findCartById(Integer id) {
        return cartRepository.findById(Long.valueOf(id)).orElse(null);
    }

    // find all carts
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    // UPDATE

    // DELETE


}
