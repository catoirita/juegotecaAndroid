package com.example.recreo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recreo.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsuario, edtContrasena;
    Button btnIngresar;
    DatabaseHelper myDb;  // Asegúrate de tener una clase DatabaseHelper para manejar la verificación de usuario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializa los elementos de la interfaz
        edtUsuario = findViewById(R.id.edtUsuario);
        edtContrasena= findViewById(R.id.edtContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);
        myDb = new DatabaseHelper(this);  // Asegúrate de que DatabaseHelper esté bien implementado

        // Configura el botón de login
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén los datos del EditText
                String email = edtUsuario.getText().toString();
                String contrasena = edtContrasena.getText().toString();

                // Verificar credenciales
                boolean loginExitoso = myDb.verificarUsuario(email, contrasena);
                if (loginExitoso) {
                    // Mensaje de éxito
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_LONG).show();

                    // Redirigir a PrincipalActivity
                    Intent intent = new Intent(LoginActivity.this, PricipalActivity.class);
                    startActivity(intent);
                    finish();  // Cierra la actividad de login
                } else {
                    // Mensaje de error
                    Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
