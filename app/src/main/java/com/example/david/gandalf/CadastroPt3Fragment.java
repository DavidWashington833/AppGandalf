package com.example.david.gandalf;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.david.gandalf.helpers.CadastroHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroPt3Fragment extends Fragment {

    private Button btnNext;

    public CadastroPt3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_cadastro_pt3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        btnNext = (Button) getActivity().findViewById(R.id.cadastro_proximo_pt3);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CadastroHelper((CadastroActivity) getActivity()).chamaFragment(new CadastroPt4Fragment());
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
