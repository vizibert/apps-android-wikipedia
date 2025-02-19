package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.topread.TopReadCardView

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadCardView>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val articles = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadArticleItem)
        }
    )
}