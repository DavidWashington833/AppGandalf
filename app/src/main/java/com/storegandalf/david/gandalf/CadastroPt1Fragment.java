package com.storegandalf.david.gandalf;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.storegandalf.david.gandalf.helpers.CadastroHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroPt1Fragment extends Fragment {

    private Button btnNext1;

    public CadastroPt1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_cadastro_pt1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        btnNext1 = (Button) getActivity().findViewById(R.id.cadastro_proximo_pt1);

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CadastroHelper((CadastroActivity) getActivity()).chamaFragment(new CadastroPt2Fragment());
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

}
