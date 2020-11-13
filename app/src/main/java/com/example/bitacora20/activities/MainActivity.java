package com.example.bitacora20.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bitacora20.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lanzarLogin (View view ){
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }

    public void lanzarRegistrarse (View view ){
        Intent i = new Intent(this,CrearCuentaActivity.class);
        startActivity(i);
    }
}
