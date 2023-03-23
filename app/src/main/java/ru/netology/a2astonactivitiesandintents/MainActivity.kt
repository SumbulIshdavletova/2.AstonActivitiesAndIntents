package ru.netology.a2astonactivitiesandintents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName
    private var mCount = 0
    private var mShowCount: TextView? = null
    val EXTRA_MESSAGE = "ru.netology.a2astonactivitiesandintents.MESSAGE"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)

    }

    fun launchSecondActivity(view: View) {
        val intent = Intent(this, SecondActivity::class.java)

        val message = mCount.toString()
        intent.putExtra("EXTRA_MESSAGE", message)
        startActivity(intent)

    }

    fun countUp(view: View?) {
        mCount++
        if (mShowCount != null) {
            mShowCount!!.text = mCount.toString()
        }
    }
}