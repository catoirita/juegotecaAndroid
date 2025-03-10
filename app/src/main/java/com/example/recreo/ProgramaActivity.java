package com.example.recreo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProgramaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa);

        // Referencia al TextView
        TextView textoPrograma = findViewById(R.id.textoPrograma);

        // Obtener el contenido HTML desde strings.xml
        String contenidoHTML = getString(R.string.programa_recreo);

        // Convertir el texto a Spanned (compatible con Android)
        Spanned textoFormateado;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textoFormateado = Html.fromHtml(contenidoHTML, Html.FROM_HTML_MODE_LEGACY);
        } else {
            textoFormateado = Html.fromHtml(contenidoHTML);
        }

        // Establecer el texto en el TextView
        textoPrograma.setText(textoFormateado);

        // Referencia al botón
        Button btnInfo = findViewById(R.id.btnInfo);

        // Configurar el listener del botón
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón (redirigir a otra actividad o mostrar información)
                Intent intent = new Intent(ProgramaActivity.this, ContactoActivity.class);
                startActivity(intent);
            }
        });
    }
}
