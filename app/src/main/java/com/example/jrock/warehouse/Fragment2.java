package com.example.jrock.warehouse;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragmento2, container);

        productos = (ListView)view.findViewById(R.id.listproductos);
        loadItems();

        productos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(view.getContext(),Items.get(position).getNombre(), Toast.LENGTH_LONG).show();
            }
        });





        return view;


        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void loadItems() {
        Items = new ArrayList<ItemsT>(); // Creamos un objeto ArrayList de tipo TitularItems

// Agregamos elementos al ArrayList


        Items.add(new ItemsT("Python",100 ,10.0));
        Items.add(new ItemsT("Python1",100 ,10.0));
        Items.add(new ItemsT("Python1",120 ,10.0));
        Items.add(new ItemsT("Python2",120 ,1012.0));
        Items.add(new ItemsT("Python1",120 ,109.0));


        // Creamos un nuevo Adaptador y le pasamos el ArrayList
        Adaptador = new Adaptador(this, Items);

// Desplegamos los elementos en el ListView
        productos.setAdapter(Adaptador);

    }
}
