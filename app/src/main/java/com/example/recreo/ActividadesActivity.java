package com.example.recreo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        // Encontrar los botones por su ID
        Button buttonDanzaUrbana = findViewById(R.id.ButtonDanzaUrbana);
        Button buttonPreBallet = findViewById(R.id.ButtonPreBallet);
        Button buttonClubCiencias = findViewById(R.id.ButtonClubCiencias);
        Button buttonApoyoEscolar = findViewById(R.id.buttonApoyoEscolar);

        // Configurar los listeners para cada botón
        buttonDanzaUrbana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir al usuario a ContactoActivity
                Intent intent = new Intent(ActividadesActivity.this, ContactoActivity.class);
                startActivity(intent);
            }
        });

        buttonPreBallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir al usuario a ContactoActivity
                Intent intent = new Intent(ActividadesActivity.this, ContactoActivity.class);
                startActivity(intent);
            }
        });

        buttonClubCiencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir al usuario a ContactoActivity
                Intent intent = new Intent(ActividadesActivity.this, ContactoActivity.class);
                startActivity(intent);
            }
        });

        buttonApoyoEscolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir al usuario a ContactoActivity
                Intent intent = new Intent(ActividadesActivity.this, ContactoActivity.class);
                startActivity(intent);
            }
        });
    }
}
