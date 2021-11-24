package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Educational_Details extends AppCompatActivity {
    DBHelper db;
    EditText school10;
    EditText grade10;
    EditText year10;
    EditText school12;
    EditText grade12;
    EditText year12;
    EditText uniGrad;
    EditText gradeGrad;
    EditText yearGrad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);
    }
    public void Fromeducational(View view){
        school10=findViewById(R.id.school10);
        grade10=findViewById(R.id.grade10);
        year10=findViewById(R.id.year10);
        school12=findViewById(R.id.school12);
        grade12=findViewById(R.id.grade12);
        year12=findViewById(R.id.year12);
        uniGrad=findViewById(R.id.uniGrad);
        gradeGrad=findViewById(R.id.gradeGrad);
        db= new DBHelper(this);
        boolean b=db.insertuserdata("school10",school10.getText().toString());
        b=db.insertuserdata("grade10",grade10.getText().toString());
        b=db.insertuserdata("year10",year10.getText().toString());
        b=db.insertuserdata("school12",school12.getText().toString());
        b=db.insertuserdata("grade12",grade12.getText().toString());
        b=db.insertuserdata("year12",year12.getText().toString());
        b=db.insertuserdata("uniGrad",uniGrad.getText().toString());
        b=db.insertuserdata("gradeGrad",gradeGrad.getText().toString());
//        b=db.insertuserdata("yearGrad",yearGrad.getText().toString());
//        Cursor res=db.getdata("uniGrad");
//        res.moveToNext();
//        String s=res.getString(0);
//        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }
}