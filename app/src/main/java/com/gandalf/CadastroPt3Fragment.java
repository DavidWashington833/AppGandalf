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
public class CadastroPt3Fragment extends Fragment {

    private Button btnNext;
    private EditText campCelular;
    private EditText campResidencial;
    private EditText campComercial;

    public CadastroPt3Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_cadastro_pt3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        btnNext = (Button) getActivity().findViewById(R.id.cadastro_proximo_pt3);
        campCelular = (EditText) getActivity().findViewById(R.id.cadastro_celular);
        campResidencial = (EditText) getActivity().findViewById(R.id.cadastro_residencial);
        campComercial = (EditText) getActivity().findViewById(R.id.cadastro_comercial);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadastroActivity cadastroActivity = (CadastroActivity) getActivity();
                Cliente cliente = cadastroActivity.getCliente();

                cliente.setCelularCliente(campCelular.getText().toString());
                cliente.setTelResidencialCliente(campResidencial.getText().toString());
                cliente.setTelComercialCliente(campComercial.getText().toString());

                new CadastroHelper((CadastroActivity) getActivity()).chamaFragment(new CadastroPt4Fragment());
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
