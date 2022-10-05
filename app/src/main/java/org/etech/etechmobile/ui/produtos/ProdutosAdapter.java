package org.etech.etechmobile.ui.produtos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.etech.etechmobile.R;
import org.etech.etechmobile.entidades.Produto;

import java.util.List;

public class ProdutosAdapter extends ArrayAdapter<Produto> {

    public ProdutosAdapter(Context context, List<Produto> produtos) {
        super(context, 0, produtos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_produto, parent, false);
        }
        TextView nomeProduto = convertView.findViewById(R.id.nomeProduto);
        TextView precoProduto = convertView.findViewById(R.id.precoProduto);
        nomeProduto.setText(produto.getTitulo());
        precoProduto.setText("R$ " + String.format("%.2f", produto.getPreco()));
        return convertView;
    }

}
