package com.example.cortecool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ServicatalogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicatalogo)
    }

    //Boton Cortes
    fun BotonCortes (s: View)
    {
        var q = Intent(this, CatalocortesActivity::class.java)
        startActivity(q)
    }

    //Boton Servicios
    fun BotonServicios (a:View)
    {
        var q = Intent(this, ServiciosActivity::class.java)
        startActivity(q)
    }

    fun BotonSalir (s: View)
    {
        finishAffinity()
    }
}