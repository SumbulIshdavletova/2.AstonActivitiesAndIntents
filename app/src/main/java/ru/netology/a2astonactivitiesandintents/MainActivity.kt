package ru.netology.a2astonactivitiesandintents

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat


class MainActivity : AppCompatActivity() {

    private var mWebsiteEditText: EditText? = null
    private var mLocationEditText: EditText? = null
    private var mShareTextEditText: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)

        val openWebsite = findViewById<Button>(R.id.open_website_button)
        openWebsite.setOnClickListener {
            openWebsite()
        }
        val openLoc = findViewById<Button>(R.id.open_location_button)
        openLoc.setOnClickListener {
            openLocation()
        }

        val shareText = findViewById<Button>(R.id.share_text_button)
        shareText.setOnClickListener {
            shareText()
        }
        val camera = findViewById<Button>(R.id.take_picture_button)
        camera.setOnClickListener {
            takePictureIntent()
        }

    }

    private fun openWebsite() {
        val url = mWebsiteEditText?.text.toString()
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.d("ImplicitIntents", "Open Website Error")
        }
    }

    private fun openLocation() {
        val loc = mLocationEditText?.text.toString()

        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        try {
            startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            Log.d("ImplicitIntents", "Open Location Error")
        }
    }

    private fun shareText() {
        val txt = mShareTextEditText?.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder(this)
            .setType(mimeType)
            .setChooserTitle(R.string.share_text_with)
            .setText(txt)
            .startChooser()
    }

    private fun takePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivity(takePictureIntent)
        } catch (e: ActivityNotFoundException) {
            Log.d("ImplicitIntents", "Camera error")
        }
    }

}

//постараться убрать все !! во всех ветках