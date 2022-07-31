package com.example.redfincodechallenge.util

import android.util.Log
import com.example.redfincodechallenge.constants.GlobalConstants.Companion.DATE_FORMATTING_AM_PM
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

fun getCurrentHour(): String {
    val date = Date()
    val formatTime = SimpleDateFormat(DATE_FORMATTING_AM_PM, Locale.ROOT)
    return formatTime.format(date)
}

fun convertDate(input: String) {
    /*val displayFormat = SimpleDateFormat("HH:mm")
    val parseFormat = SimpleDateFormat("hh:mm a")
    val date = parseFormat.parse("10:30 PM")*/
    val formatTime = SimpleDateFormat(DATE_FORMATTING_AM_PM, Locale.ROOT)
    val convertedDate = formatTime.parse(input)

    Log.e("UTIL", "convertDate::$convertedDate")
}

fun checkAMHours(startTime: String): Boolean {
    val isAvailable: Boolean
    val currentHour = getCurrentHour()

    isAvailable = if (currentHour.contains("AM")) {
        val currentHourAlone = currentHour.substringBefore("AM")
        val startTimeHourAlone = startTime.substringAfter("AM")
        currentHourAlone >= startTimeHourAlone
    } else {
        true
    }

    return isAvailable
}

fun checkPMHours(endTime: String): Boolean {
    val isAvailable: Boolean
    val currentHour = getCurrentHour()

    isAvailable = if (currentHour.contains("PM")) {
        val currentHourAlone = currentHour.substringBefore("PM")
        val startTimeHourAlone = endTime.substringAfter("PM")
        currentHourAlone <= startTimeHourAlone
    } else {
        true
    }

    return isAvailable
}

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