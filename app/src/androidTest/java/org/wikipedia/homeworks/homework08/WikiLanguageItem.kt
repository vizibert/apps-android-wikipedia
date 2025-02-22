package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R


class WikiLanguageItem(matcher : Matcher<View>) : KRecyclerItem<WikiLanguageItem>(matcher) {

    val title = KTextView { withId(R.id.section_header_text) }

    val number = KTextView(matcher) { withId(R.id.wiki_language_order) }

    val code = KTextView(matcher) { withId(R.id.langCodeText) }

    val language = KTextView(matcher) { withId(R.id.wiki_language_title) }

    val handler = KImageView(matcher) { withId(R.id.wiki_language_drag_handle) }

    val addLanguageButton = KButton(matcher) { withId( R.id.wiki_language_title) }
}