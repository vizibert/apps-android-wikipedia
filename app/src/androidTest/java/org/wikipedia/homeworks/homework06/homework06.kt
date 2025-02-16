package org.wikipedia.homeworks.homework06

import org.hamcrest.CoreMatchers.*
import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.TypeSafeMatcher

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

data class Shape(val length: Float, val sides: Int, val color: Color)

class LengthRangeMatcher(private val min: Float, private val max: Float) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("length is between $min and $max")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.length in min..max
    }
}

class AnglesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("shape has angles")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sides >= 3
    }
}

class LineMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("shape has no angles")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sides in 1..2
    }
}

class EvenSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("sides count is even")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sides % 2 == 0
    }
}

class ColorMatcher(private val color: Color) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("color is $color")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.color == color
    }
}

class InvalidSidesCountMatcher() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("sides count is negative")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sides <= 0
    }
}

class InvalidLengthMatcher() : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("length is negative")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.length < 0
    }
}

fun hasValidLengthRange() = LengthRangeMatcher(0.1f, 30f)

fun isLine() = LineMatcher()

fun hasAngles() = AnglesMatcher()

fun hasEvenSides() = EvenSidesMatcher()

fun hasColor(color: Color) = ColorMatcher(color)

fun hasInvalidSidesCount() = InvalidSidesCountMatcher()

fun hasInvalidLength() = InvalidLengthMatcher()

fun main() {

    val triangle = Shape(10f, 3, Color.RED)

    assertThat(triangle, hasAngles())
    assertThat(triangle, not(hasEvenSides()))
    assertThat(triangle, hasColor(Color.RED))

    val shapes = listOf(
        Shape(10f, 1, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE), Shape(-1f, 3, Color.GREEN)
    )

    val lineMatchers = allOf(
        hasValidLengthRange(),
        isLine()
    )

    val filteredLines = shapes.filter { lineMatchers.matches(it) }

    println("Lines: $filteredLines")

    val shapesWithAnglesMatcher = allOf(
        hasAngles(),
        hasValidLengthRange()
    )

    val filteredTriangles = shapes.filter { shapesWithAnglesMatcher.matches(it) }

    println("Shapes with angles: $filteredTriangles")

    val invalidShapesMatchers = anyOf(
        hasInvalidLength(),
        hasInvalidSidesCount()
    )

    val filteredInvalidShapes = shapes.filter { invalidShapesMatchers.matches(it) }

    println("Invalid shapes: $filteredInvalidShapes")

    val outOfRangeShapesMatcher = allOf(
        not(hasValidLengthRange()),
        not(hasInvalidLength())
    )

    val filteredOutOfRangeShapes = shapes.filter { outOfRangeShapesMatcher.matches(it) }

    println("Out of range shapes: $filteredOutOfRangeShapes")

    val redShapes = hasColor(Color.RED)

    val filteredRedShapes = shapes.filter { redShapes.matches(it) }

    println("Red shapes: $filteredRedShapes")

    val customFilter = shapes.filter {
        allOf(
            hasValidLengthRange(),
            hasAngles(),
            hasEvenSides(),
            hasColor(Color.BLUE),
            not(hasInvalidSidesCount()),
            not(hasInvalidLength())
        ).matches(it)
    }

    println("Custom filter:$customFilter")
}