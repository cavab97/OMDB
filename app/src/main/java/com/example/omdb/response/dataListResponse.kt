package com.example.omdb.response

import com.squareup.moshi.Json

data class dataListResponse(
    @Json(name= "Poster") val Poster: String,
    @Json(name= "Title") val Title: String,
    @Json(name= "Type") val Type: String,
    @Json(name= "Year") val Year: String,
    @Json(name= "imdbID") val imdbID: String
)

