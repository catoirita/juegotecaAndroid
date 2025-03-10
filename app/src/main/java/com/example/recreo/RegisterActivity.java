package com.example.recreo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editNombre, editApellido, editEmail, editContrasena, editTelefono;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);

        // Inicializar los campos
        editNombre = findViewById(R.id.editNombre);
        editApellido = findViewById(R.id.editApellido);
        editEmail = findViewById(R.id.editEmail);
        editContrasena = findViewById(R.id.editContrasena);
        editTelefono = findViewById(R.id.editTelefono);
        btnRegistro = findViewById(R.id.btnRegistro);

        // Cuando el usuario presiona el botón de registro
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editNombre.getText().toString();
                String apellido = editApellido.getText().toString();
                String email = editEmail.getText().toString();
                String contrasena = editContrasena.getText().toString();
                String telefono = editTelefono.getText().toString();

                // Validar que los campos no estén vacíos
                if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty() || telefono.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Insertar datos
                boolean insertado = myDb.insertarDatos(nombre, apellido, email, contrasena, telefono);
                if (insertado) {
                    Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_LONG).show();

                    // Redirigir a LoginActivity después de un registro exitoso
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // Cierra la actividad de registro para que no vuelva al presionar 'back'
                } else {
                    Toast.makeText(RegisterActivity.this, "Registro fallido", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
