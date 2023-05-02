package com.example.cortecool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cortecool.Adaptadores.CorteAdaptador
import com.example.cortecool.Controlers.CorteDAO
import kotlinx.android.synthetic.main.activity_solicitados.*

class SolicitadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitados)

        var crud = CorteDAO(this)

        var mi_lista = crud.BotonListarP()

        var mi_adaptador = CorteAdaptador(this, R.layout.item, mi_lista)

        lvcorte.adapter = mi_adaptador
    }
}