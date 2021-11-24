package com.solarexsoft.kotlinlearning

import java.util.*

fun calendarList(startTime: Long, endTime: Long) {
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
    var lastYear = -1
    val yearList = mutableListOf<Int>()
    val monthList = mutableListOf<List<Int>>()
    val dayList = mutableListOf<List<List<Int>>>()
    var monthInAYear: MutableList<Int> = mutableListOf()
    var dayInAMonth: List<Int>
    var dayInAYear: MutableList<List<Int>> = mutableListOf()
    while (isContinue) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
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
        dayInAMonth = (dayMin..dayMax).toList()
        if (year != lastYear) {
            yearList.add(year)
            monthList.add(monthInAYear)
            dayList.add(dayInAYear)
            monthInAYear = mutableListOf()
            dayInAYear = mutableListOf()
            monthInAYear.add(month)
            dayInAYear.add(dayInAMonth)
        } else {
            monthInAYear.add(month)
            dayInAYear.add(dayInAMonth)
        }
        if (year == endYear && month == endMonth) {
            monthList.add(monthInAYear)
            dayList.add(dayInAYear)
        }
        lastYear = year
        calendar.add(Calendar.MONTH, 1)
    }
}