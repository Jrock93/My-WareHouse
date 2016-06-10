package com.example.jrock.warehouse;

import android.app.Activity;
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


    private Fragment2 activity; //Activity desde el cual se hace referencia al llenado de la lista
    private ArrayList<ItemsT> arrayItems; // Lista de items
    // Constructor con parámetros que recibe la Acvity y los datos de los items.
    public Adaptador(Fragment2 activity, ArrayList<ItemsT> listaItems){
        super();
        this.activity = activity;
        this.arrayItems = new ArrayList<ItemsT>(listaItems);
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

    public static class Fila
    {
        TextView txtNombre;
        TextView textDesc;
        TextView txtExistencias;
        TextView txtPrecio;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fila view = new Fila();
        LayoutInflater inflator = activity.getActivity().getLayoutInflater();
        ItemsT itm = arrayItems.get(position);
/*
Condicional para recrear la vista y no distorcionar el número de elementos
*/
        if(convertView==null)
        {
            convertView = inflator.inflate(R.layout.adapter1, parent, false);
            view.txtNombre = (TextView) convertView.findViewById(R.id.nombreP);
            view.textDesc = (TextView)convertView.findViewById(R.id.desP);
            view.txtExistencias = (TextView) convertView.findViewById(R.id.existvalor);
            view.txtPrecio = (TextView) convertView.findViewById(R.id.valorprecio);
            convertView.setTag(view);
        }
        else
        {
            view = (Fila)convertView.getTag();
        }

// Se asigna el dato proveniente del objeto TitularItems
        view.txtNombre.setText(itm.getNombre());
        view.textDesc.setText("+ "+itm.getDesc());
        view.txtExistencias.setText(String.valueOf(itm.getExistencias()));
        view.txtPrecio.setText("C$ "+ Double.toString(itm.getPrecio()));
// Retornamos la vista
        return convertView;
    }
}