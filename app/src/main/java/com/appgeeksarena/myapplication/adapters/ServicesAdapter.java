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
import com.appgeeksarena.myapplication.interfaces.OnVideoItemClicked;
import com.appgeeksarena.myapplication.models.Video;

import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder> {

    private List<Video> videoList;
    private OnVideoItemClicked onVideoItemClicked;
    private Context context;

    public ServicesAdapter(List<Video> videoList,  Context context, OnVideoItemClicked onVideoItemClicked) {
        this.videoList = videoList;
        this.onVideoItemClicked = onVideoItemClicked;
        this.context = context;
    }

    @NonNull
    @Override
    public ServicesAdapter.ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_row,parent,false );
        ServicesViewHolder videosViewHolder = new ServicesViewHolder(view, onVideoItemClicked);
        return videosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesViewHolder holder, int position) {
      holder.serviceImage.setImageResource(R.drawable.ic_chat_black_24dp);
      holder.serviceTitle.setText("Chat");

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class ServicesViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView serviceTitle;
        ImageView serviceImage;
        OnVideoItemClicked onVideoItemClicked;

        public ServicesViewHolder(@NonNull View itemView, OnVideoItemClicked onVideoItemClicked) {
            super(itemView);

            serviceTitle = itemView.findViewById(R.id.service_title);
            serviceImage = itemView.findViewById(R.id.service_thumbnail);

            this.onVideoItemClicked = onVideoItemClicked;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onVideoItemClicked.onclick(videoList.get(getAdapterPosition()));
        }
    }
}
