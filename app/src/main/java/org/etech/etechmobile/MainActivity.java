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
import org.etech.etechmobile.ui.produto.ProdutoFragment;

public class MainActivity extends AppCompatActivity {

    private UsuarioService usuarioService;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        usuarioService = new UsuarioService(getApplicationContext());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.login_prefs_key), Context.MODE_PRIVATE);
        int idUsuario = sharedPreferences.getInt(getString(R.string.id_usuario_key), 0);
        if(idUsuario == 0) {
            vaiProLogin();
        } else {
            vaiPraLoja();
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

    private void vaiPraLoja() {
        Intent intent = new Intent(this, ProdutosActivity.class);
        startActivity(intent);
    }

}