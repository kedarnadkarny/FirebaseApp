package com.example.kedar.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;
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
    }
}
