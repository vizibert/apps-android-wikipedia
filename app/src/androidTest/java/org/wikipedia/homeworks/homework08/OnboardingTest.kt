package org.wikipedia.homeworks.homework08

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.recycler.KEmptyRecyclerItem
import org.wikipedia.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen


class OnboardingTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun skipOnboardingTest() = run {
        step("Click skip onboarding button on the first page") {
            OnboardingScreen {
                skipButton {
                    isDisplayed()
                    hasText(R.string.onboarding_skip)
                    hasTextColor(R.color.gray500)
                    click()
                }
            }
        }

        step("Check if onboarding is skipped") {
            ExploreScreen {
                toolbarTitle.isDisplayed()
            }
        }
    }

    @Test
    fun passOnboardingTest() = run {
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

                        childAt<KEmptyRecyclerItem>(1) {
                            isVisible()
                            hasText("Русский", substring = true)
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

        step("Click continue button on the first page") {
            OnboardingScreen.continueButton.click()
        }

        step("Check controls on second page of onboarding") {
            OnboardingScreen {
                onboardingPage.childAt<OnboardingPageItem>(1) {
                    icon {
                        isDisplayed()
                    }

                    title {
                        isDisplayed()
                        hasText(R.string.onboarding_explore_title)
                    }

                    subtitle {
                        isDisplayed()
                        hasAnyText()
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

        step("Click continue button on the second page") {
            OnboardingScreen.continueButton.click()
        }

        step("Check controls on third page of onboarding") {
            OnboardingScreen {
                onboardingPage.childAt<OnboardingPageItem>(2) {
                    icon {
                        isDisplayed()
                    }

                    title {
                        isDisplayed()
                        hasText(R.string.onboarding_reading_list_sync_title)
                    }

                    subtitle {
                        isDisplayed()
                        hasAnyText()
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

        step("Click continue button on the third page") {
            OnboardingScreen.continueButton.click()
        }

        step("Check controls on fourth page of onboarding") {
            OnboardingScreen {
                onboardingPage.childAt<OnboardingPageItem>(3) {
                    icon {
                        isDisplayed()
                    }

                    title {
                        isDisplayed()
                        hasText(R.string.onboarding_data_privacy_title)
                    }

                    subtitle {
                        isDisplayed()
                        hasAnyText()
                    }
                }

                skipButton {
                    isNotDisplayed()
                }

                doneButton {
                    isDisplayed()
                    hasText(R.string.onboarding_get_started)
                }
            }
        }

        step("Click done button on the fourth page") {
            OnboardingScreen.doneButton.click()
        }

        step("Check if Explore screen is displayed") {
            ExploreScreen {
                toolbarTitle.isDisplayed()
            }
        }
    }

    @Test
    fun checkNavigationBetweenOnboardingPagesViaPagerTest() = run {
        step("Check that first page is selected on pager") {
            OnboardingScreen.onboardingPager.isTabSelected(0)
        }

        step("Click last dot") {
            OnboardingScreen.onboardingPager.selectTab(3)
        }

        step("Check that fourth onboarding page is displayed") {
            OnboardingScreen.onboardingPage.childAt<OnboardingPageItem>(3) {
                title {
                    isDisplayed()
                    hasText(R.string.onboarding_data_privacy_title)
                }
            }
        }

        step("Click first dot") {
            OnboardingScreen.onboardingPager.selectTab(0)
        }

        step("Check that first screen is displayed") {
            OnboardingScreen.onboardingPage.childAt<OnboardingPageItem>(0) {
                title {
                    isDisplayed()
                    hasText(R.string.onboarding_welcome_title_v2)
                }
            }
        }
    }

    @Test
    fun addLanguageTest() = run {
        step("Click add language button on the first page") {
            OnboardingScreen {
                onboardingPage.childAt<OnboardingPageItem>(0) {
                    languageList.hasSize(2)

                    addLanguageButton {
                        click()
                    }
                }
            }
        }

        step("Check that Wikipedia languages screen is displayed") {
            WikiLanguagesScreen {
                toolbar {
                    isDisplayed()
                    hasTitle(R.string.wikipedia_languages_title)
                }

                wikiLanguages {
                    childAt<WikiLanguageItem>(1) {
                        number {
                            isDisplayed()
                            hasText("1")
                        }

                        language {
                            isDisplayed()
                            hasText("English")
                        }

                        code {
                            isDisplayed()
                            hasText("EN")
                        }

                        handler.isDisplayed()
                    }

                    childAt<WikiLanguageItem>(2) {
                        isDisplayed()

                        number {
                            isDisplayed()
                            hasText("2")
                        }

                        language {
                            isDisplayed()
                            hasText("Русский")
                        }

                        code {
                            isDisplayed()
                            hasText("RU")
                        }

                        handler.isDisplayed()
                    }

                    lastChild<WikiLanguageItem> {
                        addLanguageButton {
                            isDisplayed()
                            hasText(R.string.wikipedia_languages_add_language_text)
                        }
                    }
                }
            }

            step("Click add language button") {
                WikiLanguagesScreen.wikiLanguages.lastChild<WikiLanguageItem> {
                    addLanguageButton.click()
                }
            }

            step("Check that add language screen is displayed") {
                AddLanguageScreen {
                    toolbar {
                        isDisplayed()
                    }
                }
            }

            step("Add new language") {
                AddLanguageScreen.languages {
                    childAt<AddLanguageItem>(1) {
                        localizedName.click()
                    }
                }
            }

            step("Check that new language is added to Wikipedia languages screen") {
                WikiLanguagesScreen.wikiLanguages.hasSize(5)
            }
        }

        step("Press back button to return to Onboarding screen") {
            device.uiDevice.pressBack()
        }

        step("Check that Spanish language is added to Onboarding screen") {
            OnboardingScreen.onboardingPage.childAt<OnboardingPageItem>(0) {
                languageList.hasSize(3)
            }
        }
    }
}
