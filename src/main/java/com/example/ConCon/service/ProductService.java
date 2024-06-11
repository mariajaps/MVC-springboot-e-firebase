package com.example.ConCon.service;

import com.example.ConCon.model.Product;
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
public class ProductService {
@Autowired
FirebaseInitializer db;
    public List<Product> getProduct(String nomeProduto ) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = db.getFirebase().collection("Product").document(nomeProduto);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Product product;
        if (document.exists()) {
            product = document.toObject(Product.class);
        }
        return null;
    }
    public String createProduct(Product product) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Product").document(product.getNomeProduto() ).set(product);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String updateProduct(Product product) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Product").document(product.getNomeProduto()).set(product);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deleteProduct(String nomeProduto) {
        ApiFuture<WriteResult> writeResult = db.getFirebase().collection("Product").document(nomeProduto).delete();
        return "Successfully deleted"+nomeProduto;
    }

    public List<Product> getProduct() throws ExecutionException, InterruptedException {
        List<Product> empList = new ArrayList<Product>();
        CollectionReference product = db.getFirebase().collection("Product");
        ApiFuture<QuerySnapshot> querySnapshot = product.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()){
            Product emp =doc.toObject(Product.class);
            empList.add(emp);
        }
        return empList;
    }
}
