package org.etech.etechmobile.services;

import android.content.Context;

import org.etech.etechmobile.entidades.Produto;
import org.etech.etechmobile.helper.RetrofitFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class ProdutoService {

     private IProdutoService produtoService;

     public ProdutoService(Context context) {
          this.produtoService = RetrofitFactory
                  .getInstance(context)
                  .getRetrofit()
                  .create(IProdutoService.class);
     }

     public void getProdutos(Callback<List<Produto>> produtoCallBack) {
         Call<List<Produto>> call = produtoService.getProdutos();
         call.enqueue(produtoCallBack);
     }

     public void getProdutoPorIdProduto(int idProduto, Callback<Produto> produtoCallback) {
          Call<Produto> call = produtoService.getProduto(idProduto);
          call.enqueue(produtoCallback);
     }

}

interface IProdutoService {

     @GET("Produtos")
     Call<List<Produto>> getProdutos();
 
     @GET("Produtos/{idProduto}")
     Call<Produto> getProduto(@Path("idProduto") int idProduto);
 
     @POST("Produtos")
     Call<Produto> criaProduto(@Body Produto produto);
 
}