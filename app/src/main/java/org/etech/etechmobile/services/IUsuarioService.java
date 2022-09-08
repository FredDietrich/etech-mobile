package org.etech.etechmobile.services;

import org.etech.etechmobile.entidades.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUsuarioService {

    @GET("/Usuarios")
    Call<List<Usuario>> getUsuarios();

    @GET("/Usuarios/{idUsuario}")
    Call<Usuario> getUsuario(@Path("idUsuario") int idUsuario);

    @POST("/Usuarios/")
    Call<Usuario> criaUsuario(@Body Usuario usuario);

}
