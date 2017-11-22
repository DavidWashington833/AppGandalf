package com.example.david.gandalf;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.gandalf.helpers.CadastroHelper;
import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Endereco;

/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroPt4Fragment extends Fragment {

    private Button btnNext;
    private EditText campEmail;
    private EditText campSenha;
    private EditText campSenhaConfirm;
    private EditText campNewslatter;

    public CadastroPt4Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_cadastro_pt4, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        btnNext = (Button) getActivity().findViewById(R.id.cadastro_proximo_pt4);
        campEmail = (EditText) getActivity().findViewById(R.id.cadastro_email);
        campSenha = (EditText) getActivity().findViewById(R.id.cadastro_senha);
        campSenhaConfirm = (EditText) getActivity().findViewById(R.id.main_senha_confirme);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadastroActivity cadastroActivity = (CadastroActivity) getActivity();
                Cliente cliente = cadastroActivity.getCliente();
                Endereco endereco = cadastroActivity.getEndereco();

                cliente.setEmailCliente(campEmail.getText().toString());
                cliente.setSenhaCliente(campSenha.getText().toString());

                Toast.makeText(getContext(), cadastroActivity.getCliente().getNomeCompletoCliente(), Toast.LENGTH_LONG).show();
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
