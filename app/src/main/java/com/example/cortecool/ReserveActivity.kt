package com.example.cortecool

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import com.example.cortecool.Controlers.CorteDAO
import com.example.cortecool.Model.Domicilio
import com.example.cortecool.Model.Reserva
import kotlinx.android.synthetic.main.activity_domicilio.*
import kotlinx.android.synthetic.main.activity_reserve.*
//import kotlinx.android.synthetic.main.activity_reserve.BTNHORA
//import kotlinx.android.synthetic.main.activity_reserve.EDTHORA
import java.util.*

class ReserveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserve)

        var cal = Calendar.getInstance()
        var dia = cal.get(Calendar.DAY_OF_MONTH)
        var mes = cal.get(Calendar.MONTH)
        var anio = cal.get(Calendar.YEAR)
        var hora = cal.get(Calendar.HOUR_OF_DAY)
        var minuto = cal.get(Calendar.MINUTE)
        //
        EDTFECHAR.setText(""+ dia + "/" + (mes + 1) + "/" + anio)
        EDTHORAR.setText("" + hora + ":" + minuto)
        //
        EDTFECHAR.setOnClickListener {
            var dp = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                EDTFECHAR.setText("" + dayOfMonth + "/" + (month + 1) + "/" + year)
            },anio, mes, dia)
            dp.show()
        }

        BTNHORAR.setOnClickListener {
            var tp = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                EDTHORAR.setText("" + hourOfDay + ":" + minute)
            }, hora, minuto, false)
            tp.show()
        }
    }

    fun BotonRegresar (a: View)
    {
        var q = Intent(this, ServiciosActivity::class.java)
        startActivity(q)
    }

    fun BotonConfirmar(h:View)
    {
        var corte:String = ""

        if (RDBNORMALR.isChecked)
        {
            corte = "Normal"
        }
        else if (RDBESCOLARR.isChecked)
        {
            corte = "Escolar"
        }
        else if(RDBMILITARR.isChecked)
        {
            corte = "Militar"
        }
        else if(RDBMODERNOR.isChecked)
        {
            corte = "Moderno"
        }

        var crud= CorteDAO(this)
        var objr = Reserva(corte,
                EDTFECHAR.text.toString(),
                EDTHORAR.text.toString())
        crud.GrabarReserva(objr)

        Toast.makeText(this, "Nueva Solicitud Grabado Correctamente", Toast.LENGTH_LONG).show()
    }
}