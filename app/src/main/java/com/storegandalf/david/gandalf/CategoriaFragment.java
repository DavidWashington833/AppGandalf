package com.storegandalf.david.gandalf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.storegandalf.david.gandalf.tasks.PegaCategoriasTask;

/**
 * Created by igorr on 18/10/2017.
 */

public class CategoriaFragment extends ListFragment {
    EditText reclicado;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_categoria, container, false);
        reclicado = (EditText) view.findViewById(R.id.hiddenReclicado);

//        if(reclicado.getText().equals(reclicado)){
//            new PegaCategoriasTask(CategoriaFragment.this, container).execute();
//        } else{
//            new PegaProdutosCategoriaTask(CategoriaFragment.this, container).execute();
//            reclicado.setText("0");
//        }

        new PegaCategoriasTask(CategoriaFragment.this, container).execute();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}