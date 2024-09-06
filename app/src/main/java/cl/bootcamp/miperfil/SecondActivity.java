package cl.bootcamp.miperfil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import cl.bootcamp.miperfil.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    // Declarar el binding
    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Habilitar EdgeToEdge
        EdgeToEdge.enable(this);

        // Inflar el layout usando ViewBinding
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Configurar los textos
        setupTextViews();

        // Configurar los intents para los íconos de contacto
        setupContactIcons();
    }

    // Método para configurar los TextView
    private void setupTextViews() {
        binding.tvtitulo.setText(getString(R.string.tvtitulo));
        binding.tvcontacto.setText(getString(R.string.tvcontacto));
    }

    // Método para configurar los íconos de contacto
    private void setupContactIcons() {
        // Listener para WhatsApp
        binding.ivWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir WhatsApp con el número predefinido
                String phoneNumber = "56997361544";  // Reemplaza con tu número
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://wa.me/" + phoneNumber));
                startActivity(intent);
            }
        });

        // Listener para LinkedIn
        binding.ivLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir perfil de LinkedIn
                String linkedInUrl = "https://www.linkedin.com";  // Reemplaza con tu URL de LinkedIn
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInUrl));
                startActivity(intent);
            }
        });

        // Listener para Correo Electrónico
        binding.ivEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Enviar correo electrónico
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"terapiasancestralescl@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Desarrollo de aplicaciones");
                intent.putExtra(Intent.EXTRA_TEXT, "Hola, Anais Urra");
                startActivity(Intent.createChooser(intent, "Enviar correo"));
            }
        });
    }
}
