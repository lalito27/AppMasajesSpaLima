package com.example.cortecool

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cortecool.Controlers.CorteDAO
import com.example.cortecool.Model.Domicilio
import kotlinx.android.synthetic.main.activity_domicilio.*
import kotlinx.android.synthetic.main.activity_reserve.*
//import kotlinx.android.synthetic.main.activity_reserve.BTNHORA
//import kotlinx.android.synthetic.main.activity_reserve.EDTHORA
import java.util.*

class DomicilioActivity : AppCompatActivity()
{
    var normal:Double = 0.0
    var escolar:Double = 0.0
    var militar:Double = 0.0
    var moderno:Double = 0.0
    var corte:Double= 0.0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_domicilio)
        var cal = Calendar.getInstance()
        var dia = cal.get(Calendar.DAY_OF_MONTH)
        var mes = cal.get(Calendar.MONTH)
        var anio = cal.get(Calendar.YEAR)
        var hora = cal.get(Calendar.HOUR_OF_DAY)
        var minuto = cal.get(Calendar.MINUTE)
        //
        TVFECHA.setText(""+ dia + "/" + (mes + 1) + "/" + anio)
        EDTHORA.setText("" + hora + ":" + minuto)
        //

        BTNHORA.setOnClickListener {
            var tp = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                EDTHORA.setText("" + hourOfDay + ":" + minute)
            }, hora, minuto, false)
            tp.show()
        }

//        BTNCONFIRMAR.setOnLongClickListener {
//            var i = Intent(this, SolicitadosActivity::class.java)
//            if (RDBNORMAL.isChecked())
//            {
//                corte = 10.0
//            }
//            else if (RDBESCOLAR.isChecked()) {
//                corte = 15.0
//            }
//
//            corte =
//        }
    }

    fun BotonRegresar (a: View)
    {
        var q = Intent(this, ServiciosActivity::class.java)
        startActivity(q)
    }

    fun BotonConfirmar(a:View)
    {
        var corte:String = ""

        if (RDBNORMALD.isChecked)
        {
            corte = "Normal"
        }
        else if (RDBESCOLARD.isChecked)
        {
            corte = "Escolar"
        }
        else if(RDBMILITARD.isChecked)
        {
            corte = "Militar"
        }
        else if(RDBMODERNOD.isChecked)
        {
            corte = "Moderno"
        }

        var crud= CorteDAO(this)
        var obj = Domicilio(corte,
                TVFECHA.text.toString(),
                EDTHORA.text.toString())
        crud.GrabarDomicilio(obj)

        Toast.makeText(this, "Nueva Solicitud Grabado Correctamente", Toast.LENGTH_LONG).show()
    }
}