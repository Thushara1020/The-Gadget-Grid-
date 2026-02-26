package com.tech.the_gadget_grid.service;

import com.tech.the_gadget_grid.entity.Cart;
import com.tech.the_gadget_grid.entity.Product;
import com.tech.the_gadget_grid.entity.User;
import com.tech.the_gadget_grid.repository.CartRepository;
import com.tech.the_gadget_grid.repository.ProductRepository;
import com.tech.the_gadget_grid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository; // අලුතින් add කරන්න

    @Autowired
    private UserRepository userRepository; // අලුතින් add කරන්න

    public Cart addToCart(Cart cart) {
        Product fullProduct = productRepository.findById(cart.getProduct().getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User fullUser = userRepository.findById(cart.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        cart.setProduct(fullProduct);
        cart.setUser(fullUser);


        return cartRepository.save(cart);
    }

    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUser_UserId(userId);
    }

    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}