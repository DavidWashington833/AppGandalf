package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.tasks.PegaProdutoUnicoTask;
import com.example.david.gandalf.tasks.PegaProdutosTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProdutoFragment extends Fragment {

    EditText hiddenId;

    public ProdutoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto, container, false);

        hiddenId = (EditText) view.findViewById(R.id.hiddenIdProd);

        new PegaProdutosTask(ProdutoFragment.this).execute();

        return view;
    }

}