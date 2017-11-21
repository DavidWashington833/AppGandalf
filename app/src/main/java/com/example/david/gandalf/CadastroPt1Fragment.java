package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.david.gandalf.tasks.PegaCategoriasTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroPt1Fragment extends Fragment {

    public CadastroPt1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_cadastro_pt1, container, false);
    }

}
