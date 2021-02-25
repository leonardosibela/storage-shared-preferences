package com.sibela.storagesharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clearFromButton.setOnClickListener { clearForm() }
        saveButton.setOnClickListener { saveData() }
        retrieveButton.setOnClickListener { retrieveData() }
    }

    private fun clearForm() {
        nameInput.setText("")
        salaryInput.setText("")
        workingSwitch.isChecked = false
        descriptionInput.setText("")
    }

    private fun saveData() {
        val name = nameInput.text.toString()
        val salary = salaryInput.text.toString().toInt()
        val isWorking = workingSwitch.isChecked
        val description = descriptionInput.text.toString()

        
    }

    private fun retrieveData() {

    }
}