package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object StoriesScreen : KScreen<StoriesScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val headerImage = KImageView {
        withId(R.id.header_image_view)
    }

    val text = KTextView {
        withId(R.id.story_text_view)
    }

    val stories = KRecyclerView(
        builder = {
            withId(R.id.news_story_items_recyclerview)
        },
        itemTypeBuilder = {
            itemType(::StoryItem)
        }
    )
}