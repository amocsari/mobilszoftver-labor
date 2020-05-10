package com.example.hbr.viewaction;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewItemClickViewAction implements ViewAction {

    private final int index;

    public static RecyclerViewItemClickViewAction clickChildItemView(int i) {
        return new RecyclerViewItemClickViewAction(i);
    }

    private RecyclerViewItemClickViewAction(int i) {
        index = i;
    }

    @Override
    public Matcher<View> getConstraints() {
        return new BaseMatcher<View>() {
            @Override
            public boolean matches(Object item) {
                return true;
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    @Override
    public String getDescription() {
        return "Click on a child view with specified index.";
    }

    @Override
    public void perform(UiController uiController, View view) {
        RecyclerView rw = (RecyclerView) view;
        View child = rw.getChildAt(index);
        child.performClick();
    }
}
