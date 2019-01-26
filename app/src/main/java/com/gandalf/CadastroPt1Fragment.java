package com.gandalf;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gandalf.helpers.CadastroHelper;
import com.gandalf.models.Cliente;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroPt1Fragment extends Fragment {

    private Button btnNext1;
    private EditText campNome;
    private EditText campNascimento;
    private EditText campCPF;

    public CadastroPt1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_cadastro_pt1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        btnNext1 = (Button) getActivity().findViewById(R.id.cadastro_proximo_pt1);
        campNome = (EditText) getActivity().findViewById(R.id.cadastro_nome);
        campNascimento = (EditText) getActivity().findViewById(R.id.cadastro_nascimento);
        campCPF = (EditText) getActivity().findViewById(R.id.cadastro_cpf);

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadastroActivity cadastroActivity = (CadastroActivity) getActivity();
                Cliente cliente = cadastroActivity.getCliente();

                cliente.setNomeCompletoCliente(campNome.getText().toString());
                cliente.setDtNascCliente(campNascimento.getText().toString());
                cliente.setCpfCliente(campCPF.getText().toString());
                
                new CadastroHelper((CadastroActivity) getActivity()).chamaFragment(new CadastroPt2Fragment());
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

}
