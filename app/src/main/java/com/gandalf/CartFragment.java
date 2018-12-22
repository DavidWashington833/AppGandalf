package com.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gandalf.adapter.CarrinhoAdapter;
import com.gandalf.helpers.CarrinhoSingletonHelper;
import com.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);

        String result = new Gson().toJson(CarrinhoSingletonHelper.getInstance().getProduto());
        if (!result.equals("null")) {
//                Toast t = Toast.makeText(getContext(), result, Toast.LENGTH_LONG);
//                t.show();
            final Produto[] produtos = new Gson().fromJson(result, Produto[].class);
            final CarrinhoAdapter adapter = new CarrinhoAdapter(this.getContext(), Arrays.asList(produtos));
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
