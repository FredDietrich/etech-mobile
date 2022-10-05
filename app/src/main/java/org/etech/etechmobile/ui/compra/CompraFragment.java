package org.etech.etechmobile.ui.compra;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.etech.etechmobile.R;
import org.etech.etechmobile.databinding.FragmentCompraBinding;
import org.etech.etechmobile.databinding.FragmentDetalheprodutoBinding;
import org.etech.etechmobile.entidades.Produto;
import org.etech.etechmobile.ui.produtos.ProdutosViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompraFragment extends Fragment {

    private @NonNull FragmentCompraBinding binding;
    private double[] precos;

    public CompraFragment() { }

    public static CompraFragment newInstance(double[] precos) {
        CompraFragment fragment = new CompraFragment();
        Bundle args = new Bundle();
        args.putDoubleArray("precos", precos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            precos = getArguments().getDoubleArray("precos");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments() != null) {
            precos = getArguments().getDoubleArray("precos");
        }
        binding = FragmentCompraBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        CompraViewModel produtoViewModel =
                new ViewModelProvider(this).get(CompraViewModel.class);
        double valorTotal = 0d;
        for(double preco : precos) {
            valorTotal += preco;
        }
        produtoViewModel.setValorTotal(valorTotal);
        produtoViewModel.getValorTotal().observe(getViewLifecycleOwner(), total -> {
            binding.valorTotal.setText("R$ " + String.format("%.2f", total));
        });
        binding.btFinalizarcompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "COMPRA NÃO IMPLEMENTADA!", Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }

}