package com.example.bitacora20.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bitacora20.R;
import com.example.bitacora20.datos.Materia;
import com.example.bitacora20.utils.LogUtils;
import java.util.ArrayList;
import com.example.bitacora20.adaptadores.GrupoAdaptador;




public class MateriasListView extends ListActivity {// Modo 1, usa @android:id/list
//public class VerTarjetasActivity extends Activity{ // Modo2, usa id definido por el usuario

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view_materias);

		ArrayList<Materia> materias = Materia.materias;
		Log.d(LogUtils.tag, "CantidadMaterias: " + materias.size());

		// Modo1
		setListAdapter(new GrupoAdaptador(this, materias));

		// Modo 2
		/*
		ListView listTaxista = (ListView) findViewById(R.id.listTaxista);
		listTaxista.setAdapter(new TaxistaAdaptador(this, taxistas));		
		listTaxista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {
                             .
                
                Toast.makeText(getBaseContext(), "Posicion seleccionada: "+position, Toast.LENGTH_LONG).show();
                
            }
        });*/

	}


	//Modo 1
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(this, "Click en fila " + position + ". Id: " + id, Toast.LENGTH_SHORT).show();

		Intent i = new Intent(this, VerDatosMateriaActivity.class);
		i.putExtra("idGrupo", Integer.parseInt("" + id));
		startActivity(i);
	}

	public void lanzarCrearMateria(View view) {
		Intent i = new Intent(this, CrearMateriaActivity.class);
		startActivity(i);

	}
}
