package org.wikipedia.homeworks.homework12

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

object ReferencesBottomSheetScreen : KScreen<ReferencesBottomSheetScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val title = KTextView {
        withId(R.id.reference_title_text)
    }

    val references = KRecyclerView(
        builder = {
            isDescendantOfA {
                withId(R.id.reference_pager)
            }
            isInstanceOf(androidx.recyclerview.widget.RecyclerView::class.java)
        },
        itemTypeBuilder = {
            itemType(::ReferenceItem)
        }
    )

    class ReferenceItem(matcher: Matcher<View>) : KRecyclerItem<ReferenceItem>(matcher) {
        val idReference = KTextView(matcher) {
            withId(R.id.reference_id)
        }

        val referenceText = KTextView(matcher) {
            withId(R.id.reference_text)
        }
    }
}