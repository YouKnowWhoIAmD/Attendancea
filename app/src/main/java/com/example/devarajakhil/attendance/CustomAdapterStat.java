package com.example.devarajakhil.attendance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Devaraj Akhil on 15-02-2018.
 */

public class CustomAdapterStat extends RecyclerView.Adapter<CustomAdapterStat.ViewHolder> {
    public static final String EXTRA_MESSAGE  = "com.example.devarajakhil.attendance";
    private final Context context;
    private List<MyData> my_data;

    public CustomAdapterStat(Context context, List<MyData> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    @Override
    public CustomAdapterStat.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomAdapterStat.ViewHolder holder, final int position) {
        holder.Name.setText(my_data.get(position).getName());
        holder.Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }
    public void ReloadDatax(List<MyData> my_data)
    {
        this.my_data = my_data;
    }
    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        public ViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
