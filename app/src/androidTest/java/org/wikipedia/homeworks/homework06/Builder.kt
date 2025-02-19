package org.wikipedia.homeworks.homework06

import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matcher


class MatcherBuilder {
    private val matchers = mutableListOf<Matcher<Shape>>()

    operator fun invoke(function: MatcherBuilder.() -> Unit) {
        function()
    }

    fun hasValidLengthRange(min: Float, max: Float) = matchers.add(LengthRangeMatcher(min, max))

    fun isLine() = matchers.add(LineMatcher())

    fun hasAngles() = matchers.add(AnglesMatcher())

    fun hasEvenSides() = matchers.add(EvenSidesMatcher())

    fun hasColor(color: Color) = matchers.add(ColorMatcher(color))

    fun hasInvalidSidesCount() = matchers.add(InvalidSidesCountMatcher())

    fun hasInvalidLength() = matchers.add(InvalidLengthMatcher())

    fun buildAllMatchers(): Matcher<Shape> = allOf(matchers)

    fun buildAnyMatchers(): Matcher<Shape> = anyOf(matchers)
}

fun main() {

    val shapes = listOf(
        Shape(10f, 1, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE), Shape(-1f, 3, Color.GREEN)
    )

    val builderForLines = MatcherBuilder()

    builderForLines {
        hasValidLengthRange(0.1f, 30f)
        isLine()
    }

    val filteredLines = shapes.filter { builderForLines.buildAllMatchers().matches(it) }
    println("Lines: $filteredLines")

    val builderForRedShapes = MatcherBuilder()

    builderForRedShapes {
        hasColor(Color.RED)
    }

    val filteredRedShapes = shapes.filter { builderForRedShapes.buildAllMatchers().matches(it) }
    println("Red shapes: $filteredRedShapes")

    val builderForInvalidShapes = MatcherBuilder()

    builderForInvalidShapes {
        hasInvalidLength()
        hasInvalidSidesCount()
    }

    val filteredInvalidShapes = shapes.filter { builderForInvalidShapes.buildAnyMatchers().matches(it) }

    println("Invalid shapes: $filteredInvalidShapes")
}