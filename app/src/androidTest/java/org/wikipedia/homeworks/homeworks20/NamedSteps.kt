package org.wikipedia.homeworks.homeworks20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.StepInfo
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions

class NamedSteps(val testContext: TestContext<*>) {

    operator fun invoke(block: NamedSteps.() -> Unit) {
        block()
    }

    private fun execute(description: String, actions: (StepInfo) -> Unit) {
        testContext.step(description, actions)
    }

    fun click(item: BaseActions) {
        execute("Нажимаем на '${item.getName()}'") {
            item.click()
        }
    }

    fun isDisplayed(element: BaseAssertions) {
        execute("${(element as BaseActions).getName()} отображается") {
            element.isDisplayed()
        }
    }
}