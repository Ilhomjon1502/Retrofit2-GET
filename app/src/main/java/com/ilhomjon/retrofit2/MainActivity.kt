package com.ilhomjon.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ilhomjon.retrofit2.Adapters.MovieAdapter
import com.ilhomjon.retrofit2.Models.Movie
import com.ilhomjon.retrofit2.Retrofit.Common
import com.ilhomjon.retrofit2.Retrofit.RetrofitService
import com.ilhomjon.retrofit2.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //documentation: https://square.github.io/retrofit/
    //ip olish uchun: https://reqres.in/

    lateinit var binding: ActivityMainBinding
    lateinit var retrofitService: RetrofitService
    private  val TAG = "MainActivity"
    lateinit var movieAdapter: MovieAdapter
    lateinit var list: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        movieAdapter = MovieAdapter(list)

        retrofitService = Common.retrofitService(this)

//        //oddiy holat
//        retrofitService.getMovie().enqueue(object : Callback<List<Movie>>{
//            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
//                if (response.isSuccessful && response.body() != null){
////                    val list = response.body()
////                    list?.forEach {
////                        Log.d(TAG, "response: $it")
////                    }
//                    list.addAll(response.body()!!)
//                    movieAdapter.notifyDataSetChanged()
//                }
//            }
//
//            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
//
//            }
//        })

        //RxJava bilan
        //link: https://habr.com/ru/post/336034/
        retrofitService.getMovie().observeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .subscribe(
                {result->
                    list.addAll(result)
                    movieAdapter.notifyDataSetChanged()
                },
                {error->

                }
            )

        binding.rv.adapter = movieAdapter
    }
}