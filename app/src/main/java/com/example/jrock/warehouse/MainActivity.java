package com.example.jrock.warehouse;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    ListView productos;
    ListView lista_opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productos = (ListView)findViewById(R.id.listproductos);
        lista_opciones =(ListView)findViewById(R.id.listaop);
        registerForContextMenu(productos);
        registerForContextMenu(lista_opciones);





    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

       MenuInflater infla = getMenuInflater();
        switch (v.getId()){

            case R.id.listproductos:
                infla.inflate(R.menu.contex_menu,menu);
                break;

            case  R.id.listaop:
                infla.inflate(R.menu.contex_menu,menu);
                Toast.makeText(this,"Configuraciones",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.action_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this,"Configuraciones",Toast.LENGTH_LONG).show();
                return true;
            case R.id.add_produc:
                Toast.makeText(this,"Agregar producto",Toast.LENGTH_LONG).show();

                Intent i = new Intent(this, Create_Producto.class);
                startActivity(i);


                return true;

            case R.id.op_buscar:
                Toast.makeText(this,"Buscar",Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_limpiar:
              return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
