package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Skills_Details extends AppCompatActivity {
    DBHelper db;
    EditText skills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_details);
    }
    public void Fromskills(View view){
        skills=findViewById(R.id.skills);
        db= new DBHelper(this);
        boolean b=db.insertuserdata("skills",skills.getText().toString());
//                Cursor res=db.getdata("skills");
//        res.moveToNext();
//        String s=res.getString(0);
//        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,Experience.class);
        startActivity(intent);
    }
}