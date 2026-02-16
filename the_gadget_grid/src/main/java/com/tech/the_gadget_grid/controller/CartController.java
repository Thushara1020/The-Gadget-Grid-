package com.tech.the_gadget_grid.controller;

import com.tech.the_gadget_grid.entity.Cart;
import com.tech.the_gadget_grid.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @GetMapping("/user/{userId}")
    public List<Cart> getCartItems(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @DeleteMapping("/remove/{cartId}")
    public String remove(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
        return "Item removed from cart!";
    }
}