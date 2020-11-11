package com.example.bitacora20.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bitacora20.R;
import com.example.bitacora20.datos.Datos;
import com.example.bitacora20.datos.Materia;
import com.example.bitacora20.utils.LogUtils;
import com.example.bitacora20.utils.NotificationsUtils;
import com.example.bitacora20.utils.RequestCode;


public class VerDatosMateriaActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosMateriaActivity";
    private static final int PETICION_EDITAR_GRUPO = 1;
    private int idMateria = -1;
    private Materia unaMateria;
    private TextView nombre;
    private TextView descripcion;
    private TextView profesor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerDatosGrupoActivity.onCreate");
        setContentView(R.layout.activity_ver_datos_materia);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idMateria = extras.getInt("idGrupo", -1);
            Log.i(LogUtils.tag, "Id recibido del grupo: "+idMateria);
        }

        actualizarVista();
    }

    public void actualizarVista(){
        if ( idMateria < 0 || idMateria > (Datos.materias.size()-1) ) {
            desplegarMensajeNoExisteGrupo();
            finish();
            return;
        }

        unaMateria = Datos.materias.get( idMateria );

        nombre = (TextView) findViewById(R.id.id_nombre_materia_valor);
        nombre.setText( unaMateria.getNombre() );

        descripcion = (TextView) findViewById(R.id.id_descripcion_materia_valor);
        descripcion.setText(unaMateria.getDescripcion());

        profesor = (TextView) findViewById(R.id.id_profesor_materia_valor);
        descripcion.setText(unaMateria.getDescripcion());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.ver_materia_menu , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch( item.getItemId() ) {
            case R.id.editar_materia:{
                lanzarActividadEdicionGrupo();
                break;
            }
            case R.id.eliminar_materia:{
                Datos.materias.remove( idMateria );
                desplegarMensajeEliminacionGrupo();
                finish();
                break;
            }case R.id.accion_sigte_tar:{
                Log.d(LogUtils.tag, "Item seleccionado: Siguiente");
                opcionSiguiente();
            } case R.id.menu_refresh:{
                desplegarMensajeActualizadoGrupo();
                finish();
            }
        }
        return true;
    }

    public void opcionSiguiente(){
        idMateria++;
        if(idMateria < Datos.materias.size()){
            unaMateria = Datos.materias.get(idMateria);
            actualizarVista();
        }else{
            Context contexto = getApplicationContext();
            NotificationsUtils.desplegarMensaje("Ya no existen grupos en la lista", contexto);
        }

    }

    private void lanzarActividadEdicionGrupo() {
        Intent i = new Intent( this, CrearMateriaActivity.class );
        i.putExtra("idMateria", idMateria );
        startActivityForResult( i, RequestCode.PETICION_EDITAR_GRUPO.getCodigo());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dato) {
        super.onActivityResult(requestCode, resultCode, dato);
        if (requestCode == RequestCode.PETICION_EDITAR_GRUPO.getCodigo()) {
            if (resultCode == RESULT_OK) {
                Bundle extras = dato.getExtras();
                int resultado = extras.getInt("resultado", -1);
                if (resultado == 1) {
                    desplegarMensajeEdicioGrupoExitoso();
                    actualizarVista();
                }
            }
        }
    }

    public void desplegarMensajeEliminacionGrupo() {
        Toast toast = Toast.makeText( this, "El grupo fue eliminado", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeEdicioGrupoExitoso() {
        Toast toast = Toast.makeText( this, "Los datos del grupo fueron editados", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeNoExisteGrupo() {
        Toast toast = Toast.makeText( this, "El grupo no existe", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void desplegarMensajeActualizadoGrupo() {
        Toast toast = Toast.makeText( this, "Actualizado", Toast.LENGTH_SHORT);
        toast.show();
    }
}
