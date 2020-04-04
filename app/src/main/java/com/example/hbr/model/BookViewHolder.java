package com.example.hbr.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hbr.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder {
    ImageView ivCover;
    TextView tvTitle;
    TextView tvAuthor;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        ivCover = itemView.findViewById(R.id.ivCover);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvAuthor = itemView.findViewById(R.id.tvAuthor);
    }

    public void setCover(String coverUrl){
        Picasso.get().load(coverUrl).into(ivCover);
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }

    public void setAuthor(String author){
        tvAuthor.setText(author);
    }
}
