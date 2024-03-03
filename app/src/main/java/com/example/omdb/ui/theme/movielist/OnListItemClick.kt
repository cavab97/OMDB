package com.example.omdb.ui.theme.movielist

import android.view.View

interface ChatListClickListener {
    fun onChatListItemClick(view: View, imdbID: String)
}