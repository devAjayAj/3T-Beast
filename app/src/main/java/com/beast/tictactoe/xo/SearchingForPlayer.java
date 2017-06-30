package com.beast.tictactoe.xo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchingForPlayer extends AppCompatActivity {

    DatabaseReference ref, mDatabase;
    String del;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching_for_player);
    }

    @Override
    public void onStart() {
        super.onStart();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();
        ref = mDatabase.child("searching").child("modeNormal");
        final boolean[] found = {false};
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    if (child.child("uid").getValue().equals(user.getUid())) {
                        found[0] = true;
                    }
                }
                if (!found[0]) {
                    del = mDatabase.child("searching").child("modeNormal").push().getKey();
                    mDatabase.child("searching").child("modeNormal/" + del).child("uid").setValue(user.getUid());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        ref.addListenerForSingleValueEvent(listener);
        mDatabase.child("players/" + user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Player playerObj = dataSnapshot.getValue(Player.class);
                if (playerObj != null) {
                    if (playerObj.pushKey != null) {
                        final Intent i = new Intent(SearchingForPlayer.this, TwoPlayerOnline.class);
                        i.putExtra("pushKey", playerObj.pushKey);
                        startActivity(i);
                        finish();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDatabase.child("searching").child("modeNormal/" + del).removeValue();
    }
}
