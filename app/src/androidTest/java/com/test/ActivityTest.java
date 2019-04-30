//package com.test;
//
//
//import android.support.test.espresso.IdlingRegistry;
//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;
//import android.support.v7.widget.RecyclerView;
//
//import com.test.view.MainActivity;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
//
//@RunWith(AndroidJUnit4.class)
//public class ActivityTest {
//
//    @Rule
//    public ActivityTestRule<MainActivity> mActivityTestRule =
//            new ActivityTestRule<>(MainActivity.class);
//
//
//    @Before
//    public void registerIdlingResource() {
//        IdlingRegistry.getInstance().register(EspressoTestingIdlingResource.getIdlingResource());
//    }
//
//
//    @After
//    public void unregisterIdlingResource() {
//        IdlingRegistry.getInstance().unregister(EspressoTestingIdlingResource.getIdlingResource());
//    }
//
//
//    @Test
//    public void checkRecyclerViewVisibility() throws InterruptedException {
//        // verify recycler view is being displayed
//        onView(withId(R.id.rv_article)).check(matches(isDisplayed()));
//
//        // Get total item of myRecyclerView
//        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.rv_article);
//        int itemCount = recyclerView.getAdapter().getItemCount();
//
//        if (itemCount > 0) {
//
//            onView(withId(R.id.rv_article)).perform(RecyclerViewActions.scrollToPosition(itemCount - 1));
//
//            onView(withId(R.id.rv_article)).perform(RecyclerViewActions.scrollToPosition(0));
//
//
//            onView(withId(R.id.rv_article))
//                    .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
//
//            // Verify the toast text content
//            MainActivity activity = activityTestRule.getActivity();
//            onView(withText(containsString("Title : "))).
//                    inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
//                    check(matches(isDisplayed()));
//        }
//    }
//
//}
