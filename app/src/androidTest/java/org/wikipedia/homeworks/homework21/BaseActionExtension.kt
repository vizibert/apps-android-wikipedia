package org.wikipedia.homeworks.homework21

import io.github.kakaocup.kakao.common.actions.BaseActions

fun BaseActions.customClick() {
    view.perform(CustomViewActions())
}

fun BaseActions.getText(): String {
    val text = GetText()
    view.perform(text)
    return text.getText()
}

fun BaseActions.customClickOnCheckBox() {
    view.perform(CustomCheckBoxCheckActions())
}