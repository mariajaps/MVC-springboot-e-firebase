package com.example.ConCon.controllers;

import com.example.ConCon.model.Product;
import com.example.ConCon.model.User;
import com.example.ConCon.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
@RestController
@Controller
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;
    public ProductController(ProductService productService) {
            this.productService = productService;
    }

    @GetMapping("/product")
    public List<Product> getAll()throws ExecutionException, InterruptedException {
        return productService.getProduct();
    }
    @PostMapping("/createP")
    public String create(@Valid @RequestBody Product products , BindingResult bindingResult ) throws ExecutionException, InterruptedException {
        if (bindingResult.hasErrors()) {

            System.out.println("error");
            return "Error";
        }
        else {
            System.out.println();
            System.out.println(products);
            return productService.createProduct(products);
        }

    }
    @DeleteMapping("/deleteP")
    public String deleteProduct(@RequestBody String nomeProduto) throws ExecutionException, InterruptedException {
        return productService.deleteProduct(nomeProduto);
    }
    @PutMapping("/alterarP")
    public String updateProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.updateProduct(product);
    }
}
