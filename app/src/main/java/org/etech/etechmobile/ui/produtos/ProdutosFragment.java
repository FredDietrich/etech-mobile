package org.etech.etechmobile.ui.produtos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import org.etech.etechmobile.ProdutosActivity;
import org.etech.etechmobile.R;
import org.etech.etechmobile.databinding.FragmentProdutosBinding;
import org.etech.etechmobile.entidades.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutosFragment extends Fragment {

    private @NonNull FragmentProdutosBinding binding;
    private static final String ARG_ID_PRODUTO = "argidproduto";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProdutosViewModel produtosViewModel =
                new ViewModelProvider(this).get(ProdutosViewModel.class);

        binding = FragmentProdutosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView listaProdutos = binding.listaProdutos;
        produtosViewModel.carregaProdutos(getContext());
        produtosViewModel.getProdutos().observe(getViewLifecycleOwner(), produtos ->  {
            listaProdutos.setAdapter(criaAdapter(produtos));
            listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    vaiParaProduto(produtos.get(i).getIdProduto());
                }
            });
        });
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

    private void vaiParaProduto(int idProduto) {
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_produtos);
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_ID_PRODUTO, idProduto);
        navController.navigate(R.id.action_navigation_produtos_to_produtoFragment, bundle);
    }

}