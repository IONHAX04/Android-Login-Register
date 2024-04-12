package com.example.thiru

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thiru.databinding.ActivityUserProfileEditPageBinding
import java.util.Calendar

class UserProfileEditPage : AppCompatActivity() {

    private lateinit var userProfileEditPageBinding: ActivityUserProfileEditPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        userProfileEditPageBinding = ActivityUserProfileEditPageBinding.inflate(layoutInflater)
        setContentView(userProfileEditPageBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userProfileEditPageBinding.calender.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dateOfMonth ->
                    userProfileEditPageBinding.dateOfBirthText.text =
                        (dateOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        val cgpaSpinner = userProfileEditPageBinding.cgpa
        val editText = userProfileEditPageBinding.sslcPercentage

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.percentage_cgpa_options,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        cgpaSpinner.adapter = adapter

        cgpaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                val filters: Array<InputFilter>
                if (selectedItem == "Percentage") {
                    filters = arrayOf(InputFilter.LengthFilter(5), InputFilterMinMax("0.00", "10.00"))
                } else {
                    filters = arrayOf(InputFilter.LengthFilter(6), InputFilterMinMax("0.00", "100.00"))
                }
                editText.filters = filters
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }
}
