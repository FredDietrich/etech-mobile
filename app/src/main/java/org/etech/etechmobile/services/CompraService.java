package org.etech.etechmobile.services;

import org.etech.etechmobile.entidades.Compra;
import org.etech.etechmobile.helper.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class CompraService {

    private Retrofit retrofit = RetrofitFactory.getInstance().getRetrofit();

    ICompraService compraService = retrofit.create(ICompraService.class);

    public void getCompras(Callback<List<Compra>> compraCallBack) {
        Call<List<Compra>> call = compraService.getCompras();
        call.enqueue(compraCallBack);
    }

}

interface ICompraService {

    @GET("Compras")
    Call<List<Compra>> getCompras();

    @GET("Compras/{idCompra}")
    Call<Compra> getCompra(@Path("idCompra") int idCompra);

    @POST("Compras")
    Call<Compra> criaCompra(@Body Compra compra);

}
