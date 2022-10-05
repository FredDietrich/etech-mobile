package org.etech.etechmobile.ui.produto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.etech.etechmobile.R;

public class ProdutoFragment extends Fragment {

    private static final String ARG_ID_PRODUTO = "argidproduto";

    private Integer idProduto;

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
            System.out.println(idProduto);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalheproduto, container, false);
    }
}