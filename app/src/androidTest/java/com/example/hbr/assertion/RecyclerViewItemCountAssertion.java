package com.example.hbr.assertion;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.junit.Assert;

import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewItemCountAssertion implements ViewAssertion {
  private final int expectedCount;

  public RecyclerViewItemCountAssertion(int expectedCount) {
    this.expectedCount = expectedCount;
  }

  @Override
  public void check(View view, NoMatchingViewException noViewFoundException) {
    if (noViewFoundException != null) {
        throw noViewFoundException;
    }

    RecyclerView recyclerView = (RecyclerView) view;
    RecyclerView.Adapter adapter = recyclerView.getAdapter();
    Assert.assertEquals(adapter.getItemCount(), expectedCount);
  }
}
