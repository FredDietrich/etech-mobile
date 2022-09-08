package org.etech.etechmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.etech.etechmobile.entidades.Usuario;
import org.etech.etechmobile.services.IUsuarioService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()

                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")

                .create();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:5169/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IUsuarioService usuarioService = retrofit.create(IUsuarioService.class);

        Usuario usuario = new Usuario();

        usuario.setLogin("testeAndroid");
        usuario.setSenha("testeAndroid");
        usuario.setNome("testeAndroid");
        usuario.setCpf("00000000000");

        Call<Usuario> call = usuarioService.criaUsuario(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                t.printStackTrace();
                System.out.println("nao deu");
            }
        });

    }
}