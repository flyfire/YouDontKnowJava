package com.solarexsoft.test.date

import java.util.*

fun findNearestDateHourMinute(date: Date): Pair<Int,Int> {
    val hours = date.hours;
    val minutes = date.minutes;
    println("$hours -> $minutes")
    var nearHour = hours
    var nearMinute = 0
    when {
        minutes <= 7 -> {
            nearMinute = 0
        }
        minutes in 8..22 -> {
            nearMinute = 15
        }
        minutes in 23..37 -> {
            nearMinute = 30
        }
        minutes in 38..52 -> {
            nearMinute = 45
        }
        else -> {
            nearMinute = 0
            nearHour+=1
        }
    }
    nearHour%=24
    return Pair(nearHour,nearMinute)
}

fun main() {
    println(findNearestDateHourMinute(Date()))
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, 23)
    calendar.set(Calendar.MINUTE, 59)
    println(calendar.time)
    println(findNearestDateHourMinute(calendar.time))
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    println(calendar.time)
    println(calendar.time.hours)
    println(findNearestDateHourMinute(calendar.time))
}