package com.storegandalf.david.gandalf;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PermissaoFragment extends Fragment {

    Button btnFazerLoginPermissao;


    public PermissaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  =  inflater.inflate(R.layout.fragment_permissao, container, false);

        btnFazerLoginPermissao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newAct = new Intent(getContext(), LoginActivity.class);
                startActivity(newAct);
            }
        });

        return v;
    }

}
