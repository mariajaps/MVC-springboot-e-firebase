package com.example.ConCon.service;

import org.springframework.stereotype.Service;
import com.example.ConCon.model.Commentary;
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
public class CommentaryService { 

    @Autowired
    FirebaseInitializer db;

    public List<Commentary> getCommentary(String nameCommentary) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = db.getFirebase().collection("Commentary").document(nameCommentary);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Commentary commentary; // Changed from 'Favorite' to 'Commentary'
        if (document.exists()) {
            commentary = document.toObject(Commentary.class); // Changed from 'Favorite' to 'Commentary'
            return null;
        }
        return null;
    }

    public String createCommentary(Commentary commentary) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Commentary").document("cometario").set(commentary);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String updateCommentary(Commentary commentary) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture;
        collectionsApiFuture = db.getFirebase().collection("Commentary").document("comentario").set(commentary);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCommentary(String nameCommentary) {
        ApiFuture<WriteResult> writeResult = db.getFirebase().collection("Commentary").document(nameCommentary).delete();
        return "Successfully deleted " + nameCommentary;
    }

    public List<Commentary> getCommentaries() throws ExecutionException, InterruptedException {
        List<Commentary> commentaryList = new ArrayList<>();
        CollectionReference commentaryCollection = db.getFirebase().collection("Commentary"); 
        ApiFuture<QuerySnapshot> querySnapshot = commentaryCollection.get();
        for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
            Commentary commentary = doc.toObject(Commentary.class); // Changed from 'Favorite' to 'Commentary'
            commentaryList.add(commentary);
        }
        return commentaryList;
    }
}
