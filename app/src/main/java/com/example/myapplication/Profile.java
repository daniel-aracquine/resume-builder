package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    DBHelper db;
    EditText profileDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void Fromprofile(View view){
        profileDetail=findViewById(R.id.profileDetail);
        db= new DBHelper(this);
        boolean b=db.insertuserdata("profileDetail",profileDetail.getText().toString());
//        Cursor res=db.getdata("profileDetail");
//        res.moveToNext();
//        String s=res.getString(0);
//        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,Skills_Details.class);
        startActivity(intent);
    }
}