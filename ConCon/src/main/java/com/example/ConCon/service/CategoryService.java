package com.example.ConCon.service;
import com.example.ConCon.model.Category;
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

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
@Autowired

FirebaseInitializer db;
    public List<Category> getCategories(String nomeCategory ) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = db.getFirebase().collection("Category").document(nomeCategory);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Category category;
        if (document.exists()) {
            category = document.toObject(Category.class);
        }
        return null;
    }
    public String createCategory(Category category) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Category").document(category.getNomeCategoria() ).set(category);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String updateCategory(Category category) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Category").document(category.getNomeCategoria()).set(category);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deleteCategory(String nomeCategory) {
        ApiFuture<WriteResult> writeResult = db.getFirebase().collection("Product").document(nomeCategory).delete();
        return "Successfully deleted"+nomeCategory;
    }

    public List<Category> getCategory() throws ExecutionException, InterruptedException {
        List<Category> empList = new ArrayList<Category>();
        CollectionReference category = db.getFirebase().collection("Category");
        ApiFuture<QuerySnapshot> querySnapshot = category.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()){
            Category emp =doc.toObject(Category.class);
            empList.add(emp);
        }
        return empList;
    }
}


