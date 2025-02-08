package org.wikipedia.homeworks.homework04

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    private var day: Days? = null

    private fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }

    operator fun invoke(block: Schedule.() -> Unit) {
        block()
    }

    fun monday(block: Schedule.() -> Unit) {
        day = Days.MONDAY
        block()
        day = null
    }

    fun tuesday(block: Schedule.() -> Unit) {
        day = Days.TUESDAY
        block()
        day = null
    }

    fun wednesday(block: Schedule.() -> Unit) {
        day = Days.WEDNESDAY
        block()
        day = null
    }

    fun thursday(block: Schedule.() -> Unit) {
        day = Days.THURSDAY
        block()
        day = null
    }

    fun friday(block: Schedule.() -> Unit) {
        day = Days.FRIDAY
        block()
        day = null
    }

    fun saturday(block: Schedule.() -> Unit) {
        day = Days.SATURDAY
        block()
        day = null
    }

    fun sunday(block: Schedule.() -> Unit) {
        day = Days.SUNDAY
        block()
        day = null
    }

    infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String) {
        addSchedule(day!!, ScheduleEntity(lesson, first, second))
    }

    operator fun String.rangeTo(other: String): Pair<LocalTime, LocalTime> {
        return Pair(LocalTime.parse(this), LocalTime.parse(other))
    }
}

val schedule = Schedule()

fun main() {
    schedule {

        monday {
            "10:30".."11:10" schedule "Biology"
            "11:15".."11:55" schedule "Chemistry"
            "09:00".."09:40" schedule "Mathematics"
            "09:45".."10:25" schedule "History"
        }

        tuesday {
            "09:00".."09:40" schedule "English"
            "09:45".."10:25" schedule "Geography"
            "11:15".."11:55" schedule "Art"
            "10:30".."11:10" schedule "Physics"
        }

        wednesday {
            "11:15".."11:55" schedule "Biology"
            "09:00".."09:40" schedule "Literature"
            "10:30".."11:10" schedule "History"
            "09:45".."10:25" schedule "Mathematics"
        }

        thursday {
            "11:15".."11:55" schedule "Physics"
            "10:30".."11:10" schedule "Geography"
            "09:00".."09:40" schedule "Chemistry"
            "09:45".."10:25" schedule "English"
        }

        friday {
            "09:45".."10:25" schedule "Literature"
            "11:15".."11:55" schedule "History"
            "09:00".."09:40" schedule "Art"
            "10:30".."11:10" schedule "Mathematics"
        }
    }

    println(schedule.toString())
}