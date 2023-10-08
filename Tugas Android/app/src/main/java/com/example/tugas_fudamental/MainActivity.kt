package com.example.tugas_fudamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var edtnama: EditText
    lateinit var edtumur: EditText
    lateinit var edtpekerjaan: EditText

    lateinit var btn:Button
    val dataBase: FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference: DatabaseReference = dataBase.reference.child("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtnama = findViewById(R.id.Nama)
        edtumur = findViewById(R.id.umur)
        edtpekerjaan = findViewById(R.id.pekerjaan)
        btn = findViewById(R.id.btn_simpan)

        val intent = Intent(this,MainActivity2::class.java)

        btn.setOnClickListener {
            val nama = edtnama.text.toString()
            val umur = edtumur.text.toString()
            val pekerjaan = edtpekerjaan.text.toString()
            reference.child("Nama").setValue(nama)
            reference.child("Umur").setValue(umur)
            reference.child("Pekerjaan").setValue(pekerjaan)
            startActivity(intent)


        }

    }
}