package com.example.david.gandalf;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.example.david.gandalf.models.Produto;
import com.example.david.gandalf.tasks.PegaProdutoUnicoTask;
import com.example.david.gandalf.tasks.PegaProdutosTask;

import com.google.gson.Gson;
import static android.content.Intent.getIntent;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutoUnicoFragment extends Fragment {

    public ImageView imgP;
    public TextView nomeP, codP, precoP,descP;
    public Button comprar;
    public Produto produtoP;
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
        comprar = (Button) view.findViewById(R.id.btnComprar);


//        new PegaProdutoUnicoTask(ProdutoUnicoFragment.this).execute();


        comprar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                CarrinhoSingletonHelper.getInstance().pushProduto(produtoP);
                Toast t = Toast.makeText(getContext(),"Produto adicionado ao carrinho!",Toast.LENGTH_LONG);
//                String res = new Gson().toJson(CarrinhoSingletonHelper.getInstance().getProduto());
//                Toast t = Toast.makeText(getContext(), res, Toast.LENGTH_LONG);
                t.show();

            }
        });
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