package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions

class Steps( val testContext: TestContext<*>) {

    operator fun invoke(block: Steps.() -> Unit) {
        block()
    }

    private fun execute(description: String, actions: (StepInfo) -> Unit) {
        testContext.step(description, actions)
    }

    fun click(item: BaseActions, name: String) {
        execute("Нажимаем на '$name'") {
            item.click()
        }
    }

    fun disableNetwork() {
        execute("Отключаем интернет") {
            testContext.device.network.disable()
        }
    }

    fun enableNetwork() {
        execute("Включаем интернет") {
            testContext.device.network.enable()
        }
    }

    fun typeText(item: EditableActions, text: String, name: String) {
        execute("Вводим '$text' в '$name'") {
            item.replaceText(text)
        }
    }

    fun setChecked(item: CheckableActions, name: String, isChecked: Boolean) {
        execute("Устанавливаем '$name' в состояние '$isChecked'") {
            item.setChecked(isChecked)
        }
    }

    fun setOrientationLeft() {
        execute("Поворачиваем экран влево") {
            testContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight() {
        execute("Поворачиваем экран вправо") {
            testContext.device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural() {
        execute("Поворачиваем экран в исходное положение") {
            testContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun hasText(item: TextViewAssertions, text: String, name: String) {
        execute("Проверяем наличие '$text' в '$name'") {
            item.hasText(text)
        }
    }

    fun hasAnyText(item: TextViewAssertions, name: String) {
        execute("Проверяем наличие любого текста в '$name'") {
            item.hasAnyText()
        }
    }

    fun containsText(item: TextViewAssertions, text: String, name: String) {
        execute("Проверяем содержание части текста '$text' в '$name'") {
            item.containsText(text)
        }
    }

    fun isChecked(item: CheckableAssertions, name: String) {
        execute("Проверяем, что  '$name'  в выбранном состоянии") {
            item.isChecked()
        }
    }

    fun isNotChecked(item: CheckableAssertions, name: String) {
        execute("Проверяем, что  '$name'  в не выбранном состоянии") {
            item.isNotChecked()
        }
    }

    fun isDisplayed(item: BaseAssertions, name: String) {
        execute("Проверяем, что  '$name'  отображается") {
            item.isDisplayed()
        }
    }
}