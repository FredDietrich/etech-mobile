package org.etech.etechmobile.ui.carrinho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import org.etech.etechmobile.databinding.FragmentCarrinhoBinding;

public class CarrinhoFragment extends Fragment {

    private org.etech.etechmobile.databinding.FragmentCarrinhoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CarrinhoViewModel carrinhoViewModel =
                new ViewModelProvider(this).get(CarrinhoViewModel.class);

        binding = org.etech.etechmobile.databinding.FragmentCarrinhoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ListView textView = binding.listaCarrinho;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}