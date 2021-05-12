package com.example.tourismapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>{

    private List<com.example.tourismapp2.Destination> destinationList;
    private Context context;
    public DestinationAdapter(List<Destination> destinationList, Context context) {
        this.destinationList = destinationList;
        this.context=context;
    }

    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_rv_top_destinations,parent,false);
        return new DestinationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        holder.iv_top_destination.setImageResource(destinationList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public class DestinationViewHolder extends RecyclerView.ViewHolder  {
        public ImageView iv_top_destination;

        public DestinationViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_top_destination=itemView.findViewById(R.id.iv_top_destination);
        }
    }
}
