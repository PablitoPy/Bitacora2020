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
import com.example.bitacora20.datos.Usuario;
import com.example.bitacora20.datos.Tema;
import com.example.bitacora20.utils.LogUtils;

public class CrearTemaActivity extends AppCompatActivity {
    private static final String TAG = "CrearGrupoActivity";
    private EditText campoNombre;
    private EditText campoFecha;
    private Button boton;

    private int idGrupo = -1;
    private boolean modoEdicion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tema);

        campoNombre = (EditText) findViewById( R.id.creacion_nombre_tema );
        campoFecha = (EditText) findViewById( R.id.creacion_fecha_tema );
        //boton = (Button) findViewById( R.id.boton_crear_grupo );

        // Verificamos si nos llamaron para editar algun grupo
        Bundle extras = getIntent().getExtras();
        if ( extras != null ) {
            idGrupo = extras.getInt( "idGrupo", -1 );
            if ( idGrupo != -1 ) {
                modoEdicion = true;
                campoNombre.setText( Tema.temas.get( idGrupo ).getNombre() );
                campoFecha.setText( Tema.temas.get( idGrupo ).getFecha() );
                //boton.setText( "Editar Grupo" );
            }
        }
    }

    ///public void crearGrupo(View view) { // para boton
    public void crearGrupo() { // para boton
        String nombre = campoNombre.getText().toString();
        String fecha = campoFecha.getText().toString();

        if ( nombre.equals("") || fecha.equals("") ) {
            desplegarMensajeCamposRequeridos();
        } else {
            if ( modoEdicion ) {
                Tema tema = Tema.temas.get( idGrupo );
                tema.setNombre( nombre );
                tema.setFecha( fecha );

                Intent intent = new Intent();
                intent.putExtra("resultado", 1);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Tema tema = new Tema( nombre, fecha );
                Tema.agregarTema( tema );
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
        getMenuInflater().inflate(R.menu.crear_tema_menu, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item_guardar: {
                Log.d(LogUtils.tag, "Item seleccionado: Guardar");
                crearGrupo();
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
        campoFecha.setText("");
    }
}
