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
import com.example.bitacora20.datos.Tema;
import com.example.bitacora20.utils.LogUtils;
import com.example.bitacora20.utils.NotificationsUtils;
import com.example.bitacora20.utils.RequestCode;


public class VerDatosTemaActivity extends AppCompatActivity {
    private static final String TAG = "VerDatosGrupoActivity";
    private static final int PETICION_EDITAR_GRUPO = 1;
    private int idTema = -1;
    private Tema unTema;
    private TextView nombre;
    private TextView fecha;


    Materia unaMateria = null;
    int idMateria = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LogUtils.tag, "Inicia metodo en VerDatosGrupoActivity.onCreate");
        setContentView(R.layout.activity_ver_datos_tema);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            idTema = extras.getInt("idTema", -1);
            Log.i(LogUtils.tag, "Id recibido del tema: "+idTema);
        }

        actualizarVista();

    }

    public void actualizarVista(){
        unaMateria = Datos.buscarMateria(idMateria);

        if ( idTema < 0 || idTema > (unaMateria.getTemas().size()-1) ) {
            desplegarMensajeNoExisteGrupo();
            finish();
            return;
        }

        unTema = unaMateria.getTemas().get( idTema );

        nombre = (TextView) findViewById(R.id.id_nombre_tema_valor);
        nombre.setText( unTema.getNombre() );

        fecha = (TextView) findViewById(R.id.id_fecha_tema_valor);
       fecha.setText(unTema.getFecha());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.ver_tema_menu , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        unaMateria = Datos.buscarMateria(idMateria);
        switch( item.getItemId() ) {
            case R.id.editar_tema:{
                lanzarActividadEdicionGrupo();
                break;
            }
            case R.id.eliminar_tema:{
                unaMateria.getTemas().remove( idTema );
                desplegarMensajeEliminacionGrupo();
                finish();
                break;
            }case R.id.accion_sigte_tar:{
                Log.d(LogUtils.tag, "Item seleccionado: Siguiente");
                opcionSiguiente();
            }

        }
        return true;
    }

    public void opcionSiguiente(){
        unaMateria = Datos.buscarMateria(idMateria);
        idTema++;
        if(idTema < unaMateria.getTemas().size()){
            unTema = unaMateria.getTemas().get(idTema);
            actualizarVista();
        }else{
            Context contexto = getApplicationContext();
            NotificationsUtils.desplegarMensaje("Ya no existen grupos en la lista", contexto);
        }

    }

    private void lanzarActividadEdicionGrupo() {
        Intent i = new Intent( this, CrearTemaActivity.class );
        i.putExtra("idTema", idTema );
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
}
