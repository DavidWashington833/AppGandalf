package com.example.david.gandalf;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.gandalf.tasks.PegaProdutosCategoriaTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutosCategoriaFragment extends Fragment {

    String id;

    public ProdutosCategoriaFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ProdutosCategoriaFragment(String id) {
        // Required empty public constructor
        this.id = id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produtos_categoria, container, false);
        new PegaProdutosCategoriaTask(ProdutosCategoriaFragment.this, container, id).execute();

        return view;
    }

}
