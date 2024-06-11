package com.example.ConCon.controllers;

import com.example.ConCon.model.Cart;
import com.example.ConCon.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class CartController {
    @Autowired
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public List<Cart> getAll() throws ExecutionException, InterruptedException {
        return cartService.getCarts();
    }

    @PostMapping("/createC")
    public String create(@Valid @RequestBody Cart cart, BindingResult bindingResult) throws ExecutionException, InterruptedException {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "Error";
        } else {
            System.out.println();
            System.out.println(cart);
            return cartService.createCart(cart);
        }
    }

    @DeleteMapping("/deleteC")
    public String deleteCart(@RequestBody String cartId) throws ExecutionException, InterruptedException {
        return cartService.deleteCart(cartId);
    }

    @PutMapping("/alterarC")
    public String updateCart(@RequestBody Cart cart) throws ExecutionException, InterruptedException {
        return cartService.updateCart(cart);
    }
}
