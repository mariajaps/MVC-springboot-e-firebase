package com.example.ConCon.service;

import org.springframework.stereotype.Service;

/*
@Service
public class CartService {
} 
*/

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CartService {

    @Autowired
    FirebaseInitializer db;

    public List<Cart> getCart(String nomeCart) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = db.getFirebase().collection("Cart").document(nomeCart);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Cart cart;
        if (document.exists()) {
            cart = document.toObject(Cart.class);
            return List.of(cart);
        }
        return null;
    }

    public String createCart(Cart cart) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Cart").document(cart.getNomeCart()).set(cart);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String updateCart(Cart cart) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Cart").document(cart.getNomeCart()).set(cart);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCart(String nomeCart) {
        ApiFuture<WriteResult> writeResult = db.getFirebase().collection("Cart").document(nomeCart).delete();
        return "Successfully deleted " + nomeCart;
    }

    public List<Cart> getCarts() throws ExecutionException, InterruptedException {
        List<Cart> cartList = new ArrayList<>();
        CollectionReference cart = db.getFirebase().collection("Cart");
        ApiFuture<QuerySnapshot> querySnapshot = cart.get();
        for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
            Cart cartItem = doc.toObject(Cart.class);
            cartList.add(cartItem);
        }
        return cartList;
    }
}

