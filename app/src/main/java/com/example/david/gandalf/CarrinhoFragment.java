package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.david.gandalf.adapter.CarrinhoAdapter;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarrinhoFragment extends Fragment {


    public CarrinhoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);

        String result = new Gson().toJson(CarrinhoSingletonHelper.getInstance().getProduto());

        if (result != null && !result.equals("[null]")) {
//                Toast t = Toast.makeText(getContext(), result, Toast.LENGTH_LONG);
//                t.show();
            final Produto[] produtos = new Gson().fromJson(result, Produto[].class);

            List<Produto> plist = new ArrayList<Produto>();
            plist.addAll(Arrays.asList(produtos));
            final CarrinhoAdapter adapter = new CarrinhoAdapter(this.getContext(), plist);
            final ListView listView = (ListView) view.findViewById(R.id.list_produto_carrinho);

            listView.setAdapter(adapter);

        }

        return view;
        /*
        * private Type listType = new TypeToken<List<Endereco>>(){}.getType();
        *
        * List<Endereco> lista = new Gson().fromJson(resposta, listType);
        *
        * cep.setText(lista.get(0).getCEPEndereco());
        *
        * Categoria[] categorias = new Gson().fromJson(resposta, Categoria[].class);

        final ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(context.getContext(), android.R.layout.simple_list_item_1, categorias);

        final ListView listView = (ListView) context.getActivity().findViewById(android.R.id.list);
        *
        *
        *
        * */

    }

}
