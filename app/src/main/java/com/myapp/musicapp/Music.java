package com.myapp.musicapp;

public class Music {
   String title;
   String artist;
   String url;
   String image;
   String thumbnail_image;

    public Music(String title, String artist, String url, String image, String thumbnail_image) {
        this.title = title;
        this.artist = artist;
        this.url = url;
        this.image = image;
        this.thumbnail_image = thumbnail_image;
    }

    public Music() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail_image() {
        return thumbnail_image;
    }

    public void setThumbnail_image(String thumbnail_image) {
        this.thumbnail_image = thumbnail_image;
    }


}
