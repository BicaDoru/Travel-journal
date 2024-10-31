package com.example.myapplication

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: FloatingActionButton

    private lateinit var myDB: MyDatabaseHelper
    private var tripId = ArrayList<String>()
    private var tripName = ArrayList<String>()
    private var tripDestination = ArrayList<String>()
    private var startDate = ArrayList<String>()
    private var endDate = ArrayList<String>()
    private var tripNotes = ArrayList<String>()

    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        addButton = findViewById(R.id.add_button)

        addButton.setOnClickListener {
            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)
        }

        myDB = MyDatabaseHelper(this@MainActivity)

        storeDataInArrays()

        customAdapter = CustomAdapter(this, tripId, tripName, tripDestination, startDate, endDate, tripNotes)
        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun storeDataInArrays() {
        val cursor: Cursor = myDB.readAllData()
        if (cursor.count == 0) {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show()
        } else {
            while (cursor.moveToNext()) {
                tripId.add(cursor.getString(0))
                tripName.add(cursor.getString(1))
                tripDestination.add(cursor.getString(2))
                startDate.add(cursor.getString(3))
                endDate.add(cursor.getString(4))
                tripNotes.add(cursor.getString(5))
            }
        }
    }
}
