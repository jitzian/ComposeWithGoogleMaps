package com.example.redfincodechallenge.util

import com.example.redfincodechallenge.constants.GlobalConstants.Companion.AM_BEFORE_NOON
import com.example.redfincodechallenge.constants.GlobalConstants.Companion.DATE_FORMATTING_AM_PM
import com.example.redfincodechallenge.constants.GlobalConstants.Companion.PM_AFTER_NOON
import java.text.SimpleDateFormat
import java.util.*

/**
 * Extension function for generating TAG for any type of class
 * */
inline fun <reified T> T.TAG(): String = T::class.java.simpleName

fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

fun <T1 : Any, T2 : Any, T3 : Any, R : Any> safeLet(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    block: (T1, T2, T3) -> R?
): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}

fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, R : Any> safeLet(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    p4: T4?,
    block: (T1, T2, T3, T4) -> R?
): R? {
    return if (p1 != null && p2 != null && p3 != null && p4 != null) block(p1, p2, p3, p4) else null
}

fun getCurrentHour(): String {
    val date = Date()
    val formatTime = SimpleDateFormat(DATE_FORMATTING_AM_PM, Locale.ROOT)
    return formatTime.format(date)
}

fun checkAMHours(startTime: String): Boolean {
    val isAvailable: Boolean
    val currentHour = getCurrentHour()

    isAvailable = if (currentHour.contains(AM_BEFORE_NOON)) {
        val currentHourAlone = currentHour.substringBefore(AM_BEFORE_NOON)
        val startTimeHourAlone = startTime.substringAfter(AM_BEFORE_NOON)
        currentHourAlone >= startTimeHourAlone
    } else {
        true
    }

    return isAvailable
}

fun checkPMHours(endTime: String): Boolean {
    val isAvailable: Boolean
    val currentHour = getCurrentHour()

    isAvailable = if (currentHour.contains(PM_AFTER_NOON)) {
        val currentHourAlone = currentHour.substringBefore(PM_AFTER_NOON)
        val startTimeHourAlone = endTime.substringAfter(PM_AFTER_NOON)
        currentHourAlone <= startTimeHourAlone
    } else {
        true
    }

    return isAvailable
}

/**
 * Function that returns the week day based on current Timing
 * */
fun getWeekDay(): Days = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
    Calendar.SUNDAY -> {
        Days.SUNDAY
    }
    Calendar.MONDAY -> {
        Days.MONDAY
    }
    Calendar.TUESDAY -> {
        Days.TUESDAY
    }
    Calendar.WEDNESDAY -> {
        Days.WEDNESDAY
    }
    Calendar.THURSDAY -> {
        Days.THURSDAY
    }
    Calendar.FRIDAY -> {
        Days.FRIDAY
    }
    else -> {
        Days.SATURDAY
    }
}

enum class Days(val value: String) {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
}