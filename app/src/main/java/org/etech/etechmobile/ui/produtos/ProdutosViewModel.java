package org.etech.etechmobile.ui.produtos;

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

public class ProdutosViewModel extends ViewModel {

    private final MutableLiveData<List<Produto>> produtos;

    public ProdutosViewModel() {
        produtos = new MutableLiveData<>();
    }

    public void carregaProdutos(Context context) {
        new ProdutoService(context).getProdutos(new Callback<List<Produto>>() {
            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {
                if(response.body() != null) {
                    produtos.setValue(response.body());
                } else {
                    System.err.println("Erro ao buscar produtos!");
                }
            }

            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<List<Produto>> getProdutos() {
        return produtos;
    }
}