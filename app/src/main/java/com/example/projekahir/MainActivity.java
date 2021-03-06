package com.example.projekahir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void btn_create(View view){
        Intent a = new Intent(MainActivity.this, MainCreate.class);
        startActivity(a);
    }
    public void btn_read(View view) {
        Intent b = new Intent(MainActivity.this, MainRead.class);
        startActivity(b);
    }
    public void btn_profile(View view) {
        Intent c = new Intent(MainActivity.this, Profile.class);
        startActivity(c);
    }

}