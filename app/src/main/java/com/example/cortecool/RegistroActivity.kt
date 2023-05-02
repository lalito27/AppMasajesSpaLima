package com.example.cortecool

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cortecool.Controlers.CorteDAO
import com.example.cortecool.Model.Usuario
import kotlinx.android.synthetic.main.activity_registro.*


class RegistroActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
    }

    fun BotonRegistrarR(g:View)
    {
        var sexo:String = ""
        if (RDBF.isChecked)
        {
            sexo= "Femenino"
        }
        else if (RDBM.isChecked)
        {
            sexo = "Masculino"
        }
        var crud= CorteDAO(this)
        var nomb = EDTNOMBRES.text.toString()
        var obj = Usuario(  EDTDNI.text.toString().toInt(),
                            EDTNOMBRES.text.toString(),
                            EDTAPELLIDOS.text.toString(),
                            sexo,
                            EDTDIRECPRI.text.toString(),
                            EDTCELULAR.text.toString().toInt(),
                            0)

        crud.GrabarRegistro(obj)
        Toast.makeText(this, "Usuario ${nomb} registrado correctamente", Toast.LENGTH_LONG).show()

        var m = Intent(this, ServicatalogoActivity::class.java)
        startActivity(m)
    }

    fun BotonSalir(s:View)
    {
        var alertsalida = AlertDialog.Builder(this)
        alertsalida.setTitle("Confirmar cierre")
        alertsalida.setMessage("¿Desea salir de la aplicación?")
        //establecer 2 botones
        //Confirmar
        alertsalida.setPositiveButton("SI", DialogInterface.OnClickListener {
                dialog, which ->
            finishAffinity()
        })
        //Cancelar
        alertsalida.setNegativeButton("NO", DialogInterface.OnClickListener {
                dialog, which ->
            dialog.dismiss()
        })
        alertsalida.show()
    }
}

