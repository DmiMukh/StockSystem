package ru.hackathone.core.utils

import android.os.Build
import kotlinx.datetime.FixedOffsetTimeZone
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.toKotlinLocalDateTime
import kotlinx.datetime.toLocalDateTime
import java.util.Calendar
import java.util.Date

fun Date.toLocalDateTime(): LocalDateTime =
    Instant.fromEpochMilliseconds(this.time).toLocalDateTime(
        FixedOffsetTimeZone(
            UtcOffset.ZERO
        )
    )

fun getCurrentLocalDateTime() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        java.time.LocalDateTime.now().toKotlinLocalDateTime()
    } else {
        Calendar.getInstance().time.toLocalDateTime()
    }