package com.example.bitacora20.adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.bitacora20.R;
import com.example.bitacora20.datos.Materia;

public class MateriaAdaptador extends BaseAdapter {
	
	private final Activity actividad;
	private final ArrayList<Materia> materias;
	
	public MateriaAdaptador(Activity actividad, ArrayList<Materia> materias){
		super();
		this.actividad = actividad;
		this.materias = materias;
	}
	
	@Override
	public View getView(int posicion, View vista, ViewGroup padre) {		
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_materias, null, true);

		TextView nombreElemento = (TextView) view.findViewById(R.id.nombre_elemento);
		nombreElemento.setText(materias.get(posicion).getNombre());
		
		TextView cantIntegrantes = (TextView) view.findViewById(R.id.cant_integrantes);
		cantIntegrantes.setText(""+materias.get(posicion).cantidadIntegrantes());
		return view;	
	}
	
	@Override
	public int getCount() {		
		return materias.size();
	}

	@Override
	public Object getItem(int arg0) {
		if(materias != null){
			return materias.get(arg0);
		}
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		Materia unMateria = materias.get(arg0);
		return unMateria.getIdMateria();
				
	}

	

}
