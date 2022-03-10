package com.example.fastcampus_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private val resultTextView : TextView by lazy {
        findViewById(R.id.resultTextView)
    }

    private val firebaseTokenTextView : TextView by lazy {
        findViewById(R.id.firebaseTokenTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFirebase()
    }

    private fun initFirebase() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if(it.isSuccessful){
                firebaseTokenTextView.text = it.result
                Log.d("Token", it.result)
            }
        }
    }
}