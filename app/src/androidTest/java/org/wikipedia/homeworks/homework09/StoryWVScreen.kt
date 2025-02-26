package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

object StoryWVScreen : KScreen<StoryWVScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView = KView {
        withId(R.id.page_fragment)
    }
}