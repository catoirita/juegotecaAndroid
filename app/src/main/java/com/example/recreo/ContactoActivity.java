package com.example.recreo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        // Obtener el TextView del teléfono
        TextView tvTelefono = findViewById(R.id.tvTelefono);

        // Configurar el clic en el TextView
        tvTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Número de teléfono de WhatsApp (en formato internacional)
                String phoneNumber = "59169829158";  // Número sin espacios ni guiones
                openWhatsApp(phoneNumber);
            }
        });

        // Carga el fragmento del mapa
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MapFragment())
                    .commit();
        }
    }

    // Método para abrir WhatsApp con el número especificado
    private void openWhatsApp(String phoneNumber) {
        try {
            // Crear la URL para WhatsApp
            String url = "https://wa.me/" + phoneNumber; // Formato de URL para abrir el chat
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.setPackage("com.whatsapp"); // Asegurarse de que se abra WhatsApp
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


