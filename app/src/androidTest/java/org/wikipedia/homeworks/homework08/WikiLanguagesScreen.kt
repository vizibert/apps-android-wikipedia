package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.wikipedia.R

object WikiLanguagesScreen : KScreen<WikiLanguagesScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbar = KToolbar {
        withId(R.id.toolbar)
    }

    val wikiLanguages = KRecyclerView(
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        },
        itemTypeBuilder = {
            itemType(::WikiLanguageItem)
        }
    )



}