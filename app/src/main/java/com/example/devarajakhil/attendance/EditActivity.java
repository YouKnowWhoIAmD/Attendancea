package com.example.devarajakhil.attendance;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;

/**
 * Created by Devaraj Akhil on 07-02-2018.
 */

public class EditActivity extends AppCompatActivity {
    FloatingActionButton fab;
    MyDBHandler myDBHandlerMain;
    private Context context = this;
    private EditText userInput;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapter adapter;
    private List<MyData> data_list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);
        myDBHandlerMain = new MyDBHandler(this, null, null, 1);

        fab = (FloatingActionButton) findViewById(R.id.fabEdit);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        data_list  = myDBHandlerMain.getNotifications();
        gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new CustomAdapter(this,data_list);
        recyclerView.setAdapter(adapter);


        fab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ffff")));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompts, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                alertDialogBuilder.setView(promptsView);
                userInput = (EditText) promptsView
                        .findViewById(R.id.editPrompts);
                alertDialogBuilder
                        .setCancelable(true)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        addthis();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    public void addthis(){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        dbHandler.addHandler(userInput.getText().toString());
        data_list  = myDBHandlerMain.getNotifications();
        adapter.ReloadDatax(data_list);
        recyclerView.setAdapter(adapter);

        Toast t = Toast.makeText(this, R.string.insertSuccesToast, Toast.LENGTH_SHORT);
        View v = t.getView();
        v.setBackgroundColor(getResources().getColor(R.color.DeepPurple));
        t.show();
    }
}
