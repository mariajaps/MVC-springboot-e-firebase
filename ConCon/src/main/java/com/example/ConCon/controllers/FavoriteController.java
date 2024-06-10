package com.example.ConCon.controllers;

import com.example.ConCon.model.Favorite;
import com.example.ConCon.service.FavoriteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/favorites")
    public List<Favorite> getAllFavorites() throws ExecutionException, InterruptedException {
        return favoriteService.getAllFavorites();
    }

    @PostMapping("/favorites")
    public String addFavorite(@Valid @RequestBody Favorite favorite, BindingResult bindingResult) throws ExecutionException, InterruptedException {
        if (bindingResult.hasErrors()) {
            System.out.println("Error");
            return "Error";
        } else {
            System.out.println();
            System.out.println(favorite);
            return favoriteService.addFavorite(favorite);
        }
    }

    @DeleteMapping("/favorites/{id}")
    public String removeFavorite(@PathVariable String id) throws ExecutionException, InterruptedException {
        return favoriteService.removeFavorite(id);
    }

    @PutMapping("/favorites/{id}")
    public String updateFavorite(@PathVariable String id, @RequestBody Favorite favorite) throws ExecutionException, InterruptedException {
        return favoriteService.updateFavorite(id, favorite);
    }
}
