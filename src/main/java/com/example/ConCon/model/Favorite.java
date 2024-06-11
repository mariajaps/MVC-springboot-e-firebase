package com.example.ConCon.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Favorite {
    private List<Product> produtosFavorite;
    private int nameFavoriteList;

    public Favorite() {}
    public Favorite(int nameFavoriteList) {
        this.nameFavoriteList = nameFavoriteList;
        this.produtosFavorite = new ArrayList<>();
    }

    public List<Product> getProdutosFavorite() {
        return new ArrayList<>(produtosFavorite);
    }

    public void setProdutosFavorite(List<Product> produtosFavorite) {
        this.produtosFavorite = new ArrayList<>(produtosFavorite);
    }

    public int getNameFavoriteList() {
        return nameFavoriteList;
    }

    public void setNameFavoriteList(int nameFavoriteList) {
        this.nameFavoriteList = nameFavoriteList;
    }
}
