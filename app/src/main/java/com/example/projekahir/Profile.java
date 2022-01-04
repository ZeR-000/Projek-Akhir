package com.example.projekahir;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Profile extends AppCompatActivity {
    RecyclerView recylerView;

    String s1[], s2[];
    int images[] = {R.drawable.p2,R.drawable.p3,R.drawable.p1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_profile);

        recylerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.Nama);
        s2 = getResources().getStringArray(R.array.Nim);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
        recylerView.setAdapter(myAdapter);
        recylerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
