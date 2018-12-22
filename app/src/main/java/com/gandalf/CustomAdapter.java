package com.gandalf;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gandalf.Fragments.StoreFragment;
import com.gandalf.models.Produto;

import java.util.List;

/**
 * Created by Igor Ramos on 18/11/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    private StoreFragment context;
    private List<Produto> produtos;

    public CustomAdapter(StoreFragment context, List<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pagina_carrinho, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nomeProduto.setText(produtos.get(position).getNomeProduto());
        holder.precoProduto.setText(produtos.get(position).getPrecProduto());

        //byte[] imageAsBytes = Base64.decode(holder.imagemProduto.getImagem().getBytes(), Base64.DEFAULT);
       // holder.imagemProduto.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
    }





    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nomeProduto, precoProduto;
        public ImageView imagemProduto;


        public ViewHolder(View itemView) {
            super(itemView);

            nomeProduto = (TextView) itemView.findViewById(R.id.txtNomeProd);
            precoProduto = (TextView) itemView.findViewById(R.id.txtPreco);
            //imagemProduto = (ImageView) itemView.findViewById(R.id.imagemProd);
        }
    }
}
