package org.etech.etechmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.etech.etechmobile.databinding.ActivityMainBinding;
import org.etech.etechmobile.services.UsuarioService;
import org.etech.etechmobile.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private UsuarioService usuarioService;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        usuarioService = new UsuarioService(getApplicationContext());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.login_prefs_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getString(R.string.id_usuario_key), 1);
        editor.apply();
        int idUsuario = sharedPreferences.getInt(getString(R.string.id_usuario_key), 0);
        if(idUsuario == 0) {
            vaiProLogin();
        } else {
            System.out.println("ta logado, loja WIP");
        }

        binding.botaovaiprologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiProLogin();
            }
        });
    }

    private void vaiProLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}