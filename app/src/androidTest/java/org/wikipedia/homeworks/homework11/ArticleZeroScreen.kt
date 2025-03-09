package org.wikipedia.homeworks.homework11

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ArticleZeroScreen : KScreen<ArticleZeroScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val image = KImageView {
        withId(R.id.view_wiki_error_icon)
    }

    val title = KTextView {
        withId(R.id.view_wiki_error_text)
    }

    val retryBtn = KButton {
        withId(R.id.view_wiki_error_button)
    }
}