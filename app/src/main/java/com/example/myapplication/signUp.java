package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    DBUser dbu;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void login(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void signup(View v){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        dbu = new DBUser(this);
        boolean b=dbu.insertuserdata(username.getText().toString(),password.getText().toString());
        Toast.makeText(getApplicationContext(), "You have successfully signed up.", Toast.LENGTH_SHORT).show();
        Cursor res=dbu.getdata(username.getText().toString());
        res.moveToNext();
        String storedpassword = res.getString(0);
//        Toast.makeText(getApplicationContext(), storedpassword, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}