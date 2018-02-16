package com.example.devarajakhil.attendance;

/**
 * Created by Devaraj Akhil on 08-02-2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapterSub extends RecyclerView.Adapter<CustomAdapterSub.ViewHolder>{
    public static final String EXTRA_MESSAGE  = "com.example.devarajakhil.attendance";
    private final Context context;
    private List<Studata> my_data;

    public CustomAdapterSub(Context context, List<Studata> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    public void ReloadDatax(List<Studata> my_data)
    {
        this.my_data = my_data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        //   holder.description.setText(my_data.get(position).getDescription());
        //   holder.Start_date.setText(my_data.get(position).getStart_date());
        holder.Name.setText(my_data.get(position).getName());

    }
    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView description,Name;
        public ViewHolder(View itemView) {
            super(itemView);
            // description = (TextView) itemView.findViewById(R.id.description);
            Name = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
