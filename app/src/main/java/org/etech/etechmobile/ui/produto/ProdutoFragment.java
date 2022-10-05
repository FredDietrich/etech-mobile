package org.etech.etechmobile.ui.produto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.etech.etechmobile.R;
import org.etech.etechmobile.databinding.FragmentDetalheprodutoBinding;
import org.etech.etechmobile.entidades.Produto;
import org.etech.etechmobile.ui.produtos.ProdutosViewModel;

public class ProdutoFragment extends Fragment {

    private static final String ARG_ID_PRODUTO = "argidproduto";
    private @NonNull FragmentDetalheprodutoBinding binding;
    private Integer idProduto;
    private Produto produtoAtual;

    public ProdutoFragment() { }

    public static ProdutoFragment newInstance(Integer idProduto) {
        ProdutoFragment fragment = new ProdutoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID_PRODUTO, idProduto);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idProduto = getArguments().getInt(ARG_ID_PRODUTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments() != null) {
            idProduto = getArguments().getInt(ARG_ID_PRODUTO);
        }
        binding = FragmentDetalheprodutoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ProdutoViewModel produtoViewModel =
                new ViewModelProvider(this).get(ProdutoViewModel.class);
        produtoViewModel.carregaProduto(getContext(), idProduto);
        produtoViewModel.getProduto().observe(getViewLifecycleOwner(), produto -> {
            produtoAtual = produto;
            binding.headerText.setText(produto.getTitulo());
            binding.descricaoProduto.setText(produto.getDescricao());
            binding.precoProduto.setText("R$ " + String.format("%.2f", produto.getPreco()));
        });

        binding.btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiPraCompra();
            }
        });

        binding.btCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produtoViewModel.addToCarrinho(getContext());
            }
        });

        return root;
    }

    private void vaiPraCompra() {
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_produtos);
        Bundle bundle = new Bundle();
        bundle.putDoubleArray("precos", new double[]{produtoAtual.getPreco()});
        navController.navigate(R.id.action_produtoFragment_to_compraFragment, bundle);
    }

}