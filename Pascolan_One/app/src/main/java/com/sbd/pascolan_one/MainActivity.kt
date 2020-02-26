package com.sbd.pascolan_one

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.sbd.pascolan_one.model.ApiData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.data_list_item.*
import kotlinx.android.synthetic.main.data_list_item.view.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.StringBuilder
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //RetrofitBuilder

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://pascolan-config.s3.us-east-2.amazonaws.com/android/v1/prod/Category/hi/")
            .build()


        //object to call method
        val JsonPlaceHolder = retrofit.create(JsonPlaceHolder::class.java)
        val mycall: Call<List<ApiData>> = JsonPlaceHolder.getData()

        mycall.enqueue(object : retrofit2.Callback<List<ApiData>> {
            override fun onResponse(call: Call<List<ApiData>>, response: Response<List<ApiData>>) {
                val Data: List<ApiData> = response.body()!!
                val stringBuilder = StringBuilder()
                val trial:ArrayList<Itemm> = ArrayList<Itemm>(5)

           //     val triall:ArrayList<String> = ArrayList<String>(5)
            //    val mutableMap2: MutableMap<String, String> = mutableMapOf<String, String>()



                for (ApiData in Data) {
                    //trial.add()
var c = Itemm()
                    c.name = ApiData.n
                    c.url = ApiData.p

                    trial.add(c)
               //     mutableMap2.put(ApiData.p,ApiData.n)
                }
              //  val nameList:Array<String> = arrayOf(stringBuilder.toString())
                Log.d("Result",stringBuilder.toString())
                Log.d("Result",trial.toString())

                recycle.layoutManager = GridLayoutManager(this@MainActivity,3)

               // recycle.layoutManager = LinearLayoutManager(this@MainActivity)
//                recycle.adapter = ImageAdapter(nameList,this@MainActivity)

                recycle.adapter = ImageAdapter(trial,this@MainActivity)
           //     recycle.adapter = ImageAdapter(Data,this@MainActivity)
            }

            override fun onFailure(call: Call<List<ApiData>>, t: Throwable) {
                Log.d("Error",t.message.toString())
            }


        } )

    }

}
