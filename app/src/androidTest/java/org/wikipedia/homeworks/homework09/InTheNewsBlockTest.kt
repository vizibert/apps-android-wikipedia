package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.NewsArticleItem
import org.wikipedia.homeworks.homework07.NewsItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class InTheNewsBlockTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun inTheNewsTest() = run {
        step("Skip onboarding") {
            OnboardingScreen {
                skipButton {
                    isDisplayed()
                    click()
                }
            }
        }

        step("Check if Explore screen is displayed") {
            ExploreScreen.toolbarTitle.isDisplayed()
        }

        step("Scroll down to In the news block") {
            ExploreScreen {
                items {
                    childWith<NewsItem> {
                        withDescendant {
                            withText(R.string.view_card_news_title)
                        }
                    } perform {
                        scrollTo()
                    }
                }
            }
        }

        step("Swipe to 3rd article and click it") {
            ExploreScreen {
                items {
                    childWith<NewsItem> {
                        withDescendant {
                            withText(R.string.view_card_news_title)
                        }
                    } perform {
                        news {
                            childAt<NewsArticleItem>(2) {
                                image.isDisplayed()

                                text {
                                    isDisplayed()
                                    click()
                                }
                            }
                        }
                    }
                }
            }
        }

        step("Check if story screen is displayed") {
            StoriesScreen.headerImage.isDisplayed()
        }

        step("Click 2nd story on the screen") {
            StoriesScreen {
                stories {
                    childAt<StoryItem>(1) {
                        title {
                            isDisplayed()
                            click()
                        }
                    }
                }
            }
        }

        step("Check that story screen in web view is displayed") {
            StoryWVScreen.webView.isDisplayed()
        }
    }
}