package com.example.ConCon.service;

import org.springframework.stereotype.Service;
import com.example.ConCon.model.Favorite;
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
import com.example.ConCon.model.Favorite;
@Service
public class FavoriteService {
    @Autowired
FirebaseInitializer db;

public List<Favorite> getFavorite(String nomeFavorite) throws ExecutionException, InterruptedException {
    DocumentReference documentReference = db.getFirebase().collection("Favorite").document(nomeFavorite);
    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();
    Favorite favorite;
    if (document.exists()) {
        favorite = document.toObject(Favorite.class);
        return null;
    }
    return null;
}

public String createFavorite(Favorite favorite) throws ExecutionException, InterruptedException {
    ApiFuture<WriteResult> collectionsApiFuture;
    collectionsApiFuture = db.getFirebase().collection("Favorite").document("favorito").set(favorite);
    return collectionsApiFuture.get().getUpdateTime().toString();
}

public String updateFavorite(Favorite favorite) throws ExecutionException, InterruptedException {
    ApiFuture<WriteResult> collectionsApiFuture;
    collectionsApiFuture = db.getFirebase().collection("Favorite").document("favorito").set(favorite);
    return collectionsApiFuture.get().getUpdateTime().toString();
}

public String deleteFavorite(String nomeFavorite) {
    ApiFuture<WriteResult> writeResult = db.getFirebase().collection("Favorite").document(nomeFavorite).delete();
    return "Successfully deleted " + nomeFavorite;
}

public List<Favorite> getFavorites() throws ExecutionException, InterruptedException {
    List<Favorite> favoriteList = new ArrayList<>();
    CollectionReference favoriteCollection = db.getFirebase().collection("Favorite");
    ApiFuture<QuerySnapshot> querySnapshot = favoriteCollection.get();
    for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
        Favorite favorite = doc.toObject(Favorite.class);
        favoriteList.add(favorite);
    }
    return favoriteList;
}
}

