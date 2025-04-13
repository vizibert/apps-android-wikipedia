package org.wikipedia.homeworks.homeworks20

import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

object OnboardingScreenNamed : NamedKScreen<OnboardingScreenNamed>() {
    override val screenName = "Онбординг"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val skipButton: KButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.name(withParent("Кнопка 'Skip'"))
    }
}