package com.example.david.gandalf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.david.gandalf.tasks.PegaProdutosCategoriaTask;

/**
 * Created by igorr on 18/10/2017.
 */



public class FragmentCategoria extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_categoria, container, false);
        new PegaProdutosCategoriaTask(FragmentCategoria.this, container).execute();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
