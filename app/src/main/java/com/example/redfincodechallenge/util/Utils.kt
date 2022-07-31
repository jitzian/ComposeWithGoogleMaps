package com.example.redfincodechallenge.util

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