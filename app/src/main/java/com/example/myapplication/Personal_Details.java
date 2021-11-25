package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Personal_Details extends AppCompatActivity {
    DBHelper db;
    EditText name;
    EditText age;
    EditText date;
    EditText email;
    EditText phnNo;
    EditText address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
    }
    public void Frompersonal(View view){
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        date=findViewById(R.id.date);
        email=findViewById(R.id.email);
        phnNo=findViewById(R.id.phnNo);
        address=findViewById(R.id.address);
        db= new DBHelper(this);
        boolean b=db.insertuserdata("name",name.getText().toString());
        b=db.insertuserdata("age",age.getText().toString());
        b=db.insertuserdata("date",date.getText().toString());
        b=db.insertuserdata("email",email.getText().toString());
        b=db.insertuserdata("phnNo",phnNo.getText().toString());
        b=db.insertuserdata("address",address.getText().toString());
//        Cursor res=db.getdata("email");
//        res.moveToNext();
//        String s=res.getString(0);
//        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Educational_Details.class);
        startActivity(intent);
    }
}