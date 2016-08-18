package com.example.kedar.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class RetrieveActivity extends AppCompatActivity {

    private TextView mValueView;
    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        Firebase.setAndroidContext(this);

        mValueView = (TextView) findViewById(R.id.valueView);
        mRef = new Firebase("https://fireapp-ec4de.firebaseio.com/");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);
                String name = map.get("Name");
                String age = map.get("age");
                String university = map.get("university");
                Log.v("E_VALUE", "Name: " + name);
                Log.v("E_VALUE", "Age: " + age);
                Log.v("E_VALUE", "University: " + university);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
