package com.solarexsoft.kotlinlearning

import java.util.*

fun calendarDataMap(startTime: Long, endTime: Long): Map<Int, Map<Int, List<Int>>> {
    val dataMap = mutableMapOf<Int, MutableMap<Int, List<Int>>>()
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = endTime
    val endYear = calendar.get(Calendar.YEAR)
    val endMonth = calendar.get(Calendar.MONTH)
    val endDay = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.timeInMillis = startTime
    val startYear = calendar.get(Calendar.YEAR)
    val startMonth = calendar.get(Calendar.MONTH)
    val startDay = calendar.get(Calendar.DAY_OF_MONTH)
    var isContinue = true
    while (isContinue) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        dataMap.getOrPut(year) {
            mutableMapOf()
        }.getOrPut(month) {
            val dayMin = if (year == startYear && month == startMonth) {
                startDay
            } else {
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
            }
            val dayMax = if (year == endYear && month == endMonth) {
                isContinue = false
                endDay
            } else {
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            }
            (dayMin..dayMax).toList()
        }
        calendar.add(Calendar.MONTH, 1)
    }
    return dataMap
}

fun main() {
    val start = Calendar.getInstance()
    val end = Calendar.getInstance()
    start.set(2017, 10, 12)
    end.set(2020, 1, 24)
    val map = calendarDataMap(start.timeInMillis, end.timeInMillis)
    val yearList: List<Int> = map.keys.toList()
    val monthList: List<List<Int>> = map.values.map { it.keys.toList() }
    val dayList: List<List<List<Int>>> = map.values.map { it.values.toList() }
    val yearStrList: List<String> = map.keys.map {
        "${it}年"
    }
    val monthStrList: List<List<String>> = map.values.map { monthInAYear ->
        monthInAYear.keys.map { month ->
            if (month < 9) {
                "0${month + 1}月"
            } else {
                "${month + 1}月"
            }
        }
    }
    val dayStrList = map.values.map { dayInAYear ->
        dayInAYear.values.map { dayInAMonth ->
            dayInAMonth.map { day ->
                if (day < 10) {
                    "0${day}日"
                } else {
                    "${day}日"
                }
            }
        }
    }
    println(map)
    println(yearList)
    println(monthList)
    println(dayList)
    println(yearStrList)
    println(monthStrList)
    println(dayStrList)
}