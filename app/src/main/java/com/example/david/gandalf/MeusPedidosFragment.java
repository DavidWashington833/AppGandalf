package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class MeusPedidosFragment extends Fragment {

    private ViewGroup mensagens;


    public MeusPedidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meus_pedidos, container, false);
        mensagens = (ViewGroup) view.findViewById(R.id.container);
        addItem("Título 1", "Exemplo de mensagem.");

        return view;
    }

    private void addItem(String textoDoTitulo, String textoDaMensagem) {

        CardView cardView = (CardView) LayoutInflater.from(getActivity()).inflate(R.layout.cardview_pagina_carrinho, mensagens, false);
        ImageView imagem1 = (ImageView) cardView.findViewById(R.id.imagemProd);
        TextView titulo = (TextView) cardView.findViewById(R.id.txtNomeProd);
        titulo.setText(textoDoTitulo);
        mensagens.addView(cardView);

    }

}
