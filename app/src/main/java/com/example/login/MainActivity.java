package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Variables
    EditText etUsuario, etPassword;
    Button btnAcceder, btnSalir;
    static final String usuario = "Erick";
    static final String password = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlaces
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnAcceder = (Button) findViewById(R.id.btnAcceder);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        //Oyentes
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarCredenciales();
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void validarCredenciales(){
        String u = etUsuario.getText().toString();
        String p = etPassword.getText().toString();
        if(u.isEmpty() || p.isEmpty()){
            Toast.makeText(getApplicationContext(), "Debes llenar ambos campos",Toast.LENGTH_LONG).show();
        }else{
            if(u.equals(usuario) && p.equals(password)){
                Intent intent1 = new Intent(getApplicationContext(), HomeActivity.class);
                intent1.putExtra("usuario", u);
                intent1.putExtra("edad", 10);
                startActivity(intent1);
            }else{
                Toast.makeText(getApplicationContext(), "El usuario y/o password son incorrectos",Toast.LENGTH_LONG).show();
            }
        }
    }
}