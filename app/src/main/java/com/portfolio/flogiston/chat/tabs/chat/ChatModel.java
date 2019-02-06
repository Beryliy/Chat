package com.portfolio.flogiston.chat.tabs.chat;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.portfolio.flogiston.chat.db.remote_db.FirebaseStuff;
import com.portfolio.flogiston.chat.model.Message;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.SingleEmitter;

public class ChatModel implements IChatModel{
    private DatabaseReference databaseReference;
    @Override
    public void saveMessage(Message message) {
        FirebaseStuff.getMessageReference().setValue(message);
                //TODO: add OnSuccessListener and OnFailureListener
    }

    @Override
    public void readMessages() {
        ChildEventListener childEventListener = new C
        FirebaseStuff.getMessageReference().addChildEventListener()
    }

}