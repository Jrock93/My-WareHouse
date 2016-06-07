package com.example.jrock.warehouse;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jrock on 4/6/2016.
 */
public class Fragment1 extends Fragment {
    ListView listaop;
    String []lista1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment1, container);
        lista1 = getResources().getStringArray(R.array.lista1);
        listaop = (ListView) view.findViewById(R.id.listaop);
        listaop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("item",lista1[position]);
            }
        });




        return view;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
