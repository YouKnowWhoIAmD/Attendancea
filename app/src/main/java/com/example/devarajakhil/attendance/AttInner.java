package com.example.devarajakhil.attendance;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import static com.example.devarajakhil.attendance.CustomAdapter.EXTRA_MESSAGE;

/**
 * Created by Devaraj Akhil on 15-02-2018.
 */

public class AttInner extends AppCompatActivity {
    MyDBSub myDBHandlerMain;
    private Context context = this;
    private RecyclerView recyclerView;
    String abc;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapterAttSub adapter;
    private List<Studata> data_list;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inner_atttttttt_tick);
        Intent i = getIntent();
        abc = i.getStringExtra(EXTRA_MESSAGE);
        Log.v("SOME",abc);
        myDBHandlerMain = new MyDBSub(this, null, null, 1);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_Attttttttt);
        data_list  = myDBHandlerMain.getNotifications(abc);
        gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new CustomAdapterAttSub(this,data_list,abc);
        recyclerView.setAdapter(adapter);

    }
}
