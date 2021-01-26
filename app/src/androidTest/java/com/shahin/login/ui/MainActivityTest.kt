package com.shahin.login.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.shahin.login.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun invalidPasswords_passwordsNotMatching_returnsFalse() {
        val username = "shahin"
        val password = "123"
        val passwordConfirmation = "12"

        val textInputEditText = onView(
            allOf(
                withId(R.id.tiet_username),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText(username), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.tiet_username), withText(username),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(pressImeActionButton())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.tiet_pass),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText(password), closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.tiet_pass), withText(password),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(pressImeActionButton())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.tiet_pass_confirm),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass_confirm),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(replaceText(passwordConfirmation), closeSoftKeyboard())

        val button = onView(
            allOf(
                withId(R.id.btn), withText("LOGIN"),
                withParent(withParent(withId(R.id.host_fragment))),
                isDisplayed()
            )
        )
        button.check(matches(isEnabled()))
    }

    @Test
    fun invalidPasswords_emptyUsername_returnsFalse() {
        val username = ""
        val password = "123"
        val passwordConfirmation = "123"

        val textInputEditText = onView(
            allOf(
                withId(R.id.tiet_username),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText(username), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.tiet_username), withText(username),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(pressImeActionButton())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.tiet_pass),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText(password), closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.tiet_pass), withText(password),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(pressImeActionButton())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.tiet_pass_confirm),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass_confirm),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(replaceText(passwordConfirmation), closeSoftKeyboard())

        val button = onView(
            allOf(
                withId(R.id.btn), withText("LOGIN"),
                withParent(withParent(withId(R.id.host_fragment))),
                isDisplayed()
            )
        )
        button.check(matches(isEnabled()))
    }

    @Test
    fun validInputs_returnsTrue() {
        val username = "shahin"
        val password = "123"
        val passwordConfirmation = "123"

        val textInputEditText = onView(
            allOf(
                withId(R.id.tiet_username),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText(username), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.tiet_username), withText(username),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_username),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(pressImeActionButton())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.tiet_pass),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText(password), closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.tiet_pass), withText(password),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(pressImeActionButton())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.tiet_pass_confirm),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.til_pass_confirm),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(replaceText(passwordConfirmation), closeSoftKeyboard())

        val button = onView(
            allOf(
                withId(R.id.btn), withText("LOGIN"),
                withParent(withParent(withId(R.id.host_fragment))),
                isDisplayed()
            )
        )
        button.check(matches(isEnabled()))
    }

    @Test
    fun clickLoginButton() {
        val button = onView(
            allOf(
                withId(R.id.btn), withText("LOGIN"),
                withParent(withParent(withId(R.id.host_fragment))),
                isDisplayed()
            )
        )
        button.perform(click())
    }

    private fun checkInputs(
        username: String,
        password: String,
        passwordConfirmation: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty() || passwordConfirmation.isEmpty() || !passwordConfirmation.equals(password, false)) {
            return false
        }
        return true
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
