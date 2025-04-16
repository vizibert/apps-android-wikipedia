package org.wikipedia.homeworks.homeworks20

import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ArticlesScreenNamed : NamedKScreen<ArticlesScreenNamed>() {
    override val screenName = "Статья"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val pageVW: KTextView by lazy {
        KTextView {
            withId(R.id.page_web_view)
        }.name(withParent("Вебвью"))
    }
}