package com.storegandalf.david.gandalf;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.storegandalf.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.storegandalf.david.gandalf.models.Produto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckoutBoletoFragment extends Fragment {

    Button btnFinalizarCompraBoleto;
    


    public CheckoutBoletoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkout_boleto, container, false);
        

        btnFinalizarCompraBoleto = (Button) view.findViewById(R.id.btnFinalizarCompraBoleto);

        btnFinalizarCompraBoleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Produto> produtos = new ArrayList<Produto>();
                Toast.makeText(view.getContext(), "Pedido efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                CarrinhoSingletonHelper.getInstance().clearProduto(produtos);
                Intent newAct = new Intent(getContext(), MainActivity.class);
                startActivity(newAct);
            }
        });

        return view;
    }

}
