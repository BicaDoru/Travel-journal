package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.sql.Date

class AddActivity : ComponentActivity() {
    private lateinit var nameInput: EditText
    private lateinit var destinationInput: EditText
    private lateinit var startInput: EditText
    private lateinit var endInput: EditText
    private lateinit var notesInput: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        nameInput = findViewById(R.id.name_input)
        destinationInput = findViewById(R.id.destination_input)
        startInput = findViewById(R.id.start_input)
        endInput = findViewById(R.id.end_input)
        notesInput = findViewById(R.id.notes_input)
        addButton = findViewById(R.id.add_button)

        addButton.setOnClickListener {
            val myDB = MyDatabaseHelper(this@AddActivity)
            myDB.addTrip(
                nameInput.text.toString().trim(),
                destinationInput.text.toString().trim(),
                startInput.text.toString().trim(),
                endInput.text.toString().trim(),
                notesInput.text.toString().trim()
            )
        }
    }
}
