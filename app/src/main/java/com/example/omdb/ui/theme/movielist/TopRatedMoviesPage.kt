package com.example.omdb.ui.theme.movielist

import com.example.omdb.response.dataListResponse

data class TopRatedMoviesPage(
    val totalResults: String,
 val Search:  List<dataListResponse>,
 val Response:String
)