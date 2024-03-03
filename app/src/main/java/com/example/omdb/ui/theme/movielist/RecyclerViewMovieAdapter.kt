package com.example.omdb.ui.theme.movielist

import android.graphics.drawable.Drawable
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.omdb.R
import java.io.InputStream
import java.net.URL


class RecyclerViewMovieAdapter(
    private val getActivity: RecyclerView,
    private val movieList: TopRatedMoviesPage,
    val chatListClickListener: ChatListClickListener) :
    RecyclerView.Adapter<RecyclerViewMovieAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_movie_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val myUrl = URL(movieList.Search[position].Poster)
        val inputStream = myUrl.content as InputStream
        val drawable = Drawable.createFromStream(inputStream, null)
        holder.tvMovieTitle.text = movieList.Search[position].Title
        holder.ivMovieImg.setImageDrawable(drawable)
//        holder.ivMovieImg.setImageURI("https://m.media-amazon.com/images/M/MV5BMTE0YWFmOTMtYTU2ZS00ZTIxLWE3OTEtYTNiYzBkZjViZThiXkEyXkFqcGdeQXVyODMzMzQ4OTI@._V1_SX300.jpg".toUri())
//        holder.ivMovieImg.setImageResource(movieList.Search[position].Poster.toInt())
//        holder.ivMovieImg.setImageBitmap(getBitmapFromURL(movieList.Search[position].Poster))
//        holder.ivMovieImg.setImageBitmap((getBitmapFromURL("https://m.media-amazon.com/images/M/MV5BMTE0YWFmOTMtYTU2ZS00ZTIxLWE3OTEtYTNiYzBkZjViZThiXkEyXkFqcGdeQXVyODMzMzQ4OTI@._V1_SX300.jpg")))
        holder.cardView.setOnClickListener {
            chatListClickListener.onChatListItemClick(it,movieList.Search[position].imdbID)
//            Toast.makeText(getActivity.context, movieList.Search[position].Title, Toast.LENGTH_LONG).show()
//            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)

        }
    }

    override fun getItemCount(): Int {
        return movieList.Search.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMovieTitle: TextView = itemView.findViewById(R.id.tvMovieTitle)
        val ivMovieImg: ImageView = itemView.findViewById(R.id.ivMovieImg)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

}