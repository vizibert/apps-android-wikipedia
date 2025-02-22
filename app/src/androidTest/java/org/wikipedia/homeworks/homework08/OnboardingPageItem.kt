package org.wikipedia.homeworks.homework08

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KEmptyRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingPageItem(matcher: Matcher<View>) : KViewPagerItem<OnboardingPageItem>(matcher) {

    val icon = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val title = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val subtitle = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }

    val addLanguageButton = KButton {
        withId(R.id.addLanguageButton)
    }

    val languageList = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languagesList)
        },
        itemTypeBuilder = {
            itemType(::KEmptyRecyclerItem)
        }
    )
}