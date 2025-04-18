package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val stepContextCache = mutableMapOf<TestContext<*>, NamedSteps>()

val TestContext<*>.namedSteps: NamedSteps
    get() = stepContextCache.getOrPut(this) { NamedSteps(this) }