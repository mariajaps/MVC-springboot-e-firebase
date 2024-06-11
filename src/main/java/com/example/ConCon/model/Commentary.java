package com.example.ConCon.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Commentary { // Changed from 'Favorite' to 'Commentary'
    private List<Product> productsCommentary; // Changed from 'produtosFavorite' to 'productsCommentary'
    private int nameCommentaryList; // Changed from 'nameFavoriteList' to 'nameCommentaryList'

    // Default constructor
    public Commentary() {
        this.productsCommentary = new ArrayList<>();
    }

    // Getter and setter for 'productsCommentary'
    public List<Product> getProductsCommentary() {
        return new ArrayList<>(productsCommentary); // Return a copy of the list to prevent direct modification
    }

    public void setProductsCommentary(List<Product> productsCommentary) {
        this.productsCommentary = new ArrayList<>(productsCommentary); // Set a copy of the provided list to prevent direct modification
    }

    // Getter and setter for 'nameCommentaryList'
    public int getNameCommentaryList() {
        return nameCommentaryList;
    }

    public void setNameCommentaryList(int nameCommentaryList) {
        this.nameCommentaryList = nameCommentaryList;
    }
}
