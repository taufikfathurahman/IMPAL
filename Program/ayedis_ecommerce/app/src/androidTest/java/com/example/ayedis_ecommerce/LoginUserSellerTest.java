package com.example.ayedis_ecommerce;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginUserSellerTest {

    @Rule
    public ActivityTestRule<Login> mActivityTestRule=new ActivityTestRule<>(Login.class);

    @Test
    public void loginTest() {

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText=onView(
                allOf(withId(R.id.inPhone),
                        childAtPosition(
                                allOf(withId(R.id.loginEmail),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2=onView(
                allOf(withId(R.id.inPhone),
                        childAtPosition(
                                allOf(withId(R.id.loginEmail),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("081321764411"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3=onView(
                allOf(withId(R.id.inPhone), withText("081321764411"),
                        childAtPosition(
                                allOf(withId(R.id.loginEmail),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatEditText4=onView(
                allOf(withId(R.id.inPassword),
                        childAtPosition(
                                allOf(withId(R.id.loginPassword),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("admin_atlas"), closeSoftKeyboard());

        ViewInteraction editText=onView(
                allOf(withId(R.id.inPhone), withText("081321764411"),
                        childAtPosition(
                                allOf(withId(R.id.loginEmail),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                0)),
                                1),
                        isDisplayed()));
        editText.check(matches(withText("081321764411")));

        ViewInteraction editText2=onView(
                allOf(withId(R.id.inPassword), withText("•••••••••••"),
                        childAtPosition(
                                allOf(withId(R.id.loginPassword),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                1)),
                                1),
                        isDisplayed()));
        editText2.check(matches(withText("•••••••••••")));

        ViewInteraction editText3=onView(
                allOf(withId(R.id.inPassword), withText("•••••••••••"),
                        childAtPosition(
                                allOf(withId(R.id.loginPassword),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                1)),
                                1),
                        isDisplayed()));
        editText3.check(matches(withText("•••••••••••")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent=view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
