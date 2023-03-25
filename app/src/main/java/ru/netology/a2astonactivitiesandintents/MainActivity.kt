package ru.netology.a2astonactivitiesandintents


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName
    private var mCount = 0
    private var mShowCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editText = findViewById<EditText>(R.id.edit_text)
        mShowCount = findViewById(R.id.show_count)

        if (savedInstanceState != null) {
            mShowCount?.text = savedInstanceState.getInt("count_num").toString()
            mCount = savedInstanceState.getInt("count_num")
        }


    }


    fun countUp(view: View?) {
        mCount++
        if (mShowCount != null) {
            mShowCount?.text = mCount.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count_num", mCount)
    }
}