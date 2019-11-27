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
import com.appgeeksarena.myapplication.models.Content;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.VideosViewHolder> {

    private List<Content> contentList;
    private OnVideoItemClicked onVideoItemClicked;
    private Context context;

    public ContentAdapter(List<Content> contentList, Context context, OnVideoItemClicked onVideoItemClicked) {
        this.contentList = contentList;
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
        holder.videoTitle.setText(contentList.get(position).getVideoTitle());
        holder.videoDescription.setText(contentList.get(position).getVideoDescription());
        holder.videoThumbNail.setImageResource(contentList.get(position).getVideoThumbNail());

    }

    @Override
    public int getItemCount() {
        return contentList.size();
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
            onVideoItemClicked.onclick(contentList.get(getAdapterPosition()));
        }
    }
}
