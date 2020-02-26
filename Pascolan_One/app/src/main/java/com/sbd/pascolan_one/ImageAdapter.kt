package com.sbd.pascolan_one

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.data_list_item.view.*
import org.w3c.dom.NameList
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.sbd.pascolan_one.model.ApiData
import java.lang.System.load
import java.net.URL
//import android.support.test.espresso.matcher.ViewMatchers.isSelected
import com.sbd.pascolan_one.ImageAdapter.viewHolder
import android.R.layout
import android.graphics.Color
import android.widget.Toast


//@GlideModule
//class AppGlideModule : AppGlideModule()

class ImageAdapter(

    //val Data: List<ApiData>,
    //val nameList:Array<String>,

   val trial:ArrayList<Itemm> = ArrayList<Itemm>(5),
   // val mutableMap2: MutableMap<String, String> = mutableMapOf<String, String>()

    val context:Context
):RecyclerView.Adapter<viewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.data_list_item,p0, false
        )

        return  viewHolder(view)
    }

    override fun getItemCount(): Int {

      //  return nameList.size
        //return trial.size
        return trial.size
    //    return mutableMap2.size
    }

    override fun onBindViewHolder(p0: viewHolder, p1: Int) {

//        p0.txtName.text=nameList[p1]
//        p0.txtName.text=trial[p1]
       // var c = Itemm()
        p0.txtName.text=trial.get(p1).name
      //  p0.txtName.text=mutableMap2.get(trial[p1])
        val myurl = trial.get(p1).url
        var count: Int = 1
        p0.imageViewo.setOnClickListener(View.OnClickListener {



            if(count%2==0 ) {
            //trial.get(p1).isSelected = false;
            count++
            p0.ll.setBackgroundColor(Color.WHITE)

        }else{
          //  trial.get(p1).isSelected = true;
            count++
            p0.ll.setBackgroundColor(Color.BLUE)

        }
//            Toast.makeText(context,count,Toast.LENGTH_LONG).show()

        })


        Glide.with(context
        )
            .load(myurl)
            .into(p0.imageViewo);
    }

    class viewHolder(view: View):RecyclerView.ViewHolder(view){
        val txtName = view.cv_data_title
        val imageViewo = view.cv_iv_image

        val ll = view.card_view1
    }
}