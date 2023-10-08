package com.example.tugas_fudamental.Internt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tugas_fudamental.R
import com.google.firebase.database.*

class MainActivity2 : AppCompatActivity() {
    lateinit var textnama: TextView
    lateinit var textumur: TextView
    lateinit var textpekerjaan: TextView

    private val dataBase: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val referenceGetData: DatabaseReference = dataBase.reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textnama = findViewById(R.id.idNama)
        textumur = findViewById(R.id.idumur)
        textpekerjaan = findViewById(R.id.idpekerja)

        referenceGetData.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val nama:String = snapshot.child("Users").child("Nama").value as String
                val umur:String = snapshot.child("Users").child("Umur").value as String
                val pekerjaan:String = snapshot.child("Users").child("Pekerjaan").value as String
                textnama.text=nama
                textumur.text=umur
                textpekerjaan.text=pekerjaan

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}