package com.example.mymusicapp;

import javafx.scene.image.Image;

public class Song {
    private String title;
    private String imagePath;
    private Image image;
    private String duration;
    private String creator;


    public Song(String title, String imagePath, String duration, String creator) {
        this.title = title;
        this.imagePath = imagePath;
        this.duration = duration;
        this.creator = creator;
        if (imagePath != null) {
            this.image = new Image(getClass().getResourceAsStream(imagePath));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getImagePath() {
        return imagePath;
    }
    @Override
    public String toString() {
        return this.title;
    }

}
