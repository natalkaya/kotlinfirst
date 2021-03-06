package com.bee.kotlinfirst

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var dataClass = Detail.random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        initButton(R.id.button_change_name)
        initEditTexts(
                Pair(R.id.data_class_name, dataClass.name),
                Pair(R.id.data_class_value, dataClass.value)
        )
        initClickListenerButtons(R.id.button_change_name, R.id.button_change_value)
    }

    private fun initButton(id: Int) {
        findViewById<Button>(id)
    }

    private fun initEditTexts(vararg idsText: Pair<Int, String>) {
        for ((id, text) in idsText) {
            val tv = findViewById<EditText>(id)
            tv.textSize = 25F
            tv.text.clear()
            tv.text.append(text)
        }
    }

    private fun initClickListenerButtons(vararg ids: Int) {
        for (id in ids) {
            findViewById<View>(id).setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        if (v != null) when (v.id) {
            R.id.button_change_name -> {
                dataClass = dataClass.copy(name = Detail.randomString(10))
                initEditTexts(Pair(R.id.data_class_name, dataClass.name))
            }
            R.id.button_change_value -> {
                dataClass = dataClass.copy(value = Detail.randomString())
                initEditTexts(Pair(R.id.data_class_value, dataClass.value))
            }
        }
    }
}