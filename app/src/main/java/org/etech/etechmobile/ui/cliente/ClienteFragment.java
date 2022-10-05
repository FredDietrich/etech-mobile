package org.etech.etechmobile.ui.cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.etech.etechmobile.databinding.FragmentClienteBinding;

public class ClienteFragment extends Fragment {

    private FragmentClienteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClienteViewModel clienteViewModel =
                new ViewModelProvider(this).get(ClienteViewModel.class);

        binding = FragmentClienteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.nomeUsuario;
        clienteViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}