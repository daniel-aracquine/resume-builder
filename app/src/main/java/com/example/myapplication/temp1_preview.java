package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class temp1_preview extends AppCompatActivity {

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp1_preview);
    }
    public void open_personal_details(View v){
        db= new DBHelper(this);
        boolean b=db.cleardata();
        Intent intent = new Intent(this,Personal_Details.class);
        startActivity(intent);
    }
}