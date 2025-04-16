package org.wikipedia.homeworks.homework20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class ExploreScreenNamedTests : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun exploreScreenNamedTest() = run {
        namedSteps {
            isDisplayed(OnboardingScreenNamed.skipButton)
            click(OnboardingScreenNamed.skipButton)

            isDisplayed(ExploreScreenNamed.toolbarTitle)
            ExploreScreenNamed.topReadItem(4) {
                isDisplayed(articles)
                articles(0) {
                    click(this)
                }
            }

            isDisplayed(ArticlesScreenNamed.pageVW)
        }
    }
}