package com.example.hbr.assertion;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.junit.Assert;

import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewItemCountGreaterThan implements ViewAssertion {
  private final int expectedCount;

  public static RecyclerViewItemCountGreaterThan countGreaterThan(int expectedCount){
    return new RecyclerViewItemCountGreaterThan(expectedCount);
  }

  private RecyclerViewItemCountGreaterThan(int expectedCount) {
    this.expectedCount = expectedCount;
  }

  @Override
  public void check(View view, NoMatchingViewException noViewFoundException) {
    if (noViewFoundException != null) {
        throw noViewFoundException;
    }

    RecyclerView recyclerView = (RecyclerView) view;
    RecyclerView.Adapter adapter = recyclerView.getAdapter();
    Assert.assertTrue(adapter.getItemCount() > expectedCount);
  }
}
