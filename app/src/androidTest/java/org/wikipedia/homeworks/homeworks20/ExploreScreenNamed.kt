package org.wikipedia.homeworks.homeworks20

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView
import org.wikipedia.homeworks.homework07.AnnouncementItem
import org.wikipedia.homeworks.homework07.DayHeaderItem
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.NewsItem
import org.wikipedia.homeworks.homework07.SearchBarItem
import org.wikipedia.homeworks.homework07.TopReadItem

object ExploreScreenNamed : NamedKScreen<ExploreScreenNamed>() {
    override val screenName = "Главный экран"
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle: KImageView by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }
            .name(withParent("Заголовок"))
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchBarItem)
            itemType(::AnnouncementItem)
            itemType(::DayHeaderItem)
            itemType(::FeaturedArticleItem)
            itemType(::TopReadItem)
            itemType(::NewsItem)
        }
    ).name(withParent("Список блоков"))

    fun topReadItem(index: Int, function: TopReadItem.() -> Unit) {
        items.invokeAtIndex(index, function)
    }

    fun topReadItem(): TopReadItem {
        return items.childWith<TopReadItem> {
            withDescendant {
                withText("Top read")
            }
        }.name(items.getName().withParent("Top read"))
    }
}