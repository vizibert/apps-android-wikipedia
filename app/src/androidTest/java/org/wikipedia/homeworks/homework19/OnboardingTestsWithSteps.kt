package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.utilities.getResourceString
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework11.ArticleScreen
import org.wikipedia.homeworks.homework11.ArticleZeroScreen
import org.wikipedia.main.MainActivity

class TestsWithSteps : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {
    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun skipOnboardingTest() = run {
        steps {
            isDisplayed(OnboardingScreen.skipButton, "Онбординг: кнопка Skip")
            hasText(
                OnboardingScreen.skipButton,
                getResourceString(R.string.onboarding_skip),
                "Onbording:кнопка Skip"
            )
            click(OnboardingScreen.skipButton, "Онбординг: кнопка Skip")

            isDisplayed(ExploreScreen.toolbarTitle, "Главная:тулбар")
        }
    }

    @Test
    fun zeroscreenTest() {
        before {
            device.network.enable()
        }.after {
            device.network.enable()
        }.run {
            steps {
                click(OnboardingScreen.skipButton, "Онбординг: кнопка Skip")
                isDisplayed(ExploreScreen.toolbarTitle, "Главная: тулбар")

                ExploreScreen.items {
                    childAt<FeaturedArticleItem>(3) {
                        isDisplayed(image, "Фото Featured Article")
                    }
                }

                disableNetwork()

                ExploreScreen.items {
                    childAt<FeaturedArticleItem>(3) {
                        click(image, "Фото Featured Article")
                    }
                }

                isDisplayed(ArticleZeroScreen.image, "Зероскрин - иконка")
                isDisplayed(ArticleZeroScreen.title, "Зероскрин - заголовок")
                isDisplayed(ArticleZeroScreen.retryBtn, "Зероскрин - Кнопка Retry")
                hasText(ArticleZeroScreen.retryBtn, "Retry", "Retry")

                enableNetwork()

                click(ArticleZeroScreen.retryBtn, "Зероскрин - Кнопка Retry")
                isDisplayed(ArticleScreen.pageVW, "Экран статьи - WebView статьи")
            }
        }
    }
}