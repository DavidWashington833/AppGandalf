package com.example.david.gandalf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by igorr on 18/10/2017.
 */

public class FragmentCategoria extends ListFragment {

    String categorias[] = {"Teste 1", "Teste 2", "Teste 3", "Teste 4", "Teste 5", "Teste 6", "Teste 7", "Teste 8", "Teste 9", "Teste 10"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.list_categoria, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, categorias);

        setListAdapter(adapter);
    }
}
