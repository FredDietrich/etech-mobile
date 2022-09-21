package org.etech.etechmobile.services;

import android.content.Context;

import org.etech.etechmobile.entidades.Autenticacao;
import org.etech.etechmobile.entidades.Usuario;
import org.etech.etechmobile.helper.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class UsuarioService {

    private IUsuarioService usuarioService;

    public UsuarioService(Context context) {
        usuarioService = RetrofitFactory
                .getInstance(context)
                .getRetrofit()
                .create(IUsuarioService.class);
    }

    public void getUsuarios(Callback<List<Usuario>> usuarioCallBack) {
        Call<List<Usuario>> call = usuarioService.getUsuarios();
        call.enqueue(usuarioCallBack);
    }

    public void autentica(Autenticacao autenticacao, Callback<Usuario> usuarioCallback) {
        Call<Usuario> call = usuarioService.autenticaUsuario(autenticacao);
        call.enqueue(usuarioCallback);
    }

    public void criaUsuario(Usuario usuario, Callback<Usuario> usuarioCallBack) {
        Call<Usuario> call = usuarioService.criaUsuario(usuario);
        call.enqueue(usuarioCallBack);
    }

}

interface IUsuarioService {

    @GET("Usuarios")
    Call<List<Usuario>> getUsuarios();

    @GET("Usuarios/{idUsuario}")
    Call<Usuario> getUsuario(@Path("idUsuario") int idUsuario);

    @POST("Usuarios")
    Call<Usuario> criaUsuario(@Body Usuario usuario);

    @POST("Usuarios/Autentica")
    Call<Usuario> autenticaUsuario(@Body Autenticacao autenticacao);
}
