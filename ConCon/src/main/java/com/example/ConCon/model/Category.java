package com.example.ConCon.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Category {
    private String nomeCategoria;
    private List<Product> produtos;

    //public Category(String nomeCategoria, List<Product> produtos) {
        //this.nomeCategoria = nomeCategoria;
        //this.produtos = new ArrayList<>(produtos);
    //}
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<Product> getProdutos() {
        return new ArrayList<>(produtos);
    }

    public void setProdutos(List<Product> produtos) {
        this.produtos = new ArrayList<>(produtos);
    }
}
