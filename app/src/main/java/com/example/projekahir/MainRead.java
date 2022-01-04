package com.example.projekahir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Handphone> ListHandphone = new ArrayList<Handphone>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListHandphone );
        mListView = (ListView) findViewById(R.id.list_handphone);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListHandphone.clear();
        List<Handphone> contacts = db.ReadHandphone();
        for (Handphone cn : contacts) {
            Handphone judulModel = new Handphone();
            judulModel.set_id(cn.get_id());
            judulModel.set_image(cn.get_image());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_tipe(cn.get_tipe());
            judulModel.set_warna(cn.get_warna());
            judulModel.set_harga(cn.get_harga());
            ListHandphone.add(judulModel);
            if ((ListHandphone.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Handphone obj_itemDetails = (Handphone)o;
        String Sid = obj_itemDetails.get_id();
        byte[] Simage = obj_itemDetails.get_image();
        String Snama = obj_itemDetails.get_nama();
        String Stipe = obj_itemDetails.get_tipe();
        String Swarna = obj_itemDetails.get_warna();
        String Sharga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Iimage", Simage);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Itipe", Stipe);
        goUpdel.putExtra("Iwarna", Swarna);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListHandphone.clear();
        mListView.setAdapter(adapter_off);
        List<Handphone> contacts = db.ReadHandphone();
        for (Handphone cn : contacts) {
            Handphone judulModel = new Handphone();
            judulModel.set_id(cn.get_id());
            judulModel.set_image(cn.get_image());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_tipe(cn.get_tipe());
            judulModel.set_warna(cn.get_warna());
            judulModel.set_harga(cn.get_harga());
            ListHandphone.add(judulModel);
            if ((ListHandphone.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
