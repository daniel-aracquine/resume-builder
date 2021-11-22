package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button;
        Intent intent;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
    }
    public void open_template_activity(View v){
        Toast.makeText(this, "This is toast", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,template_activity.class);
        startActivity(intent);
    }
}