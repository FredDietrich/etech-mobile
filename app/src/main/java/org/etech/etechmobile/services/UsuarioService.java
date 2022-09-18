package org.etech.etechmobile.services;

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

    private Retrofit retrofit = RetrofitFactory.getInstance().getRetrofit();

    IUsuarioService usuarioService = retrofit.create(IUsuarioService.class);

    public void getUsuarios(Callback<List<Usuario>> usuarioCallBack) {
        Call<List<Usuario>> call = usuarioService.getUsuarios();
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
