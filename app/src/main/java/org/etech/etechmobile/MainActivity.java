package org.etech.etechmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import org.etech.etechmobile.databinding.ActivityMainBinding;
import org.etech.etechmobile.services.UsuarioService;

public class MainActivity extends AppCompatActivity {

    private UsuarioService usuarioService;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuarioService = new UsuarioService();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", 0);
        int idUsuario = sharedPreferences.getInt("idUsuario", 0);
        if(idUsuario == 0) {
            //leva pro login
        } else {
            //leva para a loja
        }
    }


}