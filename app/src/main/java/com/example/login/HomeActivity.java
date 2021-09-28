package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView tvSaludo;
    EditText etMensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Activamos el botón de back o home en el actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //enlaces
        tvSaludo = (TextView) findViewById(R.id.tvSaludo);
        etMensaje = (EditText) findViewById(R.id.etMensaje);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        cargarSaludo();

        //oyentes
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMensaje();
            }
        });
    }

    private void cargarSaludo(){
        Intent intent1 = getIntent();
        String usuario = intent1.getStringExtra("usuario");
        int edad = intent1.getIntExtra("edad", 0);
        tvSaludo.append(usuario +" edad: " + edad);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    private void enviarMensaje(){
        String mensaje = etMensaje.getText().toString();
        Intent intentExterno = new Intent();
        intentExterno.setAction(Intent.ACTION_SEND);
        intentExterno.putExtra(Intent.EXTRA_TEXT, mensaje);
        intentExterno.setType("text/plain");

        Intent intentChooser = Intent.createChooser(intentExterno, null);
        startActivity(intentChooser);
    }
}