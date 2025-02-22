package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object AddLanguageScreen : KScreen<AddLanguageScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbar = KToolbar {
        withText(R.string.languages_list_activity_title)
    }

    val languages = KRecyclerView(
        builder = {
            withId(R.id.languages_list_recycler)
        },
        itemTypeBuilder = {
            itemType(::AddLanguageItem)
        }
    )
}