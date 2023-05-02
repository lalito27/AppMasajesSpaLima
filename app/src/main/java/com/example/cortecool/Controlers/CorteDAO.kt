package com.example.cortecool.Controlers

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.cortecool.Model.Domicilio
import com.example.cortecool.Model.Reserva
//import com.example.cortecool.Model.Login
import com.example.cortecool.Model.Usuario
import com.example.cortecool.Model.Vista

class CorteDAO (contexto: Context)
{
    var helper = DataBaseHelper (contexto)
    var mi_contexto = contexto

    fun GrabarRegistro(obj:Usuario)
    {
        var db: SQLiteDatabase = helper.writableDatabase

        var cadena = "insert into registro values(" + obj.dni_usuario + ",'" + obj.nombres_usuario +
                                                    "','" + obj.apellidos_usuario + "','" + obj.sexo_usuario + "','" + obj.direccion_usuariou +
                                                    "'," + obj.celular_usuario + "," + obj.eli_usuario + ");"

        db.execSQL(cadena)

        //Cerrar
        db.close()
    }

    fun GrabarDomicilio(obj:Domicilio)
    {
        var db: SQLiteDatabase = helper.writableDatabase
        var cadena = "insert into domicilio values('"  + obj.servicio_cortes +
                "','" + obj.fecha + "','" + obj.hora + "');"
        db.execSQL(cadena)

        //Cerrar
        db.close()
    }

    fun GrabarReserva(obj:Reserva)
    {
        var db: SQLiteDatabase = helper.writableDatabase
        var cadena = "insert into reserva values('"  + obj.r_servicio_cortes +
                "','" + obj.r_fecha + "','" + obj.r_hora + "');"
        db.execSQL(cadena)

        //Cerrar
        db.close()
    }

    //fun GrabarConfirmacion

//    fun ConsultaLogin(obj: )
//    {
//        var cadena = "SELECT dni_usuario, password_usuario FROM registro"
//    }
fun BotonListarP():ArrayList<Vista>
{
    var lista = ArrayList<Vista>()
    //Abrimos la bd en modo lectura
    var db:SQLiteDatabase = helper.readableDatabase
    //Cursor que manejara las filas devueltas por el select
    //select * from platos where eli_platos = 0;
    var consulta = "SELECT nombres_usuario, direccion_usuariou, celular_usuario FROM registro;"
    var c: Cursor = db.rawQuery(consulta, null)
    //Si el cursor tiene filas
    if (c.count > 0)
    {
        //Leemos el cursor
        while (c.moveToNext())
        {
            //Agregamos los datos al arraylist string
            var obj = Vista(c.getString(0), c.getString(1), c.getInt(2))

            // agregamos los datos al arraylist
            lista.add(obj)
        }
    }
    //Cerramos el cursor y la bd
    c.close()
    db.close()
    //Devolvemos el arrayList string
    return lista
}

}
