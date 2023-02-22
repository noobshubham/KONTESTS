package org.eu.noobshubham.kontests.model

data class Kontests(
    val name: String,
    val url: String,
    val start_time: String,
    val end_time: String,
    val duration: String,
    val site: String,
    val in_24_hours: String,
    val status: String
)
