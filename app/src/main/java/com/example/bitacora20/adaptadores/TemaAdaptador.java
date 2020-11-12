package com.example.bitacora20.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bitacora20.datos.Datos;
import com.example.bitacora20.datos.Materia;
import com.example.bitacora20.datos.Tema;
import com.example.bitacora20.R;

import java.util.ArrayList;

import static com.example.bitacora20.datos.Datos.materias;
import static com.example.bitacora20.datos.Datos.temas1;


public class TemaAdaptador extends BaseAdapter {

	private final Activity actividad;
	private final ArrayList<Tema> lista;

	Materia unaMateria = null;
	int idMateria = 0;

	public TemaAdaptador(Activity actividad, ArrayList<Tema> lista){
		super();
		this.actividad = actividad;
		this.lista = lista;
	}
	
	@Override
	public View getView(int posicion, View vista, ViewGroup padre) {
		unaMateria = Datos.buscarMateria(idMateria);
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_temas, null, true);


		TextView nombreElemento = (TextView) view.findViewById(R.id.nombre_elemento);

		nombreElemento.setText(unaMateria.getTemas().get(posicion).getNombre());
		
		TextView cantIntegrantes = (TextView) view.findViewById(R.id.cant_integrantes);
		cantIntegrantes.setText(""+ materias.get(posicion).cantidadIntegrantes());
		return view;	
	}
	
	@Override
	public int getCount() {		
		return lista.size();
	}

	@Override
	public Object getItem(int arg0) {
		if(lista != null){
			return lista.get(arg0);
		}
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		Tema unTema = lista.get(arg0);
		return unTema.getId();
				
	}

	

}
