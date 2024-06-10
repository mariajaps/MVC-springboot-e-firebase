package com.example.ConCon.service;

import com.example.ConCon.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    public static User getUser(String nameUser) throws ExecutionException, InterruptedException {
        FirebaseInitializer db= (FirebaseInitializer) FirestoreClient.getFirestore();
        DocumentReference documentReference = db.getFirebase().collection("ConCon").document(nameUser);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        User user;
        if (document.exists()) {
            user = document.toObject(User.class);
        }
        return null;
    }
   public String createUser(User user) throws ExecutionException, InterruptedException {
       FirebaseInitializer db= (FirebaseInitializer) FirestoreClient.getFirestore();
       ApiFuture<WriteResult> collectionsApiFuture;
       collectionsApiFuture = db.getFirebase().collection("ConCon").document(User.getNameUser() ).set(user);
       return collectionsApiFuture.get().getUpdateTime().toString();
   }
    public String updateUser(User user) throws ExecutionException, InterruptedException {
        FirebaseInitializer db= (FirebaseInitializer) FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("ConCon").document(User.getNameUser() ).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
    public String deleteUser(String nameUser) {
        FirebaseInitializer db= (FirebaseInitializer) FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.getFirebase().collection("ConCon").document(nameUser).delete();

        return "Successfully deleted"+nameUser;
    }

}
