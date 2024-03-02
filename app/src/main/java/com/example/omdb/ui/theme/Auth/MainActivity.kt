package com.example.omdb.ui.theme.Auth


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.omdb.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}





//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.lifecycleScope
//import dagger.hilt.android.AndroidEntryPoint
//import retrofit2.Response
//import retrofit2.http.GET
//import javax.inject.Inject
//
//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//
//    @Inject
//    lateinit var productsService:ProductsServices
////    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
////        setContent {
////            OMDbTheme {
////                // A surface container using the 'background' color from the theme
////                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
////                    Greeting("Android")
////                }
////            }
////        }
////        binding = ActivityMainBinding.inflate(layoutInflater)
////        setContentView(binding.root)
//
////        val appBarConfiguration = AppBarConfiguration(
////            topLevelDestinationIds = setOf(
////                R.id.productsListFragment,
////                R.id.exploreFragment,
////                R.id.exploreFragment2,
////                R.id.profileFragment,
////                R.id.cartFragment
////            )
////        )
////        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
////        val navController = navHostFragment.navController
////        setupActionBarWithNavController(this,navController, appBarConfiguration)
//
//
//        lifecycleScope.launchWhenStarted {
//            val response=productsService.getAllProducts()
//            Log.i("Data",response.body()!!.toString())
//        }
//
//    }
//}
//
//interface ProductsServices{
//    @GET("?apikey=6fc87060&s=Marvel&type=movie")
//    suspend fun getAllProducts(): Response<Any>
//}
//
////@Composable
////fun Greeting(name: String, modifier: Modifier = Modifier) {
////    Text(
////            text = "Hello $name!",
////            modifier = modifier
////    )
////}
////
////@Preview(showBackground = true)
////@Composable
////fun GreetingPreview() {
////    OMDbTheme {
////        Greeting("Android")
////    }
////}