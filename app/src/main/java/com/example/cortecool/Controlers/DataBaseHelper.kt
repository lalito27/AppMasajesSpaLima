package com.example.cortecool.Controlers

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(contex:Context): SQLiteOpenHelper(contex, "BDCORTECOOL", null, 1) {
    var tabla_registro:String= "create table IF NOT EXISTS registro("+
                                "dni_usuario INTEGER PRIMARY KEY,"+
                                "nombres_usuario TEXT," +
                                "apellidos_usuario TEXT,"+
                                "sexo_usuario TEXT,"+
                                "direccion_usuariou TEXT,"+
                                "celular_usuario INTEGER," +
                                "eli_usuario INTEGER);"

    var tabla_domicilio:String= "create table IF NOT EXISTS domicilio("+
                                "servicio_cortes TEXT," +
                                "fecha TEXT," +
                                "hora TEXT);"

    var tabla_reserva:String=   "create table IF NOT EXISTS reserva("+
                                "r_servicio_cortes TEXT," +
                                "r_fecha TEXT," +
                                "r_hora TEXT);"

    //INSERT INTO
    var ins_usuario1:String=    "insert into registro values(" +
                                "47105247, " +
                                "'Elena Sharon', " +
                                "'Ramirez Pacheco', " +
                                "'Femenino', " +
                                "'Av. La marina 2457', " +
                                "982147415, "+ 0 + ");"

    var ins_domicilio1:String=  "insert into domicilio values(" +
                                "'Normal'," +
                                "'11/12/2020'," +
                                "'12:00');"

    var ins_reserva1:String=    "insert into reserva values(" +
                                "'Escolar'," +
                                "'12/12/2020'," +
                                "'12:00');"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(tabla_registro)
        db.execSQL(tabla_domicilio)
        db.execSQL(tabla_reserva)

        db.execSQL(ins_usuario1)
        db.execSQL(ins_domicilio1)
        db.execSQL(ins_reserva1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}

