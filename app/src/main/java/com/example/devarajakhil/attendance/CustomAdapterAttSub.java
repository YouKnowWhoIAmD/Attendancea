package com.example.devarajakhil.attendance;

/**
 * Created by Devaraj Akhil on 08-02-2018.
 */

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapterAttSub extends RecyclerView.Adapter<CustomAdapterAttSub.ViewHolder>{
    public static final String EXTRA_MESSAGE  = "com.example.devarajakhil.attendance";
    private final Context context;
    private List<Studata> my_data;
    private String Classname;


    public CustomAdapterAttSub(Context context, List<Studata> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    public CustomAdapterAttSub(Context context, List<Studata> my_data,String c) {
        this.context = context;
        this.my_data = my_data;
        this.Classname = c;
    }

    public void ReloadDatax(List<Studata> my_data)
    {
        this.my_data = my_data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.attttttttt_cardddddddddd, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //   holder.description.setText(my_data.get(position).getDescription());
        //   holder.Start_date.setText(my_data.get(position).getStart_date());
        holder.Name.setText(my_data.get(position).getName());
        holder.roll.setText(my_data.get(position).getId());
        holder.tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stuName = my_data.get(position).getName();
                String stuId = my_data.get(position).getId();
                someP(stuId);
                holder.ll.setBackgroundColor(Color.parseColor("#567845"));
                Toast.makeText(context,"Presence Registered",Toast.LENGTH_SHORT).show();
            }
        });
        holder.into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stuName = my_data.get(position).getName();
                String stuId = my_data.get(position).getId();
                someA(stuId);
                Toast.makeText(context,"Absence Registered",Toast.LENGTH_SHORT).show();
            }
        });
        //Log.i("HELLO",my_data.get(position).getId().toString());
    }
    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public void someP(String id){
        MyDBSub d = new MyDBSub(context,null,null,1);
        d.addcols(this.Classname,id,"Present");
    }
    public void someA(String id){
        MyDBSub d = new MyDBSub(context,null,null,1);
        d.addcols(this.Classname,id,"Present");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name,roll;
        public ImageButton tick,into;
        public LinearLayout ll;
        public ViewHolder(View itemView) {
            super(itemView);

            // description = (TextView) itemView.findViewById(R.id.description);
            Name = (TextView) itemView.findViewById(R.id.titleatt);
            roll = (TextView) itemView.findViewById(R.id.rolluatt);
            tick = (ImageButton) itemView.findViewById(R.id.tickuuattt);
            into = (ImageButton) itemView.findViewById(R.id.intooattt);
            ll = (LinearLayout) itemView.findViewById(R.id.linCardatt);
        }
    }
}
