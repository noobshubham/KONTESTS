package org.eu.noobshubham.kontests.model

import java.time.format.DateTimeFormatter

data class Kontests(
    val name: String,
    val url: String,
    val start_time: String,
    val end_time: String,
    val duration: String,
    val site: String,
    val in_24_hours: String,
    val status: String
) {

    val formatDuration: String
        get() = duration.toDouble().div(3600).toInt().toString()

}
