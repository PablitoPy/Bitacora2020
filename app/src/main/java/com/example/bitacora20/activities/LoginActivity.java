package com.example.bitacora20.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bitacora20.datos.Usuario;
import com.example.bitacora20.R;



public class LoginActivity extends Activity {

    private static final String TAG = "LoginActivity";
    private EditText campoNombreUsuario;
    private EditText campoPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Inicia la creacion de la ctividad");
        setContentView(R.layout.activity_login);

        campoNombreUsuario = (EditText) findViewById(R.id.nombre_usuario);
        campoPassword = (EditText) findViewById(R.id.contrasenha);
    }

    public void iniciarSesion(View view) {
        String email = campoNombreUsuario.getText().toString();
        String password = campoPassword.getText().toString();

        if (email.equals("") || password.equals("")) {
            desplegarMensajeUsuarioPasswordNoIngresado();

        } else {
            boolean estaComprobado = Usuario.comprobarCredenciales(email, password);

            if (estaComprobado) {
                Log.i(TAG, "Credenciales correctas");
                setUsuarioLogueado();
                Intent intentMenuPricipal = new Intent(this, MenuPrincipalActivity.class);
                startActivity(intentMenuPricipal);
            } else {
                Log.i(TAG, "Las credenciales son incorrectas");

                desplegarMensajeCredencialesIncorrectas();
            }
        }

    }
    
    public void desplegarMensajeCredencialesIncorrectas() {
        Toast toast = Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void desplegarMensajeUsuarioPasswordNoIngresado() {
        //new UsuarioPasswordDialogFragment().show( getSupportFragmentManager(), TAG);
        showDialogo();
    }

    private void setUsuarioLogueado() {
        String email = campoNombreUsuario.getText().toString();
        Usuario.setUsuarioLogueado(Usuario.getUsuario(email));
    }


    public void showDialogo(){
        new AlertDialog.Builder(this)
                .setTitle("Mensaje de Login")
                .setMessage("Debe ingresar usuario y contraseña")
                .setPositiveButton("Ok", null)
                .show();
    }

}
