package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen


object OnboardingUiScreen : UiScreen<OnboardingUiScreen>() {
    override val packageName = "org.wikipedia.alpha"

    val image = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val title = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "primaryTextView")
    }

    val subtitle = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val firstLanguage = UiTextView {
        withIndex(0) { withId(this@OnboardingUiScreen.packageName, "option_label") }
    }

    val addLanguageBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "addLanguageButton")
    }

    val skipBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }

    val getStartedBtn = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_done_button")
    }

    val scrollView = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "scrollViewContainer")
    }

    fun clickPagerDotAt(index: Int) = run {
        UiButton {
            withIndex(index) {
                withClassName("android.widget.LinearLayout")
            }
        }.click()
    }
}
