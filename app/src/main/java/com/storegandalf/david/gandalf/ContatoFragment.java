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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContatoFragment extends Fragment {

    public Button btnEnviarMensagem;


    public ContatoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contato, container, false);

        btnEnviarMensagem = (Button) view.findViewById(R.id.btnEnviarMensagem);

        btnEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "Mensagem enviada com sucesso!", Toast.LENGTH_SHORT).show();
                Intent newAct = new Intent(getContext(), MainActivity.class);
                startActivity(newAct);

            }
        });

        return view;
    }

}
