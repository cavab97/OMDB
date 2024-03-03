package com.example.omdb.ui.theme.movielist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.omdb.R
import com.example.omdb.databinding.ActivityMovieliseBinding
import com.example.omdb.network.Api
import com.example.omdb.response.dataListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment(), ListClickListener {

    private var recyclerView: RecyclerView? = null
    private var recyclerViewMovieAdapter: RecyclerViewMovieAdapter? = null
    private var movieList = mutableListOf<dataListResponse>()
    private lateinit var binding: ActivityMovieliseBinding
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>


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
        manager = LinearLayoutManager(context)

        binding = ActivityMovieliseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        movieList = ArrayList()

//        recyclerView =binding.recyclerView
//        recyclerViewMovieAdapter = RecyclerViewMovieAdapter(this, movieList)
//        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 2)
//        recyclerView!!.layoutManager = layoutManager
//        recyclerView!!.adapter = recyclerViewMovieAdapter

//        prepareMovieListData()
        getAllData()
    }

//    private fun prepareMovieListData() {
//        var movie = Movie("Avatar", R.drawable.avatar)
//        movieList.add(movie)
//        movie = Movie("Batman", R.drawable.avatar)
//        movieList.add(movie)
//
//        movie = Movie("End Game", R.drawable.avatar)
//        movieList.add(movie)
//        movie = Movie("Hulk", R.drawable.avatar)
//        movieList.add(movie)
//        movie = Movie("Inception", R.drawable.avatar)
//        movieList.add(movie)
//        movie = Movie("Jumanji", R.drawable.avatar)
//        movieList.add(movie)
//        movie = Movie("Lucy", R.drawable.avatar)
//        movieList.add(movie)
//        movie = Movie("Jurassic World", R.drawable.avatar)
//        movieList.add(movie)
//        movie = Movie("Spider Man", R.drawable.avatar)
//        movieList.add(movie)
//        movie = Movie("Venom", R.drawable.avatar)
//        movieList.add(movie)
//
//        recyclerViewMovieAdapter!!.notifyDataSetChanged()
//
//        //All Code is done let's run the app
//    }
    fun getAllData(){

        Api.retrofitService.getAllData().enqueue(object: Callback<MoviesPageModel> {
            override fun onResponse(
                call: Call<MoviesPageModel>,
                response: Response<MoviesPageModel>
            ) {

                if(response.isSuccessful){
                    Log.i("Data", response.body()!!.toString())
                    recyclerView = binding.recyclerView.apply{
                        myAdapter = RecyclerViewMovieAdapter(
                            this,
                            response.body()!!, this@MovieListFragment
                        )
                        layoutManager = manager
                        layoutManager= GridLayoutManager(context, 2)
                        adapter = myAdapter
                    }

                }
            }

            override fun onFailure(call: Call<MoviesPageModel>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    override fun onListItemClick(view: View, imdbID: String ) {

        Toast.makeText(requireContext(), imdbID + "Was Clock", Toast.LENGTH_SHORT).show()
// here you navigate to your fragment....
        findNavController().navigate(R.id.action_thirdFragment_to_detailsFragment)


    }



}