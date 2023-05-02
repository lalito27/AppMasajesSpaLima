package com.example.cortecool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ServiciosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)
    }

    //Boton Salir
    fun BotonSalir (s: View)
    {
        var q = Intent(this, ServicatalogoActivity::class.java)
        startActivity(q)
    }

    //Boton Reserve
    fun BotonReserve (a:View)
    {
        var q = Intent(this, ReserveActivity::class.java)
        startActivity(q)
    }

    //Boton Domicilio
    fun BotonDomicilio (q:View)
    {
        var q = Intent(this, DomicilioActivity::class.java)
        startActivity(q)
    }

    //Boton Solicitados
    fun BotonSolicitados (w:View)
    {
        var q = Intent(this, SolicitadosActivity::class.java)
        startActivity(q)
    }

    //Boton Contactanos
    fun BotonContactanos (e:View)
    {
        var q = Intent(this, ContactanosActivity::class.java)
        startActivity(q)
    }

    fun BotonUsuarios (w:View)
    {
        var q = Intent(this, SolicitadosActivity::class.java)
        startActivity(q)
    }
}