package com.storegandalf.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.storegandalf.david.gandalf.tasks.PegaEnderecoTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditarEnderecoFragment extends Fragment {

    public TextView cep, rua, complemento, numero, cidade, estado, pais;
    Button btnSalvar;
    String id;

    public EditarEnderecoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_editar_endereco, container, false);

        id = "5";

        new PegaEnderecoTask(EditarEnderecoFragment.this,id).execute();

        return view;
    }

}
