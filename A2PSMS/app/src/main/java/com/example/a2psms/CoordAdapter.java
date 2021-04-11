package com.example.a2psms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CoordAdapter extends RecyclerView.Adapter<CoordAdapter.ViewHolder>{
    private List<String> coordList;
    public CoordAdapter(List<String> coordList){
        this.coordList=coordList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.coord_row,parent,false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        String coord=coordList.get(position);
        int comma=coord.indexOf(',');
        holder.lat.setText(coord.substring(0,comma));
        holder.lon.setText(coord.substring(comma+1));
    }
    @Override
    public int getItemCount(){
        return coordList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView lat,lon;
        public ViewHolder(View view){
            super(view);
            lat=view.findViewById(R.id.lat);
            lon=view.findViewById(R.id.lon);
        }
    }
}