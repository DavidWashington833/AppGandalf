package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.tasks.BuscaProdutoTask;
import com.example.david.gandalf.tasks.MeusPedidosTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeusPedidosFragment extends Fragment {

    public MeusPedidosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meus_pedidos, container, false);
        new MeusPedidosTask(MeusPedidosFragment.this).execute();

        return view;
    }

}
