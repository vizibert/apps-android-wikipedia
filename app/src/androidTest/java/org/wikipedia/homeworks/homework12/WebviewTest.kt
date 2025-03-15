package org.wikipedia.homeworks.homework12

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebviewTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWebview() = run {

        step("Skip onboarding") {
            OnboardingScreen.skipButton.click()
        }

        step("Check that Explore screen is displayed") {
            ExploreScreen.toolbarTitle.isDisplayed()
        }

        step("Scroll down to Featured article") {
            ExploreScreen {
                items {
                    childWith<FeaturedArticleItem> {
                        withDescendant {
                            withText(R.string.view_featured_article_card_title)
                        }
                    } perform {
                        isDisplayed()
                    }
                }
            }
        }

        step("Click the article") {
            ExploreScreen {
                items {
                    childAt<FeaturedArticleItem>(3) {
                        title.click()
                    }
                }
            }
        }

        ArticleWebViewScreen {
            step("Scroll to Bibliography section") {
                webView {
                    withElement(locator = Locator.XPATH, value = "//*[@id=\"Bibliography\"]") {
                        scroll()
                    }
                }
            }

            step("Check Reference section") {
                webView {
                    withElement(locator = Locator.XPATH, value = "//*[@id=\"References\"]") {
                        hasText("References")
                    }
                }
            }

            step("Scroll to the beginning of the article") {
                webView {
                    withElement(locator = Locator.XPATH, value = "//*[@id=\"cite_ref-1\"]") {
                        scroll()
                    }
                }
            }

            step("Click the 5th reference") {
                webView {
                    withElement(locator = Locator.XPATH, value = "//*[@id=\"cite_ref-5\"]/a") {
                        scroll()
                        click()
                    }
                }
            }
        }

        step("Check that Reference bottom sheet is displayed") {
            ReferencesBottomSheetScreen {
                title {
                    isDisplayed()
                    hasText("Reference ")
                }

                references {
                    childAt<ReferencesBottomSheetScreen.ReferenceItem>(1) {
                        idReference {
                            isDisplayed()
                            hasText("5.")
                        }

                        referenceText {
                            isDisplayed()
                            hasText("Hay pp. 175–176")
                        }
                    }
                }
            }
        }

        step("Close the bottom sheet") {
            device.uiDevice.pressBack()
            device.uiDevice.pressBack()
        }

        step("Click the 2nd link of the article") {
            ArticleWebViewScreen {
                webView {
                    withElement(locator = Locator.XPATH, value = "(//*[@class='mw-redirect'])[2]") {
                        click()
                    }
                }
            }
        }

        step("Check the article bottom sheet and click the Read article button") {
            ArticleBottomSheetScreen {
                title {
                    isDisplayed()
                    hasAnyText()
                }

                openArticleBtn {
                    isDisplayed()
                    hasAnyText()
                }

                readArticleBtn {
                    isDisplayed()
                    hasAnyText()
                    click()
                }
            }
        }

        step("Check that the article is opened and scroll to References section") {
            ArticleWebViewScreen {
                webView {
                    withElement(locator = Locator.XPATH, value = "//*[@id=\"References\"]") {
                        hasText("References")
                    }
                }
            }
        }
    }
}