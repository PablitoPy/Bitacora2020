package com.example.bitacora20.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bitacora20.R;
import com.example.bitacora20.adaptadores.TemaAdaptador;
import com.example.bitacora20.datos.Datos;
import com.example.bitacora20.datos.Materia;
import com.example.bitacora20.datos.Tema;
import com.example.bitacora20.utils.LogUtils;
import com.example.bitacora20.utils.RequestCode;

import java.util.ArrayList;

public class TemasListView extends ListActivity {// Modo 1, usa @android:id/list
//public class VerTarjetasActivity extends Activity{ // Modo2, usa id definido por el usuario

	int idMateria = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view_temas);
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			idMateria = extras.getInt("idMateria", -1);
			Log.i(LogUtils.tag, "Id recibido del grupo: "+idMateria);
		}
		Materia unaMateria = Datos.buscarMateria(idMateria);
//		ArrayList<Tema> temas = Tema.temas;
		Log.d(LogUtils.tag, "CantidadTemas: "+unaMateria.getTemascargados().size());
		
		// Modo1
		setListAdapter(new TemaAdaptador(this, unaMateria.getTemascargados()));
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
	public void lanzarCrearTemas(View view) {
		Intent intentCreacionTema = new Intent(this, CrearTemaActivity.class);
		startActivityForResult(intentCreacionTema, RequestCode.ACT_LANZADA_CREAR_GRUPO.getCodigo());

	}
	
	//Modo 1
	@Override
	protected void onListItemClick (ListView l, View v, int position, long id) {
	    Toast.makeText(this, "Click en fila " + position+". Id: "+id, Toast.LENGTH_SHORT).show();

	    Intent i = new Intent(this, VerDatosTemaActivity.class);
        i.putExtra("idGrupo", Integer.parseInt(""+id));
        startActivity(i);
	}



}
