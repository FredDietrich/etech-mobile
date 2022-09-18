package org.etech.etechmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.login_prefs_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.id_usuario_key), 1);
        editor.apply();
        int idUsuario = sharedPreferences.getInt(getString(R.string.id_usuario_key), 0);
        if(idUsuario == 0) {
            System.out.println("oi");
        } else {
            System.out.println("ta logado");
        }
    }


}