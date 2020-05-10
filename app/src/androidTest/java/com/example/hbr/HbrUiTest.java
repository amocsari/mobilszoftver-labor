package com.example.hbr;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.hbr.idlingresource.ElapsedTimeIdlingResource;
import com.example.hbr.view.BookListActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.hbr.assertion.RecyclerViewItemCountEquals.countEquals;
import static com.example.hbr.assertion.RecyclerViewItemCountGreaterThan.countGreaterThan;
import static com.example.hbr.viewaction.RecyclerViewItemClickViewAction.clickChildItemView;

@RunWith(AndroidJUnit4.class)
public class HbrUiTest {

    @Rule
    public ActivityTestRule<BookListActivity> mBookListActivityRule =
            new ActivityTestRule<>(BookListActivity.class);

    @Test
    public void changeText() {
        //Arrange
        //Act
        onView(withId(R.id.etTitle))
                .perform(typeText("HELLO"), closeSoftKeyboard());

        //Assert
        onView(withId(R.id.etTitle)).check(matches(withText("HELLO")));
    }

    @Test
    public void emptyTextViewNoSearch() {
        //Arrange
        //Act
        onView(withId(R.id.btnSearch))
                .perform(click());

        //Assert
        onView(withId(R.id.rwRemote))
                .check(countEquals(0));
    }

    @Test
    public void searchSuccessful() {
        //Arrange
        onView(withId(R.id.etTitle))
                .perform(typeText("Hobbit"), closeSoftKeyboard());

        //Act
        onView(withId(R.id.btnSearch))
                .perform(click());

        //Assert
        ElapsedTimeIdlingResource.waitFor(new ElapsedTimeIdlingResource.Listener() {
            @Override
            public void inIdle() {
                onView(withId(R.id.rwRemote))
                        .check(countGreaterThan(0));
                onView(withId(R.id.rwLocal))
                        .check(countGreaterThan(0));
            }
        });
    }

    @Test
    public void listItemClicked() {
        //Arrange
        onView(withId(R.id.etTitle))
                .perform(typeText("Hobbit"), closeSoftKeyboard());

        onView(withId(R.id.btnSearch))
                .perform(click());

        //Act
        //Assert
        ElapsedTimeIdlingResource.waitFor(new ElapsedTimeIdlingResource.Listener() {
            @Override
            public void inIdle() {
                onView(withId(R.id.rwLocal))
                        .perform(clickChildItemView(0));
            }
        });
    }

    @Test
    public void snackBarAppeared(){
        //Arrange
        onView(withId(R.id.etTitle))
                .perform(typeText("Hobbit"), closeSoftKeyboard());

        onView(withId(R.id.btnSearch))
                .perform(click());

        ElapsedTimeIdlingResource.waitFor(new ElapsedTimeIdlingResource.Listener() {
            @Override
            public void inIdle() {
                onView(withId(R.id.rwLocal))
                        .perform(clickChildItemView(0));
            }
        });

        //Act
        onView(withId(R.id.rbAvgRating))
                .perform(click());

        //Assert
        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(isDisplayed()));
    }

    @Test
    public void deleteItem(){
        //Arrange
        int itemCount = ((RecyclerView)mBookListActivityRule.getActivity().findViewById(R.id.rwLocal)).getAdapter().getItemCount();
        onView(withId(R.id.etTitle))
                .perform(typeText("Hobbit"), closeSoftKeyboard());

        onView(withId(R.id.btnSearch))
                .perform(click());

        ElapsedTimeIdlingResource.waitFor(new ElapsedTimeIdlingResource.Listener() {
            @Override
            public void inIdle() {
                onView(withId(R.id.rwLocal))
                        .perform(clickChildItemView(0));
            }
        });

        //Act
        onView(withId(R.id.miDelete))
                .perform(click());

        //Assert
        int newItemCount = ((RecyclerView)mBookListActivityRule.getActivity().findViewById(R.id.rwLocal)).getAdapter().getItemCount();
        Assert.assertEquals(itemCount - 1, newItemCount);
    }
}
