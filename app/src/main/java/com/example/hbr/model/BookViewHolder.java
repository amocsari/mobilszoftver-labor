package com.example.hbr.model;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder {

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setCover(String coverUrl){
        throw new RuntimeException("Not implemented");
    }

    public void setTitle(String title){
        throw new RuntimeException("Not implemented");
    }

    public void setAuthor(String author){
        throw new RuntimeException("Not implemented");
    }
}
