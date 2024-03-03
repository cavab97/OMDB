package com.example.omdb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omdb.databinding.ActivityMovieliseBinding
import com.example.omdb.ui.theme.movielist.Movie
import com.example.omdb.ui.theme.movielist.RecyclerViewMovieAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var recyclerViewMovieAdapter: RecyclerViewMovieAdapter? = null
    private var movieList = mutableListOf<Movie>()
    private lateinit var binding:ActivityMovieliseBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//

//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ActivityMovieliseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieList = ArrayList()

        recyclerView =binding.recyclerView
        recyclerViewMovieAdapter = RecyclerViewMovieAdapter(this, movieList)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewMovieAdapter

        prepareMovieListData()
    }

    private fun prepareMovieListData() {
        var movie = Movie("Avatar", R.drawable.avatar)
        movieList.add(movie)
        movie = Movie("Batman", R.drawable.avatar)
        movieList.add(movie)

        movie = Movie("End Game", R.drawable.avatar)
        movieList.add(movie)
        movie = Movie("Hulk", R.drawable.avatar)
        movieList.add(movie)
        movie = Movie("Inception", R.drawable.avatar)
        movieList.add(movie)
        movie = Movie("Jumanji", R.drawable.avatar)
        movieList.add(movie)
        movie = Movie("Lucy", R.drawable.avatar)
        movieList.add(movie)
        movie = Movie("Jurassic World", R.drawable.avatar)
        movieList.add(movie)
        movie = Movie("Spider Man", R.drawable.avatar)
        movieList.add(movie)
        movie = Movie("Venom", R.drawable.avatar)
        movieList.add(movie)

        recyclerViewMovieAdapter!!.notifyDataSetChanged()

        //All Code is done let's run the app
    }
//    fun getAllData(){
//        Api.retrofitService.getAllData().enqueue(object: Callback<List<Property>>{
//            override fun onResponse(
//                call: Call<List<Property>>,
//                response: Response<List<Property>>
//            ) {
//                if(response.isSuccessful){
//                    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply{
//                        myAdapter = MyAdapter(response.body()!!)
//                        layoutManager = manager
//                        adapter = myAdapter
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<Property>>, t: Throwable) {
//                t.printStackTrace()
//            }
//        })
//    }
}