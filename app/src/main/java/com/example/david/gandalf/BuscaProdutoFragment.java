package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.david.gandalf.tasks.BuscaProdutoTask;
import com.example.david.gandalf.tasks.PegaProdutosTask;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscaProdutoFragment extends Fragment {

    public ListView listView;
    public EditText txtBusca;
    public Button btnBusca;


    public BuscaProdutoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_busca_produto, container, false);
        new BuscaProdutoTask(BuscaProdutoFragment.this).execute();

        listView = (ListView) view.findViewById(R.id.list_produto);
        txtBusca = (EditText) view.findViewById(R.id.txtBusca);
        btnBusca = (Button) view.findViewById(R.id.btnBusca);

        return view;
    }

}
