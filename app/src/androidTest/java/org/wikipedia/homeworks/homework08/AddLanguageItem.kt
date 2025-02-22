package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AddLanguageItem(matcher: Matcher<View>) : KRecyclerItem<AddLanguageItem>(matcher) {

    val localizedName = KTextView(matcher) {
        withId(R.id.localized_language_name)
    }
}