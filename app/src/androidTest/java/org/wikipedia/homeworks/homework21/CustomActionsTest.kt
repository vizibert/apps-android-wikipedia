package org.wikipedia.homeworks.homework21

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class CustomActionsTest : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun skipOnboardingTest() = run {
        step("Click skip onboarding button on the first page") {
            OnboardingScreen {
                skipButton.customCheckText("Skip")
                val text = skipButton.getText()
                skipButton.customCheckText(text)
                skipButton.customClick()
            }
        }

        step("Check if onboarding is skipped") {
            ExploreScreen {
                toolbarTitle.isDisplayed()
                toolbarTitle.hasAnyDrawable()
            }
        }
    }
}