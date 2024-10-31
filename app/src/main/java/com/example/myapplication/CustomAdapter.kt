package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private val context: Context,
    private val tripId: ArrayList<String>,
    private val tripName: ArrayList<String>,
    private val tripDestination: ArrayList<String>,
    private val tripStart: ArrayList<String>,
    private val tripEnd: ArrayList<String>,
    private val tripNotes: ArrayList<String>
) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.my_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tripId.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tripIdText.text = tripId[position]
        holder.tripNameText.text = tripName[position]
        holder.tripDestinationText.text = tripDestination[position]
        holder.startDateText.text = tripStart[position]
        holder.endDateText.text = tripEnd[position]
        holder.tripNotesText.text = tripNotes[position]
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tripIdText: TextView = itemView.findViewById(R.id.trip_id_txt)
        val tripNameText: TextView = itemView.findViewById(R.id.trip_name_txt)
        val tripDestinationText: TextView = itemView.findViewById(R.id.trip_destination_txt)
        val startDateText: TextView = itemView.findViewById(R.id.start_date_txt)
        val endDateText: TextView = itemView.findViewById(R.id.end_date_txt)
        val tripNotesText: TextView = itemView.findViewById(R.id.trip_notes_txt)
    }
}
