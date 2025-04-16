package org.wikipedia.homeworks.homework21

import io.github.kakaocup.kakao.common.assertions.BaseAssertions

fun BaseAssertions.customCheckText(text: String) {
    view.check(CustomBaseAssertions(text))
}

fun BaseAssertions.hasAnyDrawable() {
    view.check(CustomImageHasDrawableAssertions())
}

fun BaseAssertions.hasNoDrawable() {
    view.check(CustomImageHasNoDrawableAssertions())
}