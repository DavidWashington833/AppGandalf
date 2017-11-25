package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.david.gandalf.tasks.BuscaProdutoTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscaProdutoFragment extends Fragment {

    EditText txtBusca;
    Button btnBusca;

    public BuscaProdutoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_busca_produto, container, false);

        txtBusca = (EditText) view.findViewById(R.id.txtBuscaProduto);
        btnBusca = (Button) view.findViewById(R.id.btnBusca);

        btnBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BuscaProdutoTask(BuscaProdutoFragment.this).execute();
            }
        });

        return view;
    }

}
