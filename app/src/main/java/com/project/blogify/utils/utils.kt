package com.project.blogify.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.text.HtmlCompat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun readableDate(date: String): String {
    val inputFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    val outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy")

    val dateTime = LocalDateTime.parse(date, inputFormatter)
    val formatted = dateTime.format(outputFormatter)

    return formatted
}

fun formatTitle(raw: String): String {
    val formatted = HtmlCompat.fromHtml(raw, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
    return formatted
}