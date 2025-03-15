package org.wikipedia.homeworks.homework12

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleBottomSheetScreen : KScreen<ArticleBottomSheetScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val title = KTextView {
        withId(R.id.link_preview_title)
    }

    val desription = KWebView {
        withId(R.id.link_preview_extract_webview)
    }

    val openArticleBtn = KButton {
        withId(R.id.link_preview_secondary_button)
    }

    val readArticleBtn = KButton {
        withId(R.id.link_preview_primary_button)
    }

}