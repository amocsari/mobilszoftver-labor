package com.example.hbr.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hbr.HbrApplication;
import com.example.hbr.R;
import com.example.hbr.model.Book;
import com.example.hbr.presenter.BookDetailPresenter;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetailActivity extends AppCompatActivity implements IBookDetailView {

    @Inject
    BookDetailPresenter bookDetailPresenter;

    ImageView ivCover;
    TextView tvDetailTitle;
    TextView tvDetailAuthor;
    RatingBar rbAvgRating;
    TextView tvRatingCnt;
    TextView tvPublication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        HbrApplication.injector.inject(this);

        ivCover = findViewById(R.id.image_view_cover);
        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvDetailAuthor = findViewById(R.id.tvDetailAuthor);
        rbAvgRating = findViewById(R.id.rbAvgRating);
        tvRatingCnt = findViewById(R.id.tvRatingCnt);
        tvPublication = findViewById(R.id.tvPublication);

        rbAvgRating.setOnClickListener(view -> bookDetailPresenter.displayRatingValue());
    }

    @Override
    protected void onStart(){
        super.onStart();
        bookDetailPresenter.attachScreen(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.miDelete:
                bookDetailPresenter.deleteBook();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Long getBookId() {
        Bundle extras = getIntent().getExtras();
        if(extras != null)
            return  extras.getLong("bookId");
        else return -1L;
    }

    @Override
    public void goBack() {
        onBackPressed();
    }

    @Override
    public void loadBookData(Book book) {
        Picasso.get().load(book.getImageUrl()).into(ivCover);
        tvDetailTitle.setText(book.getTitle());
        tvDetailAuthor.setText(book.getAuthor());

        Double averageRating = book.getAverageRating();
        if(averageRating != null)
            rbAvgRating.setRating(averageRating.floatValue());

        Long ratingsCount = book.getRatingsCount();
        if(ratingsCount != null)
            tvRatingCnt.setText(ratingsCount.toString());

        tvPublication.setText(book.getPublication());
    }

    @Override
    public void showSnackBar(String message) {
        Snackbar.make(rbAvgRating, message, BaseTransientBottomBar.LENGTH_SHORT).show();
    }
}
