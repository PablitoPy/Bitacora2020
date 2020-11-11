package com.example.bitacora20.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bitacora20.R;
import com.example.bitacora20.datos.Tema;
import com.example.bitacora20.datos.Usuario;
import com.example.bitacora20.datos.Materia;
import com.example.bitacora20.utils.LogUtils;


public class CrearMateriaActivity extends AppCompatActivity {
    private static final String TAG = "CrearMateriaActivity";
    private EditText campoNombre;
    private EditText campoDescripcion;
    private EditText campoProfesor;
    private Button boton;

    private int idMateria = -1;
    private boolean modoEdicion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_materia);

        campoNombre = (EditText) findViewById( R.id.creacion_nombre_materia );
        campoDescripcion = (EditText) findViewById( R.id.creacion_descripcion_materia );
        campoProfesor = (EditText) findViewById( R.id.creacion_profesor_materia );
        //boton = (Button) findViewById( R.id.boton_crear_grupo );

        // Verificamos si nos llamaron para editar algun grupo
        Bundle extras = getIntent().getExtras();
        if ( extras != null ) {
            idMateria = extras.getInt( "idMateria", -1 );
            if ( idMateria != -1 ) {
                modoEdicion = true;
                campoNombre.setText( Materia.materias.get( idMateria ).getNombre() );
                campoDescripcion.setText( Materia.materias.get( idMateria ).getDescripcion() );
                campoProfesor.setText( Materia.materias.get( idMateria ).getProfesor() );
                //boton.setText( "Editar Grupo" );
            }
        }
    }


    public void crearMateria() { // para boton
        String nombre = campoNombre.getText().toString();
        String descripcion = campoDescripcion.getText().toString();
        String profesor = campoProfesor.getText().toString();

        if ( nombre.equals("") || descripcion.equals("") || profesor.equals("")) {
            desplegarMensajeCamposRequeridos();
        } else {
            if ( modoEdicion ) {
                Materia materia = Materia.materias.get( idMateria );
                materia.setNombre( nombre );
                materia.setDescripcion( descripcion );
                materia.setProfesor( profesor );

                Intent intent = new Intent();
                intent.putExtra("resultado", 1);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Materia materia = new Materia(nombre, descripcion , profesor, Usuario.getUsuarioLogueado());
                Materia.agregarMateria( materia );
                desplegarMensajeResgistroExitoso();

                Intent intent = new Intent();
                intent.putExtra("resultado", 10);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

    public void desplegarMensajeCamposRequeridos() {
        Toast toast = Toast.makeText( this, "Todos los campos son requeridos", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeResgistroExitoso() {
        Toast toast = Toast.makeText( this, "Registro exitoso", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.crear_materia_menu, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item_guardar: {
                Log.d(LogUtils.tag, "Item seleccionado: Guardar");
                crearMateria();
                break;
            }case R.id.item_limpiar:{
                Log.d(LogUtils.tag, "Item seleccionado: Limpiar");
                limpiarCampos();
            }
        }
        return true;
    }

    public void limpiarCampos(){
        campoNombre.setText("");
        campoDescripcion.setText("");
        campoProfesor.setText("");
    }
}