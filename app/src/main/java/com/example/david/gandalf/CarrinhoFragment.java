package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.david.gandalf.adapter.CarrinhoAdapter;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarrinhoFragment extends Fragment {


    public CarrinhoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Object resposta = CarrinhoSingletonHelper.getInstance().getProduto();
        Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
        CarrinhoAdapter adapter = new CarrinhoAdapter(this.getContext(), Arrays.asList(produtos));
        final ListView listView = (ListView) this.getActivity().findViewById(android.R.id.list);

        listView.setAdapter(adapter);
//        listView.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_carrinho, container, false);

    }

}
