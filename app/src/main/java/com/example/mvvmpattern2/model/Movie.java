package com.example.mvvmpattern2.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmpattern2.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("image")
    @Expose
    public String image;

    @SerializedName("is_new")
    @Expose
    public int is_new;

    @SerializedName("rating")
    @Expose
    public String rating;

    @SerializedName("like_percent")
    @Expose
    public int like_percent;

    @SerializedName("vote_count")
    @Expose
    public int vote_count;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("language")
    @Expose
    public String language;

    @SerializedName("type")
    @Expose
    public String type;


    @BindingAdapter({ "image" })
    public static void loadImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .load(imageURL)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIs_new() {
        return is_new;
    }

    public void setIs_new(int is_new) {
        this.is_new = is_new;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLike_percent() {
        return like_percent;
    }

    public void setLike_percent(int like_percent) {
        this.like_percent = like_percent;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
