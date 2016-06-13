package com.example.jrock.warehouse;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_Producto extends AppCompatActivity {

    EditText nombre;
    EditText descripcion;
    EditText existencias;
    EditText precio;
    Button btguardar;
    DBAlmacen bdalmacen;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__producto);
        nombre = (EditText)findViewById(R.id.edCnombre);
        descripcion= (EditText)findViewById(R.id.edCdescripcion);
        existencias= (EditText)findViewById(R.id.edCexistencias);
        precio=(EditText)findViewById(R.id.edCprecio);
        btguardar=(Button)findViewById(R.id.btGuardar);

        bdalmacen= new DBAlmacen(this,"DBAlmacen",null,1) ;
        db = bdalmacen.getWritableDatabase();



        btguardar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {

                if (nombre.length()==0){
                    Toast.makeText(v.getContext(), "You did not enter a username", Toast.LENGTH_SHORT).show();
                    return;
                }
                db.execSQL("INSERT INTO Productos (nombre,descripcion,existencias, precio) VALUES ('"+
                nombre.getText()+"','"+descripcion.getText()+"',"+existencias.getText()+","+
                        precio.getText()+")"
                );
                Toast.makeText(v.getContext(),"Guardado",Toast.LENGTH_SHORT);
                finish();

            }
        });


    }



}
