package org.wikipedia.homeworks.homework03

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import org.wikipedia.views.AppTextView

val image = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered"
)

val titleFirstPage = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_welcome_title_v2"
)

val subtitleFirstPage = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_multilingual_secondary_text"
)

val titleSecondPage = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_explore_title"
)

val subtitleSecondPage = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_explore_text"
)

val titleThirdPage = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_reading_list_sync_title"
)

val subtitleThirdPage = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_reading_list_sync_text_v2"
)

val titleFourthPage = listOf(
    AppTextView::class.java,
    "primaryTextView",
    "onboarding_data_privacy_title"
)

val subtitleFourthPage = listOf(
    AppTextView::class.java,
    "secondaryTextView",
    "onboarding_data_privacy_text"
)

val language = listOf(
    AppTextView::class.java,
    "option_label"
)

val addLanguageButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val doneButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_done_button",
    "onboarding_get_started"
)