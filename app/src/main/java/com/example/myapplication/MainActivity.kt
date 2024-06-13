package com.example.myapplication

import android.os.Bundle
import android.text.InputType
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listToDo: ListView
    private lateinit var buttonAdd: FloatingActionButton
    private lateinit var items: ArrayList<String>
    private lateinit var itemAdapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listToDo = findViewById(R.id.listToDo)
        buttonAdd = findViewById(R.id.buttonAdd)
        items = ArrayList()

        items.add("Bananen")
        items.add("Milch")
        items.add("Reis")

        itemAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listToDo.adapter = itemAdapter

        buttonAdd.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Hinzufügen")

            var input = EditText(this)
            input.hint = "Text eingeben"
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)

            builder.setPositiveButton("OK") { dialog, which ->
                items.add(input.text.toString())
            }

            builder.setNegativeButton("Abbrechen") { dialog, which ->
                Toast.makeText(applicationContext, "Abgebrochen", Toast.LENGTH_SHORT)
            }
            builder.show()
        }
    }
}