package org.etech.etechmobile.ui.produto;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.etech.etechmobile.entidades.Produto;
import org.etech.etechmobile.services.ProdutoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdutoViewModel extends ViewModel {

    private final MutableLiveData<Produto> produto;

    public ProdutoViewModel() {
        produto = new MutableLiveData<>();
    }

    public void carregaProduto(Context context, int idProduto) {
        new ProdutoService(context).getProdutoPorIdProduto(idProduto ,new Callback<Produto>() {
            @Override
            public void onResponse(Call<Produto> call, Response<Produto> response) {
                if(response.body() != null) {
                    produto.setValue(response.body());
                } else {
                    System.err.println("Erro ao buscar o produto!");
                }
            }
            @Override
            public void onFailure(Call<Produto> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void addToCarrinho(Context context, Produto produto) {

    }

    public LiveData<Produto> getProduto() {
        return produto;
    }
}