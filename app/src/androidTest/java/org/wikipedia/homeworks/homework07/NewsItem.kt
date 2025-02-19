package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.news.NewsItem

class NewsItem(matcher: Matcher<View>) : KRecyclerItem<NewsItem>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val news = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.news_cardview_recycler_view)
        },
        itemTypeBuilder = {
            itemType(::NewsArticleItem)
        }
    )
}