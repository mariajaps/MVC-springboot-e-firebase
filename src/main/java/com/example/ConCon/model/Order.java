package com.example.ConCon.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Order {
    private int OderId;
    private List<Product> produtosOrder;
    private int precoOder;
    public Order() {}
    public Order (int OderId, List<Product> produtosOrder,int precoOder){
        this.OderId = OderId;
        this.produtosOrder = new ArrayList<Product>();
        this.precoOder = precoOder;

    }

    public int getOderId() {
        return OderId;
    }

    public void setOderId(int oderId) {
        OderId = oderId;
    }

    public List<Product> getProdutosOrder() {
        return new ArrayList<>(produtosOrder);
    }

    public void setProdutosOrder(List<Product> produtosOrder) {
        this.produtosOrder = new ArrayList<>(produtosOrder);
    }

    public int getPrecoOder() {
        return precoOder;
    }

    public void setPrecoOder(int precoOder) {
        this.precoOder = precoOder;
    }
}