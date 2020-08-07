package com.fagunds.cadastrodeclientes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listar extends AppCompatActivity {

     private static final String TAG = "listDataActivity";
     DataBase mDataBase;

     private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        mListView = findViewById(R.id.listView);
        mDataBase = new DataBase(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "");

        Cursor data = mDataBase.getData();
        if (data == null ) {
            Toast.makeText(getApplicationContext(),"Nenhum usuário cadastrado",Toast.LENGTH_LONG).show();
        } else {
            ArrayList<String> listData = new ArrayList<>();
            while (data.moveToNext()) {
                listData.add(data.getString(1));
            }
            ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
            mListView.setAdapter(adapter);
        }
    }
}