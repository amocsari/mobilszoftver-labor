package com.example.hbr;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.hbr.assertion.RecyclerViewItemCountAssertion;
import com.example.hbr.view.BookListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class BookListActivityTest {

    @Rule
    public ActivityTestRule<BookListActivity> mActivityRule =
            new ActivityTestRule<>(BookListActivity.class);

    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.etTitle))
                .perform(typeText("HELLO"), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.etTitle)).check(matches(withText("Lalala")));
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.etTitle))
                .perform(typeText("HELLO"), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.etTitle)).check(matches(withText("HELLO")));
    }

    @Test
    public void emptyTextViewNoSearch(){
        onView(withId(R.id.btnSearch))
                .perform(click());

        onView(withId(R.id.rwRemote)).check(new RecyclerViewItemCountAssertion(0));
    }
}
