package com.example.jrock.warehouse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jrock on 7/6/2016.
 */
public class DBAlmacen extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Productos (codigo INTEGER, nombre TEXT,descripcion TEXT, existencias INTEGER, precio REAL)";
    String sqlUpgrade = "CREATE TABLE Productos (codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,descripcion TEXT, existencias INTEGER, precio REAL)";

    public DBAlmacen(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {


        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos la base de datos si no existe
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //aqui pondriamos si quisieramos actualizar nuestra base de datos
        db.execSQL("DROP TABLE IF EXISTS productos");
        db.execSQL(sqlUpgrade);
    }
}
