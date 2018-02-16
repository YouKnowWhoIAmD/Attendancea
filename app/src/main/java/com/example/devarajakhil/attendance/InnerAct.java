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
import android.widget.Toast;
import java.util.List;
import static com.example.devarajakhil.attendance.CustomAdapter.EXTRA_MESSAGE;
/**
 * Created by Devaraj Akhil on 08-02-2018.
 */

public class InnerAct extends AppCompatActivity{
    FloatingActionButton fab;
    MyDBSub myDBHandlerMain;
    private Context context = this;
    private EditText sturoll,stuname;
    private RecyclerView recyclerView;
    String abc;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapterSub adapter;
    private List<Studata> data_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inner_act);
        Intent i = getIntent();
        //Context cc = getApplicationContext();
        abc = i.getStringExtra(EXTRA_MESSAGE);
        myDBHandlerMain = new MyDBSub(this, null, null, 1);

        fab = (FloatingActionButton) findViewById(R.id.fabEditInner);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_inner);
        data_list  = myDBHandlerMain.getNotifications(abc);
        gridLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new CustomAdapterSub(this,data_list);
        recyclerView.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.innerprompts, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(promptsView);
                sturoll = (EditText) promptsView.findViewById(R.id.studentRollNoED);
                stuname = (EditText) promptsView.findViewById(R.id.studentNameED);
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
        MyDBSub dbSub = new MyDBSub(this, null, null, 1);
        //Log.d("HERE",abc);
        dbSub.addHandler(abc,sturoll.getText().toString(),stuname.getText().toString());
        //dbSub.rename(abc);
        data_list  = dbSub.getNotifications(abc);
        adapter.ReloadDatax(data_list);
        recyclerView.setAdapter(adapter);

        Toast t = Toast.makeText(this, R.string.insertSuccesToast, Toast.LENGTH_SHORT);
        View v = t.getView();
        v.setBackgroundColor(getResources().getColor(R.color.DeepPurple));
        t.show();
    }
}