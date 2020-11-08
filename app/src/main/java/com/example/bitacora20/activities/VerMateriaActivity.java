package com.example.bitacora20.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.bitacora20.R;

import androidx.appcompat.app.AppCompatActivity;


import static com.example.bitacora20.datos.Materia.materias;

public class VerMateriaActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_materia);

        listView = (ListView) findViewById(R.id.listview1);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,materias);

        listView.setAdapter(arrayAdapter);
    }
}