package com.example.ConCon.service;

import com.example.ConCon.model.Order;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class OrderService {
    @Autowired
    FirebaseInitializer db;

    public Order getOrder(int orderId) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = db.getFirebase().collection("Order").document(String.valueOf(orderId));
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Order order = null;
        if (document.exists()) {
            order = document.toObject(Order.class);
        }
        return order;
    }

    public String createOrder(Order order) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Order").document(String.valueOf(order.getOderId())).set(order);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String updateOrder(Order order) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Order").document(String.valueOf(order.getOderId())).set(order);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteOrder(int orderId) {
        ApiFuture<WriteResult> writeResult = db.getFirebase().collection("Order").document(String.valueOf(orderId)).delete();
        return "Successfully deleted order with ID: " + orderId;
    }

    public List<Order> getAllOrders() throws ExecutionException, InterruptedException {
        List<Order> orderList = new ArrayList<>();
        CollectionReference orders = db.getFirebase().collection("Order");
        ApiFuture<QuerySnapshot> querySnapshot = orders.get();
        for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
            Order order = doc.toObject(Order.class);
            orderList.add(order);
        }
        return orderList;
    }
}