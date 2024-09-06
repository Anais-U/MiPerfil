package cl.bootcamp.miperfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import cl.bootcamp.miperfil.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el layout usando ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Habilitar EdgeToEdge
        EdgeToEdge.enable(this);

        // Configurar el listener para el botón de contacto
        binding.btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar SecondActivity con un Intent explícito
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // Cargar la imagen de perfil dependiendo de la orientación (portrait o landscape)
        if (binding.ivProfile != null) {
            // Modo portrait
            Glide.with(this)
                    .load("https://i.pinimg.com/1200x/d7/d1/9a/d7d19abbcb32282b00c5742d4f538494.jpg")
                    .into(binding.ivProfile);
        } else if (binding.ivProfileland != null) {
            // Modo landscape
            Glide.with(this)
                    .load("https://i.pinimg.com/1200x/e4/fc/54/e4fc5469bee10940ca96979f6324cbf2.jpg")
                    .into(binding.ivProfileland);
        }

        // Llamar al método para configurar los textos
        textDefault();
    }

    public void textDefault() {
        // Actualizar los textos de presentación
        binding.tvPrincipal.setText(
                String.format(
                        "Soy %s, \n %s", getString(R.string.name),
                        getString(R.string.ocupacion)
                )
        );

        binding.tvParagraph.setText(
                String.format("%s", getString(R.string.paragraph))
        );
    }
}
