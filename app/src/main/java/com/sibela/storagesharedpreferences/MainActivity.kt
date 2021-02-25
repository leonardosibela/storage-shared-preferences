package com.sibela.storagesharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val NAME_KEY = "NAME_KEY"
        const val SALARY_KEY = "SALARY_KEY"
        const val IS_WORKING_KEY = "IS_WORKING"
        const val DESCRIPTION_KEY = "DESCRIPTION_KEY"
    }

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

        val preferences = getPreferences(Context.MODE_PRIVATE)
        with(preferences.edit()) {
            putString(NAME_KEY, name)
            putInt(SALARY_KEY, salary)
            putBoolean(IS_WORKING_KEY, isWorking)
            putString(DESCRIPTION_KEY, description)
            commit()
        }
        clearForm()
    }

    private fun retrieveData() {
        val preferences = getPreferences(Context.MODE_PRIVATE)
        val nameData = preferences.getString(NAME_KEY, "")
        val salaryData = preferences.getInt(SALARY_KEY, 0)
        val isWorkingData = preferences.getBoolean(IS_WORKING_KEY, false)
        val descriptionData = preferences.getString(DESCRIPTION_KEY, "")

        nameInput.setText(nameData)
        salaryInput.setText(salaryData.toString())
        workingSwitch.isChecked = isWorkingData
        descriptionInput.setText(descriptionData)
    }
}