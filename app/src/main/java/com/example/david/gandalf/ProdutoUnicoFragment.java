package com.example.david.gandalf;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.tasks.PegaProdutoUnicoTask;
import com.example.david.gandalf.tasks.PegaProdutosTask;

import static android.content.Intent.getIntent;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutoUnicoFragment extends Fragment {

    public ImageView imgP;
    public TextView nomeP, codP, precoP,descP;
    EditText hiddenId;
    String id;

    public ProdutoUnicoFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ProdutoUnicoFragment(String id) {
        // Required empty public constructor
        this.id = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto_unico, container, false);

        nomeP = (TextView) view.findViewById(R.id.nomeProduto);
        codP = (TextView) view.findViewById(R.id.codigoProduto);
        precoP = (TextView) view.findViewById(R.id.precoProduto);
        descP = (TextView) view.findViewById(R.id.descProduto);
        imgP = (ImageView) view.findViewById(R.id.imgProduto);
        hiddenId = (EditText) view.findViewById(R.id.hiddenIdProd);

        Intent intent = getActivity().getIntent();
        String t = intent.getStringExtra("idProduto");

        if(t != null) {
            new PegaProdutoUnicoTask(ProdutoUnicoFragment.this, t).execute();
        } else {
            new PegaProdutoUnicoTask(ProdutoUnicoFragment.this, id).execute();
        }


        return view;
    }

}