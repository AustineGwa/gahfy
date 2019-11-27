package com.appgeeksarena.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appgeeksarena.myapplication.R;
import com.appgeeksarena.myapplication.interfaces.OnServiceClicked;
import com.appgeeksarena.myapplication.interfaces.OnVideoItemClicked;
import com.appgeeksarena.myapplication.models.Service;
import com.appgeeksarena.myapplication.models.Video;

import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder> {

    private List<Service> serviceList;
    private OnServiceClicked onServiceClicked;
    private Context context;

    public ServicesAdapter(List<Service> serviceList, OnServiceClicked onServiceClicked, Context context) {
        this.serviceList = serviceList;
        this.onServiceClicked = onServiceClicked;
        this.context = context;
    }

    @NonNull
    @Override
    public ServicesAdapter.ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_row,parent,false );
        ServicesViewHolder videosViewHolder = new ServicesViewHolder(view, onServiceClicked);
        return videosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesViewHolder holder, int position) {
      holder.serviceImage.setImageResource(serviceList.get(position).getThumbnail());
      holder.serviceTitle.setText(serviceList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    class ServicesViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView serviceTitle;
        ImageView serviceImage;
        OnServiceClicked onServiceClicked;

        public ServicesViewHolder(@NonNull View itemView, OnServiceClicked onServiceClicked) {
            super(itemView);

            serviceTitle = itemView.findViewById(R.id.service_title);
            serviceImage = itemView.findViewById(R.id.service_thumbnail);

            this.onServiceClicked = onServiceClicked;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onServiceClicked.onClick(serviceList.get(getAdapterPosition()));
        }
    }
}
