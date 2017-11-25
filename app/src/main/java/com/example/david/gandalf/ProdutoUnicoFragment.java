package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.EditText;
=======
import android.widget.Button;
>>>>>>> origin/CabeloTesteCarrinho
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.example.david.gandalf.models.Produto;
import com.example.david.gandalf.tasks.PegaProdutoUnicoTask;
import com.example.david.gandalf.tasks.PegaProdutosTask;
import com.google.gson.Gson;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutoUnicoFragment extends Fragment {

    public ImageView imgP;
    public TextView nomeP, codP, precoP,descP;
<<<<<<< HEAD
    EditText hiddenId;
=======
    public Button comprar;
    public Produto produtoP;
>>>>>>> origin/CabeloTesteCarrinho

    public ProdutoUnicoFragment() {
        // Required empty public constructor
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
<<<<<<< HEAD

        new PegaProdutoUnicoTask(ProdutoUnicoFragment.this).execute();
=======
        comprar = (Button) view.findViewById(R.id.btnComprar);


        comprar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                CarrinhoSingletonHelper.getInstance().pushProduto(produtoP);
                Toast t = Toast.makeText(getContext(),"Produto adicionado ao carrinho!",Toast.LENGTH_LONG);
//                String res = new Gson().toJson(CarrinhoSingletonHelper.getInstance().getProduto());
//                Toast t = Toast.makeText(getContext(), res, Toast.LENGTH_LONG);
                t.show();

            }
        });

>>>>>>> origin/CabeloTesteCarrinho

        return view;
    }

}