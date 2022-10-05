package org.etech.etechmobile.ui.compra;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.etech.etechmobile.entidades.Produto;
import org.etech.etechmobile.services.ProdutoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompraViewModel extends ViewModel {

    private final MutableLiveData<Double> valorTotal;

    public CompraViewModel() {
        valorTotal = new MutableLiveData<>();
    }

    public LiveData<Double> getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal.setValue(valorTotal);
    }

}