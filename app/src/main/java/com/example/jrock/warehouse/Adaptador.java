package com.example.jrock.warehouse;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jrock on 5/6/2016.
 */
public class Adaptador extends BaseAdapter {

    LayoutInflater inflater;
    private ArrayList<ItemsT> arrayItems; // Lista de items
    private Context contexto;
    // Constructor con parámetros que recibe la Acvity y los datos de los items.
    public Adaptador(Context activity, ArrayList<ItemsT> listaItems){
        super();
        this.contexto = activity;
        inflater=LayoutInflater.from(activity);
        this.arrayItems = listaItems;
    }

    @Override
    public int getCount() {
        return arrayItems.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter1, null);
        ItemsT itm = arrayItems.get(position);
        TextView nombre = (TextView) convertView.findViewById(R.id.nombreP);
        TextView descripcion= (TextView) convertView.findViewById(R.id.desP);
        TextView existencias = (TextView) convertView.findViewById(R.id.existvalor);
        TextView precio =(TextView)convertView.findViewById(R.id.valorprecio);

        nombre.setText(itm.getNombre());
        descripcion.setText(itm.getDesc());
        existencias.setText(String.valueOf(itm.getExistencias()));
        precio.setText(String.valueOf(itm.getPrecio()));


        return convertView;
    }
}