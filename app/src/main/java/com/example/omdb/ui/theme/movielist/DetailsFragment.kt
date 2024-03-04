package com.example.omdb.ui.theme.movielist

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.omdb.databinding.ActivityMovieDetailsBinding
import com.example.omdb.network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.InputStream
import java.net.URL

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {
    private lateinit var binding: ActivityMovieDetailsBinding


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
//
//
//
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllDetails()
        binding.MovieDetailCloseButton.setOnClickListener {
            findNavController().popBackStack()

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ActivityMovieDetailsBinding.inflate(inflater)

        return binding.root
    }


    fun getAllDetails(){
       val imdbID= getArguments()?.getString("imdbID")
        if (imdbID != null) {
            Api.retrofitService.getDetails("6fc87060",imdbID).enqueue(object: Callback<MovieDetailsModel> {
                override fun onResponse(
                    call: Call<MovieDetailsModel>,
                    response: Response<MovieDetailsModel>
                ) {

                    if(response.isSuccessful){
                        Log.i("DataDetails", response.body()!!.toString())
                        onBindView(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<MovieDetailsModel>, t: Throwable) {
                    t.printStackTrace()
                }

            })
        }
    }

     fun onBindView( response: MovieDetailsModel) {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val myUrl = URL(response.Poster)
        val inputStream = myUrl.content as InputStream
        val drawable = Drawable.createFromStream(inputStream, null)
         binding.MovieDetailTitle.text = response.Title
         binding.MovieDetailSubTitle.text = response.Genre
         binding.imageDetailBackground.setImageDrawable(drawable)
         binding.MovieDetailImage.setImageDrawable(drawable)
         binding.MovieDetailSummarySub.text=response.Plot
         binding.MovieratingBar.rating = (response.imdbRating).toFloat()/2;
         binding.MovieDetailRating.text=response.imdbRating+"/10"
         binding.MovieRatingBarRatingNumber.text=response.imdbVotes+" Ratings"


     }


}




