package org.wikipedia.homeworks.homework21

import android.view.View
import android.widget.CheckBox
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class CustomCheckBoxCheckActions : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "Switch check"
    }

    override fun perform(uiController: UiController?, view: View?) {
        if (view is CheckBox) {
            view.performClick()
        } else {
            throw (AssertionError ("View is not CheckBox"))
        }
    }
}