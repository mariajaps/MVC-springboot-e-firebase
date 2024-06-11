package com.example.ConCon.controllers;
import com.example.ConCon.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.example.ConCon.service.FirebaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class TesController {
    @Autowired
    FirebaseInitializer db;
    @GetMapping("/getAllUser")
    public List<User>  getAllUser() throws ExecutionException, InterruptedException {
        List<User> empList = new ArrayList<User>();
        CollectionReference user = db.getFirebase().collection("ConCon");
        ApiFuture<QuerySnapshot> querySnapshot = user.get();
        for(DocumentSnapshot doc:querySnapshot.get().getDocuments()){
            User emp =doc.toObject(User.class);
            empList.add(emp);
        }
        return empList;
    }
    @PostMapping("./User")
    public User getUser(@RequestParam("nameUser")String nameUser){
        return  new User();
    }
    @PostMapping("./addUser")
    public User getaddUser(@RequestBody User user){
        return new User();
    }
}
