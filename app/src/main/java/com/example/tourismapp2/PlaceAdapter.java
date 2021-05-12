package com.example.tourismapp2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>{
    private List<com.example.tourismapp2.Place> placeList;
    private Context context;
    private OnRowClickListener listener;

    public PlaceAdapter(List<Place> placeList, Context context, OnRowClickListener listener) {
        this.placeList = placeList;
        this.context=context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public com.example.tourismapp2.PlaceAdapter.PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_rv_places_to_go,parent,false);
        return new PlaceViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.tourismapp2.PlaceAdapter.PlaceViewHolder holder, int position) {
        holder.iv_place_to_go.setImageResource(placeList.get(position).getImage());
        holder.tv_title.setText(placeList.get(position).getTitle());
        holder.tv_description.setText(placeList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView iv_place_to_go;
        public TextView tv_title,tv_description;
        public OnRowClickListener onRowClickListener;

        public PlaceViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            iv_place_to_go=itemView.findViewById(R.id.iv_place_to_go);
            tv_title=itemView.findViewById(R.id.tv_title);
            tv_description=itemView.findViewById(R.id.tv_description);
            this.onRowClickListener=onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRowClickListener.onItemClick(placeList.get(getAdapterPosition()).getImage(),placeList.get(getAdapterPosition()).getTitle(),placeList.get(getAdapterPosition()).getDescription());
        }
    }
    public interface OnRowClickListener{
        void onItemClick(int image, String title, String description);
    }

}
