package com.example.ConCon.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Cart {
    private ArrayList<Product> produtos;
    private int precoTotal;
     
    public Cart() {}
    public Cart(int precoTotal) {
        this.produtos = new ArrayList<>();
        this.precoTotal = precoTotal;
    }
    public ArrayList<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Product> produtos) {
        this.produtos = produtos;
    }

    public int getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(int precoTotal) {
        this.precoTotal = precoTotal;
    }
}
