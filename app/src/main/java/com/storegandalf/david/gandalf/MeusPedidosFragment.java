package com.storegandalf.david.gandalf;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storegandalf.david.gandalf.tasks.MeusPedidosTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeusPedidosFragment extends Fragment {
    Integer id;

    public MeusPedidosFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public MeusPedidosFragment(Integer id) {
        // Required empty public constructor
        this.id = id;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meus_pedidos, container, false);
        new MeusPedidosTask(MeusPedidosFragment.this, id).execute();

        return view;
    }

}
