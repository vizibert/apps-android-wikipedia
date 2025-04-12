package org.wikipedia.homeworks.homework11

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.recycler.KEmptyRecyclerItem
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework08.OnboardingPageItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity
import org.wikipedia.onboarding.InitialOnboardingActivity
import java.util.Locale

class OnboardingDeviceTests : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onboardingScreenRotationTest() {
        before {
            device.uiDevice.unfreezeRotation()
        }.after {
            device.uiDevice.setOrientationNatural()
        }.run {
            step("Check that orientation is natural") {
                device.uiDevice.isNaturalOrientation
            }

            step("Check controls on first page of onboarding") {
                OnboardingScreen {
                    onboardingPage.childAt<OnboardingPageItem>(0) {
                        icon {
                            isDisplayed()
                        }

                        title {
                            isDisplayed()
                            hasText(R.string.onboarding_welcome_title_v2)
                        }

                        subtitle {
                            isDisplayed()
                            hasText(R.string.onboarding_multilingual_secondary_text)
                        }

                        addLanguageButton {
                            isDisplayed()
                            hasText(R.string.onboarding_multilingual_add_language_text)
                        }

                        languageList {
                            childAt<KEmptyRecyclerItem>(0) {
                                isVisible()
                                hasText("English", substring = true)
                            }
                        }
                    }

                    skipButton {
                        isDisplayed()
                        hasText(R.string.onboarding_skip)
                        hasTextColor(R.color.gray500)
                    }

                    continueButton {
                        isDisplayed()
                        hasText(R.string.onboarding_continue)
                        hasTextColor(R.color.blue600)
                    }
                }
            }

            step("Rotate device") {
                device.uiDevice.setOrientationLeft()
            }
            step("Check controls on first page of onboarding") {
                OnboardingScreen {
                    onboardingPage.childAt<OnboardingPageItem>(0) {
                        icon {
                            isDisplayed()
                        }

                        title {
                            isDisplayed()
                            hasText(R.string.onboarding_welcome_title_v2)
                        }

                        subtitle {
                            isDisplayed()
                            hasText(R.string.onboarding_multilingual_secondary_text)
                        }

                        addLanguageButton {
                            isDisplayed()
                            hasText(R.string.onboarding_multilingual_add_language_text)
                        }

                        languageList {
                            childAt<KEmptyRecyclerItem>(0) {
                                isVisible()
                                hasText("English", substring = true)
                            }
                        }
                    }

                    skipButton {
                        isDisplayed()
                        hasText(R.string.onboarding_skip)
                        hasTextColor(R.color.gray500)
                    }

                    continueButton {
                        isDisplayed()
                        hasText(R.string.onboarding_continue)
                        hasTextColor(R.color.blue600)
                    }
                }
            }
        }
    }

    @Test
    fun onboardingLockScreenTest() = run {
        step("Check controls on first page of onboarding") {
            OnboardingScreen {
                onboardingPage.childAt<OnboardingPageItem>(0) {
                    icon {
                        isDisplayed()
                    }

                    title {
                        isDisplayed()
                        hasText(R.string.onboarding_welcome_title_v2)
                    }

                    subtitle {
                        isDisplayed()
                        hasText(R.string.onboarding_multilingual_secondary_text)
                    }

                    addLanguageButton {
                        isDisplayed()
                        hasText(R.string.onboarding_multilingual_add_language_text)
                    }

                    languageList {
                        childAt<KEmptyRecyclerItem>(0) {
                            isVisible()
                            hasText("English", substring = true)
                        }
                    }
                }

                skipButton {
                    isDisplayed()
                    hasText(R.string.onboarding_skip)
                    hasTextColor(R.color.gray500)
                }

                continueButton {
                    isDisplayed()
                    hasText(R.string.onboarding_continue)
                    hasTextColor(R.color.blue600)
                }
            }
        }

        step("Lock the screen") {
            device.uiDevice.sleep()
        }

        Thread.sleep(2_000)

        step("Unlock the screen") {
            device.uiDevice.wakeUp()
        }

        step("Check controls on first page of onboarding") {
            OnboardingScreen {
                onboardingPage.childAt<OnboardingPageItem>(0) {
                    icon {
                        isDisplayed()
                    }

                    title {
                        isDisplayed()
                        hasText(R.string.onboarding_welcome_title_v2)
                    }

                    subtitle {
                        isDisplayed()
                        hasText(R.string.onboarding_multilingual_secondary_text)
                    }

                    addLanguageButton {
                        isDisplayed()
                        hasText(R.string.onboarding_multilingual_add_language_text)
                    }

                    languageList {
                        childAt<KEmptyRecyclerItem>(0) {
                            isVisible()
                            hasText("English", substring = true)
                        }
                    }
                }

                skipButton {
                    isDisplayed()
                    hasText(R.string.onboarding_skip)
                    hasTextColor(R.color.gray500)
                }

                continueButton {
                    isDisplayed()
                    hasText(R.string.onboarding_continue)
                    hasTextColor(R.color.blue600)
                }
            }
        }
    }

    @Test
    fun reopenOnboardingScreenFromBackgroundTest() = run {
        step("Check controls on first page of onboarding") {
            OnboardingScreen {
                onboardingPage.childAt<OnboardingPageItem>(0) {
                    icon {
                        isDisplayed()
                    }

                    title {
                        isDisplayed()
                        hasText(R.string.onboarding_welcome_title_v2)
                    }

                    subtitle {
                        isDisplayed()
                        hasText(R.string.onboarding_multilingual_secondary_text)
                    }

                    addLanguageButton {
                        isDisplayed()
                        hasText(R.string.onboarding_multilingual_add_language_text)
                    }

                    languageList {
                        childAt<KEmptyRecyclerItem>(0) {
                            isVisible()
                            hasText("English", substring = true)
                        }
                    }
                }

                skipButton {
                    isDisplayed()
                    hasText(R.string.onboarding_skip)
                    hasTextColor(R.color.gray500)
                }

                continueButton {
                    isDisplayed()
                    hasText(R.string.onboarding_continue)
                    hasTextColor(R.color.blue600)
                }
            }
        }

        step("Send app to the background pressing Home button") {
            device.uiDevice.pressHome()
        }

        step("Reopen the app from the background") {
            device.uiDevice.pressRecentApps()
            device.uiDevice.pressRecentApps()
        }

        step("Check controls on first page of onboarding") {
            OnboardingScreen {
                onboardingPage.childAt<OnboardingPageItem>(0) {
                    icon {
                        isDisplayed()
                    }

                    title {
                        isDisplayed()
                        hasText(R.string.onboarding_welcome_title_v2)
                    }

                    subtitle {
                        isDisplayed()
                        hasText(R.string.onboarding_multilingual_secondary_text)
                    }

                    addLanguageButton {
                        isDisplayed()
                        hasText(R.string.onboarding_multilingual_add_language_text)
                    }

                    languageList {
                        childAt<KEmptyRecyclerItem>(0) {
                            isVisible()
                            hasText("English", substring = true)
                        }
                    }
                }

                skipButton {
                    isDisplayed()
                    hasText(R.string.onboarding_skip)
                    hasTextColor(R.color.gray500)
                }

                continueButton {
                    isDisplayed()
                    hasText(R.string.onboarding_continue)
                    hasTextColor(R.color.blue600)
                }
            }
        }
    }

    @Test
    fun checkOnboardingActivityTest() = run {
        step("Check that current activity is Main") {
            device.activities.isCurrent(InitialOnboardingActivity::class.java)
        }
    }

    @Test
    fun zeroscreenTest() {
        before {
            device.network.enable()
        }.after {
            device.network.enable()
        }.run {
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

            step("Turn network off") {
                device.network.disable()
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

            step("Check zeroscreen controls") {
                ArticleZeroScreen {
                    image.isDisplayed()

                    title {
                        isDisplayed()
                        hasAnyText()
                    }

                    retryBtn {
                        isDisplayed()
                        isClickable()
                        hasText("Retry")
                    }
                }
            }

            step("Turn network on") {
                device.network.enable()
            }

            step("Tap Retry button") {
                ArticleZeroScreen.retryBtn.click()
            }

            Thread.sleep(2_000)

            step("Check that article screen is displayed") {
                ArticleScreen.pageVW.isDisplayed()
            }
        }
    }

    @Test
    fun changeLanguageOnboardingTest() {
        before {
        }.after {
            device.language.switchInApp(Locale.ENGLISH)
        }.run {
            step("Set France locale") {
                device.language.switchInApp(locale = Locale.FRANCE)
            }

            step("Check wording on the Skip button") {
                OnboardingScreen.skipButton.hasText("Sauter")
            }
        }
    }
}