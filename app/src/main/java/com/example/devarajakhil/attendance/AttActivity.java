package com.example.devarajakhil.attendance;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;
/**
 * Created by Devaraj Akhil on 07-02-2018.
 */
public class AttActivity extends AppCompatActivity {
    MyDBHandler myDBHandlerAtt;
    private Context context = this;
    private RecyclerView recyclerViewer;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapterAtt adapter;
    private List<MyData> data_list;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.att_layout);

        myDBHandlerAtt = new MyDBHandler(this, null, null, 1);
        recyclerViewer = (RecyclerView) findViewById(R.id.recycler_view_att_layout);
        data_list  = myDBHandlerAtt.getNotifications();// i added
        gridLayoutManager = new GridLayoutManager(this,1);
        recyclerViewer.setLayoutManager(gridLayoutManager);
        adapter = new CustomAdapterAtt(this,data_list);
        recyclerViewer.setAdapter(adapter);

    }
}
