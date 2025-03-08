package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.screen.Screen
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.main.MainActivity

class OnboardingUiTests : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun skipOnboardingUiTest() = run {
        step("Click Skip button on the first Onboarding page") {
            OnboardingUiScreen.skipBtn {
                isDisplayed()
                containsText("Skip")
                click()
            }
        }

        step("Check that Explore screen is displayed") {
            ExploreScreen.toolbarTitle.isDisplayed()
        }
    }

    @Test
    fun passOnboardingUiTest() = run {
        step("Check controls on the first onboarding page and click Continue button") {
            OnboardingUiScreen {
                image.isDisplayed()

                title {
                    isDisplayed()
                    containsText("The Free")
                }

                subtitle {
                    isDisplayed()
                    containsText("found the following")
                }

                firstLanguage {
                    isDisplayed()
                    containsText("English")
                }

                addLanguageBtn {
                    isDisplayed()
                    containsText("languages")
                }

                skipBtn {
                    isDisplayed()
                    hasText("Skip")
                    isClickable()
                }

                continueBtn {
                    isDisplayed()
                    hasText("Continue")
                    isClickable()
                    click()
                }
            }
        }

        step("Check controls on the second page and click continue button") {
            OnboardingUiScreen {
                image.isDisplayed()

                title {
                    isDisplayed()
                    containsText("New ways")
                }

                subtitle {
                    isDisplayed()
                    containsText("Dive down")
                }

                skipBtn {
                    isDisplayed()
                    isClickable()
                    hasText("Skip")
                }

                continueBtn {
                    isDisplayed()
                    isClickable()
                    hasText("Continue")
                    click()
                }
            }
        }

        step("Check controls on the third page and click continue") {
            OnboardingUiScreen {
                image.isDisplayed()

                title {
                    isDisplayed()
                    containsText("Reading list")
                }

                subtitle {
                    isDisplayed()
                    containsText("You can")
                }

                skipBtn.isDisplayed()

                continueBtn {
                    isDisplayed()
                    click()
                }
            }
        }

        step("Check controls on the fourth page and click Get Started button") {
            OnboardingUiScreen {
                image.isDisplayed()

                title {
                    isDisplayed()
                    containsText("Data ")
                }

                subtitle {
                    isDisplayed()
                    containsText("We believe")
                }

                getStartedBtn {
                    isDisplayed()
                    isClickable()
                    hasText("Get started")
                    click()
                }
            }
        }

        step("Check that Explore screen is displayed") {
            ExploreScreen.toolbarTitle.isDisplayed()
        }
    }

    @Test
    fun checkNavigationBetweenOnboardingPagesViaPagerTest() = run {
        Screen.idle(3_000)

        step("Click on the last pager dot") {
            OnboardingUiScreen.clickPagerDotAt(8)
        }

        step("Check if the last onboarding page is displayed") {
            OnboardingUiScreen.title.containsText("Reading list")
        }
    }

    @Test
    fun skipOnboardingBySwipeTest() = run {
        step("Long swipe on the first onboarding page") {
            OnboardingUiScreen.scrollView.swipeLeft()
        }

        step("Check that Explore screen is displayed") {
            ExploreScreen.toolbarTitle.isDisplayed()
        }
    }
}