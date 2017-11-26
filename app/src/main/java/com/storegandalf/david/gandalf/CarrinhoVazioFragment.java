package com.storegandalf.david.gandalf;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarrinhoVazioFragment extends Fragment {


    Button btnLoja;
    public CarrinhoVazioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrinho_vazio, container, false);
        // Inflate the layout for this fragment

        Button btnLoja = (Button) view.findViewById(R.id.voltarLojaCarrinho);

        btnLoja.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newAct = new Intent(getContext(), MainActivity.class);
                startActivity(newAct);

            }
        });
        return view;
    }


}

