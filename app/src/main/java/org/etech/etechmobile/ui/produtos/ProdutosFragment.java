package org.etech.etechmobile.ui.produtos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.etech.etechmobile.R;
import org.etech.etechmobile.databinding.FragmentProdutosBinding;
import org.etech.etechmobile.entidades.Produto;

import java.util.List;

public class ProdutosFragment extends Fragment {

    private @NonNull FragmentProdutosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProdutosViewModel produtosViewModel =
                new ViewModelProvider(this).get(ProdutosViewModel.class);

        binding = FragmentProdutosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final GridView listaProdutos = binding.listaProdutos;
        produtosViewModel.carregaProdutos(getContext());
        produtosViewModel.getProdutos().observe(getViewLifecycleOwner(), produtos -> listaProdutos.setAdapter(criaAdapter(produtos)));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private ArrayAdapter<Produto> criaAdapter(List<Produto> produtos) {
        ArrayAdapter<Produto> adapter = new ProdutosAdapter(getContext(), produtos);
        return adapter;
    }

}