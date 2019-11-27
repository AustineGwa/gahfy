package com.appgeeksarena.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appgeeksarena.myapplication.R;
import com.appgeeksarena.myapplication.interfaces.OnVideoItemClicked;
import com.appgeeksarena.myapplication.models.Video;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideosViewHolder> {

    private List<Video> videoList;
    private OnVideoItemClicked onVideoItemClicked;
    private Context context;

    public VideosAdapter(List<Video> videoList,  Context context, OnVideoItemClicked onVideoItemClicked) {
        this.videoList = videoList;
        this.onVideoItemClicked = onVideoItemClicked;
        this.context = context;
    }

    @NonNull
    @Override
    public VideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videos_row,parent,false );
        VideosViewHolder videosViewHolder = new VideosViewHolder(view, onVideoItemClicked);
        return videosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideosViewHolder holder, int position) {
        holder.videoTitle.setText(videoList.get(position).getVideoTitle());
        holder.videoDescription.setText(videoList.get(position).getVideoDescription());
        holder.videoThumbNail.setImageResource(videoList.get(position).getVideoThumbNail());

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class VideosViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView  videoTitle,  videoDescription;
        ImageView  videoThumbNail;
        OnVideoItemClicked onVideoItemClicked;

        public VideosViewHolder(@NonNull View itemView, OnVideoItemClicked onVideoItemClicked) {
            super(itemView);

            videoTitle = itemView.findViewById(R.id.vid_title);
            videoThumbNail = itemView.findViewById(R.id.vid_thumbnail);
            videoDescription = itemView.findViewById(R.id.vid_description);
            this.onVideoItemClicked = onVideoItemClicked;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onVideoItemClicked.onclick(videoList.get(getAdapterPosition()));
        }
    }
}
