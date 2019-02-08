package com.portfolio.flogiston.chat.tabs.chat;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.portfolio.flogiston.chat.db.remote_db.FirebaseStuff;
import com.portfolio.flogiston.chat.model.Message;

public class ChatModel implements IChatModel{

    interface OnDataChanged{
        void onMessageLoad(Message message);
    }

    private OnDataChanged callback;

    public ChatModel(OnDataChanged callback){
        this.callback = callback;
    }


    @Override
    public void saveMessage(Message message) {
        FirebaseStuff.getMessageReference().push().setValue(message);
                //TODO: add OnSuccessListener and OnFailureListener
    }

    @Override
    public void readMessages() {
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Message currentMessage = dataSnapshot.getValue(Message.class);
                callback.onMessageLoad(currentMessage);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        FirebaseStuff.getMessageReference().addChildEventListener(childEventListener);
    }

}