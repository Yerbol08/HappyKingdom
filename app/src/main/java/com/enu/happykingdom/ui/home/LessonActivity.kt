package com.enu.happykingdom.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.enu.happykingdom.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore


class LessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val position = getIntent().getIntExtra("position", 0)
        val title = getIntent().getStringExtra("name")
        val image = getIntent().getIntExtra("image", R.drawable.image)
        val text = getIntent().getStringExtra("text")
        val imageView = findViewById<ImageView>(R.id.imageView)
        val titleText = findViewById<TextView>(R.id.title)
        val textView = findViewById<TextView>(R.id.text_lesson)
        val btn = findViewById<Button>(R.id.btnZapis)
        imageView.setImageResource(image)
        titleText.text = title
        when(position){
            0-> textView.setText(R.string.lab_tv)
            1-> textView.setText(R.string.piano)
            2-> textView.setText(R.string.repetiters)
            3-> textView.setText(R.string.podgotovka)
            4-> textView.setText(R.string.psich)
            5-> textView.setText(R.string.minisad)

        }

        btn.setOnClickListener(View.OnClickListener {
            val mAuth = FirebaseAuth.getInstance();
            val currentUser: FirebaseUser? =  mAuth.getCurrentUser()
            val userName: String? = currentUser?.displayName
            val db = FirebaseFirestore.getInstance()
            val dbConference = db.collection("Lessons")
            val data = ZapisItems(title.toString(), userName.toString(), text.toString())
            dbConference.add(data).addOnSuccessListener {
                Toast.makeText(applicationContext, "Вы записались!", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener { e ->
                Toast.makeText(applicationContext,"Fail to add course \n$e", Toast.LENGTH_SHORT).show()
            }
        })

    }
}