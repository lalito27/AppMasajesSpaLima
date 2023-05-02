package com.example.cortecool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CatalocortesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalocortes)
    }

    //Boton ATRÁS
    fun BotonAtras (s: View)
    {
        var q = Intent(this, ServicatalogoActivity::class.java)
        startActivity(q)
    }
}