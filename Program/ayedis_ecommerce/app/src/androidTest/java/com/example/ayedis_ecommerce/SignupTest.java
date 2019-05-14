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
public class SignupTest {

    @Rule
    public ActivityTestRule<Signup> mActivityTestRule=new ActivityTestRule<>(Signup.class);

    @Test
    public void signupTest() {

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText=onView(
                allOf(withId(R.id.sgUserName),
                        childAtPosition(
                                allOf(withId(R.id.signupEmail),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2=onView(
                allOf(withId(R.id.sgUserName),
                        childAtPosition(
                                allOf(withId(R.id.signupEmail),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("u"), closeSoftKeyboard());

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText3=onView(
                allOf(withId(R.id.sgUserName), withText("u"),
                        childAtPosition(
                                allOf(withId(R.id.signupEmail),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("user"));

        ViewInteraction appCompatEditText4=onView(
                allOf(withId(R.id.sgUserName), withText("user"),
                        childAtPosition(
                                allOf(withId(R.id.signupEmail),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText5=onView(
                allOf(withId(R.id.sgPassword),
                        childAtPosition(
                                allOf(withId(R.id.signupPassword),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("pass"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6=onView(
                allOf(withId(R.id.sgPassword), withText("pass"),
                        childAtPosition(
                                allOf(withId(R.id.signupPassword),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(pressImeActionButton());

        ViewInteraction appCompatEditText7=onView(
                allOf(withId(R.id.sgTlp),
                        childAtPosition(
                                allOf(withId(R.id.signupTlp),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                2)),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("081321654987"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8=onView(
                allOf(withId(R.id.sgTlp), withText("081321654987"),
                        childAtPosition(
                                allOf(withId(R.id.signupTlp),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                2)),
                                1),
                        isDisplayed()));
        appCompatEditText8.perform(pressImeActionButton());

        ViewInteraction appCompatEditText9=onView(
                allOf(withId(R.id.sgAlamat),
                        childAtPosition(
                                allOf(withId(R.id.signupAlamat),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                3)),
                                1),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("alamat"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10=onView(
                allOf(withId(R.id.sgAlamat), withText("alamat"),
                        childAtPosition(
                                allOf(withId(R.id.signupAlamat),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                3)),
                                1),
                        isDisplayed()));
        appCompatEditText10.perform(pressImeActionButton());

        ViewInteraction appCompatEditText11=onView(
                allOf(withId(R.id.sgAlamat), withText("alamat"),
                        childAtPosition(
                                allOf(withId(R.id.signupAlamat),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                3)),
                                1),
                        isDisplayed()));
        appCompatEditText11.perform(replaceText("alamat"));

        ViewInteraction appCompatEditText12=onView(
                allOf(withId(R.id.sgAlamat), withText("alamat"),
                        childAtPosition(
                                allOf(withId(R.id.signupAlamat),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                3)),
                                1),
                        isDisplayed()));
        appCompatEditText12.perform(closeSoftKeyboard());

        ViewInteraction editText=onView(
                allOf(withId(R.id.sgUserName), withText("user"),
                        childAtPosition(
                                allOf(withId(R.id.signupEmail),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                0)),
                                1),
                        isDisplayed()));
        editText.check(matches(withText("user")));

        ViewInteraction editText2=onView(
                allOf(withId(R.id.sgPassword), withText("••••"),
                        childAtPosition(
                                allOf(withId(R.id.signupPassword),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                1)),
                                1),
                        isDisplayed()));
        editText2.check(matches(withText("••••")));

        ViewInteraction editText3=onView(
                allOf(withId(R.id.sgTlp), withText("081321654987"),
                        childAtPosition(
                                allOf(withId(R.id.signupTlp),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                2)),
                                1),
                        isDisplayed()));
        editText3.check(matches(withText("081321654987")));

        ViewInteraction editText4=onView(
                allOf(withId(R.id.sgAlamat), withText("alamat"),
                        childAtPosition(
                                allOf(withId(R.id.signupAlamat),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                3)),
                                1),
                        isDisplayed()));
        editText4.check(matches(withText("alamat")));

        ViewInteraction editText5=onView(
                allOf(withId(R.id.sgAlamat), withText("alamat"),
                        childAtPosition(
                                allOf(withId(R.id.signupAlamat),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                3)),
                                1),
                        isDisplayed()));
        editText5.check(matches(withText("alamat")));
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
