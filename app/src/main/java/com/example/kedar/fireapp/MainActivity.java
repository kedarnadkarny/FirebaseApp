package com.example.kedar.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Button mSendData, btnRetrieve, btnListViewActivity, btnLoginActivity;
    private Firebase mRef;
    private EditText mValueField, mKeyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mRef = new Firebase("YOUR_DATABASE_STRING_IN_FIREBASE_APP");
        mSendData = (Button) findViewById(R.id.sendData);
        mValueField = (EditText) findViewById(R.id.valueText);
        mKeyField = (EditText) findViewById(R.id.keyText);
        btnRetrieve = (Button) findViewById(R.id.buttonRetrieve) ;
        btnListViewActivity = (Button) findViewById(R.id.listViewButton);
        btnLoginActivity = (Button) findViewById(R.id.LoginActivityBtn);


        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = mKeyField.getText().toString().trim();
                String value = mValueField.getText().toString().trim();

                Firebase mRefChild = mRef.child(key);

                mRefChild.setValue(value);
                mValueField.setText("");
                mKeyField.setText("");
                Toast.makeText(MainActivity.this, "Key:Value Added", Toast.LENGTH_SHORT).show();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RetrieveActivity.class));
            }
        });

        btnListViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RetrieveListActivity.class));
            }
        });

        btnLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }
}
