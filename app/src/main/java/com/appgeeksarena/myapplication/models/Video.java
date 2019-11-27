package com.appgeeksarena.myapplication.models;

public class Video {

    private String videoTitle,  videoLink,videoDescription;
    private int videoThumbNail;


    public Video() {
    }

    public Video(String videoTitle, int videoThumbNail, String videoLink, String videoDescription) {
        this.videoTitle = videoTitle;
        this.videoThumbNail = videoThumbNail;
        this.videoLink = videoLink;
        this.videoDescription = videoDescription;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public int getVideoThumbNail() {
        return videoThumbNail;
    }

    public void setVideoThumbNail(int videoThumbNail) {
        this.videoThumbNail = videoThumbNail;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }
}
