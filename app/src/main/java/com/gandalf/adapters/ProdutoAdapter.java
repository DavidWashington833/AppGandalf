package com.gandalf.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gandalf.R;
import com.gandalf.models.Produto;

import java.util.ArrayList;

/**
 * Created by Igor Ramos on 18/11/2017.
 */

public class ProdutoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Produto> models;

    public ProdutoAdapter(Context context, ArrayList<Produto> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = View.inflate(context, R.layout.fragment_store, null);

        }

        ImageView imageView = (ImageView) view.findViewById(R.id.imagemProd);
        TextView nomeProduto = (TextView) view.findViewById(R.id.txtNomeProd);
        TextView precoProduto = (TextView) view.findViewById(R.id.txtPreco);

        Produto produto = models.get(i);

        nomeProduto.setText(produto.getNomeProduto());
        precoProduto.setText(produto.getPrecProduto());
        byte[] imageAsBytes = Base64.decode(produto.getImagem().getBytes(), Base64.DEFAULT);
        imageView.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

        return view;
    }
}
