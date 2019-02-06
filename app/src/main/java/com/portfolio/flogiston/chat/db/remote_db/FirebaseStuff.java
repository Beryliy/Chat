package com.portfolio.flogiston.chat.db.remote_db;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseStuff {
    public static FirebaseDatabase getFirebaseDatabase(){
        return FirebaseDatabase.getInstance();
    }
    public static DatabaseReference getMessageReference(){
        return getFirebaseDatabase().getReference("messages");
    }
}
