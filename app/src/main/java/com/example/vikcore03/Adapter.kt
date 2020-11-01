package com.example.vikcore03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.vikcore03.Location


class Adapter(
    private val data: MutableList<Location>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = data[position]
        holder.bind(location)
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //variable defined
        private val stringmain: TextView = view.findViewById(R.id.mainstring)
        private val stringsubtitle: TextView = view.findViewById(R.id.textView)
        private val imageicon: ImageView = view.findViewById(R.id.image)

        fun bind(location: Location) {
            //set location and subtitle textview
            stringmain.text = location.cty
            stringsubtitle.text = location.time
            val axis = location.firstCoordinate.toString() + "," + location.secondCoordinate.toString()
            //change icon when condition is true
            if (stringsubtitle.text == "Australia/Melbourne" || stringsubtitle.text == "Australia/Brisbane") {
                imageicon.setImageResource(R.drawable.images)
            }

            //show toast coordinates when row clicked
            view.setOnClickListener {
                Toast.makeText(it.context, axis, Toast.LENGTH_LONG).show()

            }
        }

    }
}