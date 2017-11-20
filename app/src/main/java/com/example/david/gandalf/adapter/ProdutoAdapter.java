package com.example.david.gandalf.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.R;
import com.example.david.gandalf.models.Produto;

import java.util.List;

/**
 * Created by Silva on 18/11/2017.
 */

public class ProdutoAdapter extends BaseAdapter {
    private final List<Produto> produtos;
    private final Context context;

    public ProdutoAdapter(Context context, List<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(produtos.get(position).getIdProduto());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produto produto = produtos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.cardview_produtos, parent, false);
        }

        TextView campoNome = (TextView) view.findViewById(R.id.txtNomeProd);
        campoNome.setText(produto.getNomeProduto());

        TextView campoPreco = (TextView) view.findViewById(R.id.txtPreco);
        campoPreco.setText(produto.getPrecProduto());

        ImageView campoImg = (ImageView) view.findViewById(R.id.imagemProd);
        String imagem = produto.getImagem();
        if (imagem != null) {
            byte[] imageAsBytes = Base64.decode(imagem.getBytes(), Base64.DEFAULT);
            campoImg.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
        }

        return view;
    }
}
