package com.example.omdb.ui.theme.movielist

import android.view.View

interface ListClickListener {
    fun onListItemClick(view: View, imdbID: String)
}