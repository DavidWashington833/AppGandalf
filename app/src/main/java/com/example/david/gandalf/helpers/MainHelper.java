package com.example.david.gandalf.helpers;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david.gandalf.MainActivity;
import com.example.david.gandalf.R;

/**
 * Created by felip on 08/11/2017.
 */

public class MainHelper {

    private MainActivity context;
    private ViewGroup mensagens;

    public MainHelper(MainActivity context) {
        this.context = context;
    }

    public void mostrarProduto() {
        mensagens = (ViewGroup) context.findViewById(R.id.container);

        for(int i = 0; i<5; i++){
            addItem("Produto Exemplo", "R$99,99");
        }
    }

    private void addItem(String nomeProduto,
                         String precoProduto) {
        CardView cardView = (CardView) LayoutInflater.from(context)
                .inflate(R.layout.cardview_pagina_carrinho, mensagens, false);
        TextView titulo = (TextView)
                cardView.findViewById(R.id.txtNomeProd);
        TextView mensagem = (TextView)
                cardView.findViewById(R.id.txtPreco);
        titulo.setText(nomeProduto);
        mensagem.setText(precoProduto);
        mensagens.addView(cardView);
    }
}
