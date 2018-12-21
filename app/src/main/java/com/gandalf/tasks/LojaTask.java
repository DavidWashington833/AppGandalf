package com.gandalf.tasks;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gandalf.LojaFragment;
import com.gandalf.R;
import com.gandalf.WebClient;
import com.gandalf.models.Produto;
import com.google.gson.Gson;

/**
 * Created by Igor Ramos on 18/11/2017.
 */

public class LojaTask extends AsyncTask<Void, Void, String> {
    private LojaFragment context;
    private ViewGroup mensagens;

    public LojaTask(LojaFragment context) {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://192.168.15.12:8084/Gandalf/rest/produto/");
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {

        if (!resposta.equals("null")) {

        }


    }

    private void addItem(String resposta) {

        CardView cardView = (CardView) LayoutInflater.from(context.getActivity()).inflate(R.layout.cardview_pagina_carrinho, mensagens, false);

        Produto p = new Gson().fromJson(resposta, Produto.class);


        TextView nomeP = (TextView) context.getActivity().findViewById(R.id.txtNomeProd);
        TextView precoP = (TextView) context.getActivity().findViewById(R.id.txtPreco);
        ImageView imgP = (ImageView) context.getActivity().findViewById(R.id.imagemProd);

        mensagens = (ViewGroup) context.getActivity().findViewById(R.id.container);

        nomeP.setText(p.getNomeProduto());
        precoP.setText(p.getPrecProduto());

        byte[] imageAsBytes = Base64.decode(p.getImagem().getBytes(), Base64.DEFAULT);
        imgP.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));



//        ImageView imagemProd = (ImageView) cardView.findViewById(R.id.imagemProd);
//
//        TextView nome = (TextView) cardView.findViewById(R.id.txtNomeProd);
//        nome.setText(nomeProd.toString());
//
//        TextView preco = (TextView) cardView.findViewById(R.id.txtPreco);
//        preco.setText(precoP.toString());
//
//        mensagens.addView(cardView);

    }

    }