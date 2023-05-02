package com.example.cortecool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ContactanosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactanos)
    }
    fun BotonRegresar (a: View)
    {
        var q = Intent(this, ServiciosActivity::class.java)
        startActivity(q)
    }
}