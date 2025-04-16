package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.invokeAtIndex
import org.wikipedia.homeworks.homework20.name
import org.wikipedia.homeworks.homework20.withParent

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Заголовок"))
    }

    val articles by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadArticleItem)
            }
        ).name(withParent("Статьи"))
    }

    fun articles(index: Int, function: TopReadArticleItem.() -> Unit) {
        articles.invokeAtIndex(index, function)
    }

    fun articles() : TopReadArticleItem {
        return articles.childWith<TopReadArticleItem> {
            withDescendant {
                withText("Top read")
            }
        }.name(articles.getName().withParent("Статья"))
    }
}