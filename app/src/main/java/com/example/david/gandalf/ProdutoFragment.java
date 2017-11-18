package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.tasks.PegaProdutosTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutoFragment extends Fragment {

    public ImageView imgP;
    public TextView nomeP, codP, precoP,descP;
    public String nome;

    public ProdutoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto, container, false);

        new PegaProdutosTask(ProdutoFragment.this).execute();

        nomeP = (TextView) view.findViewById(R.id.nomeProduto);
        codP = (TextView) view.findViewById(R.id.codigoProduto);
        precoP = (TextView) view.findViewById(R.id.precoProduto);
        descP = (TextView) view.findViewById(R.id.descProduto);

        imgP = (ImageView) view.findViewById(R.id.imgProduto);

        //nomeP.setText("bla");

        nomeP.setText(nome);



        // Inflate the layout for this fragment
        return view;
    }

}