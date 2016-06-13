package com.example.jrock.warehouse;

import android.annotation.TargetApi;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jrock on 4/6/2016.
 */
public class Fragment2 extends Fragment {
    ListView productos;
    private ArrayList<ItemsT> Items;
    private Adaptador Adaptador;

    DBAlmacen bdalmacen;
    SQLiteDatabase db;

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragmento2, container);

        productos = (ListView)view.findViewById(R.id.listproductos);


        bdalmacen= new DBAlmacen(this.getContext(),"DBAlmacen",null,1) ;
        db = bdalmacen.getWritableDatabase();
        loadItems();


        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }



    private void loadItems() {
        Items = new ArrayList<ItemsT>(); // Creamos un objeto ArrayList de tipo TitularItems

        // Agregamos elementos al ArrayList

        Cursor c = db.rawQuery("SELECT * FROM Productos", null);
        if (c.moveToFirst()){
            do {
                Integer codigo = c.getInt(0);
                String nombre = c.getString(1);
                String desc = c.getString(2);
                Integer exis = c.getInt(3);
                Double precio = c.getDouble(4);

                Items.add(new ItemsT(codigo,nombre,desc,exis,precio));
            }while (c.moveToNext());

        }
        //
        //Creamos un nuevo Adaptador y le pasamos el ArrayList

        Adaptador = new Adaptador(this.getContext(), Items);

// Desplegamos los elementos en el ListView
        productos.setAdapter(Adaptador);

    }

    @Override
    public void onStart() {
        super.onStart();
        loadItems();
    }



}
