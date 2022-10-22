/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample.features.words.presentation.newWord

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.android.roomwordssample.R
import com.google.android.material.slider.Slider
import java.text.SimpleDateFormat
import java.util.*

/**
 * Activity for entering a word.
 */

class NewWordActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var countriesSpinner: Spinner
    lateinit var needSlider: Slider
    val countries = arrayOf("MEXICO", "USA", "OTRO")

    var country: String = "MEXICO"
    var need: String = "1"
    var date: String = ""

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        val editWordView = findViewById<EditText>(R.id.edit_word)
        val dateTextView = findViewById<TextView>(R.id.tv_date_word)

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())
        date = currentDate

        dateTextView.text = "Date: $currentDate"

        countriesSpinner = findViewById(R.id.sp_country)
        countriesSpinner.onItemSelectedListener = this
        val adapter: ArrayAdapter<CharSequence> =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countriesSpinner.adapter = adapter
        val selection = "MEXICO"
        val spinnerPosition: Int = adapter.getPosition(selection)
        countriesSpinner.setSelection(spinnerPosition)

        needSlider = findViewById(R.id.slider_need)

        needSlider.addOnChangeListener { slider, value, fromUser ->
           need = value.toInt().toString()
        }

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                replyIntent.putExtra(EXTRA_COUNTRY, country)
                replyIntent.putExtra(EXTRA_NEED, need)
                replyIntent.putExtra(EXTRA_DATE, date)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
        const val EXTRA_COUNTRY = "com.example.android.wordlistsql.COUNTRY"
        const val EXTRA_NEED = "com.example.android.wordlistsql.NEED"
        const val EXTRA_DATE = "com.example.android.wordlistsql.DATE"
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        country = countries[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}
