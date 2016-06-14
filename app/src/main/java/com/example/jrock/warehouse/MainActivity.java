package com.example.jrock.warehouse;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    ListView productos;
    ListView lista_opciones;
    DBAlmacen bdalmacen;
    SQLiteDatabase db;
    int posi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bdalmacen= new DBAlmacen(this,"DBAlmacen",null,1) ;
        //db = bdalmacen.getWritableDatabase();

        productos = (ListView)findViewById(R.id.listproductos);

        lista_opciones =(ListView)findViewById(R.id.listaop);
        registerForContextMenu(productos);
        registerForContextMenu(lista_opciones);

        lista_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(view.getContext(),"Vender",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(view.getContext(),"Comprar",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(view.getContext(),"Estadisticas",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(view.getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

        productos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             posi=position;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        TextView etiqueta = null;

        MenuInflater infla = getMenuInflater();
        switch (v.getId()){

            case R.id.listproductos:




                infla.inflate(R.menu.contex_menu,menu);
               // Toast.makeText(this,"Configuraciones",Toast.LENGTH_LONG).show();
                break;
            //case  R.id.listaop:
              //  Toast.makeText(this,"Configuraciones",Toast.LENGTH_LONG).show();
                //break;
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

                AlertDialog.Builder biulder = new AlertDialog.Builder(this);
                biulder.setTitle("Cuidado...");
                biulder.setMessage("Se borraran todos los registros, Estas seguro?");
                biulder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bdalmacen= new DBAlmacen(MainActivity.this,"DBAlmacen",null,1) ;
                        db = bdalmacen.getWritableDatabase();
                        Toast.makeText(MainActivity.this,"Eliminado",Toast.LENGTH_LONG).show();
                        db.delete("Productos",null,null);
                        db.execSQL("DROP TABLE IF EXISTS Productos");
                        db.execSQL("CREATE TABLE Productos (codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,descripcion TEXT, existencias INTEGER, precio REAL)");

                        db.close();
                    }
                });
                biulder.setNegativeButton(android.R.string.cancel,null);
                Dialog dialogo = biulder.create();
                dialogo.show();





              return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
