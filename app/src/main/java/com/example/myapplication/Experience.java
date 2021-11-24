package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Experience extends AppCompatActivity {
    DBHelper db;
    EditText experience;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
    }
    public void submitForm(View view){
       experience=findViewById(R.id.experience);
        db= new DBHelper(this);
        boolean b=db.insertuserdata("experience",experience.getText().toString());
//                        Cursor res=db.getdata("experience");
//        res.moveToNext();
//        String s=res.getString(0);
//        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}