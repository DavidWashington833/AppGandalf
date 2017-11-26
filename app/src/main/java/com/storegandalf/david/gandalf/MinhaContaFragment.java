package com.storegandalf.david.gandalf;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.storegandalf.david.gandalf.helpers.MinhaContaHelper;
import com.storegandalf.david.gandalf.models.Cliente;
import com.storegandalf.david.gandalf.models.Endereco;
import com.storegandalf.david.gandalf.tasks.PegaClienteTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class MinhaContaFragment extends Fragment {

    private MinhaContaHelper helper;

    private Cliente cliente;
    private Endereco endereco;

    private TextView campNome;
    private TextView campNascimento;
    private TextView campCPF;
    private TextView campCep;
    private TextView campEndereco;
    private TextView campNumero;
    private TextView campCidade;
    private TextView campLogradouro;
    private TextView campComplemento;
    private TextView campPais;
    private TextView campUF;
    private TextView campCelular;
    private TextView campResidencial;
    private TextView campComercial;
    private TextView campEmail;
    private TextView campSenha;

    public MinhaContaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minha_conta, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        SharedPreferences preferences = getActivity().getSharedPreferences("login", 0);
        int id  = preferences.getInt("idCliente", 0);
        String idString = String.valueOf(id);

        if (!idString.equals("0")) {
            new PegaClienteTask(this, idString).execute();
        }

        campNome = (TextView) getActivity().findViewById(R.id.minha_conta_nome);
        campNascimento = (TextView) getActivity().findViewById(R.id.minha_conta_nascimento);
        campCPF = (TextView) getActivity().findViewById(R.id.minha_conta_cpf);
        campCep = (TextView) getActivity().findViewById(R.id.minha_conta_cep);
        campEndereco = (TextView) getActivity().findViewById(R.id.minha_conta_endereco);
        campNumero = (TextView) getActivity().findViewById(R.id.minha_conta_numero);
        campCidade = (TextView) getActivity().findViewById(R.id.minha_conta_cidade);
        campLogradouro = (TextView) getActivity().findViewById(R.id.minha_conta_logradouro);
        campComplemento = (TextView) getActivity().findViewById(R.id.minha_conta_complemento);
        campPais = (TextView) getActivity().findViewById(R.id.minha_conta_pais);
        campUF = (TextView) getActivity().findViewById(R.id.minha_conta_uf);
        campCelular = (TextView) getActivity().findViewById(R.id.minha_conta_celular);
        campResidencial = (TextView) getActivity().findViewById(R.id.minha_conta_residencial);
        campComercial = (TextView) getActivity().findViewById(R.id.minha_conta_comercial);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                Cliente cliente = new Cliente();
//                Endereco endereco = new Endereco();
//
//                cliente.setNomeCompletoCliente(campNome.getText().toString());
//                cliente.setDtNascCliente(campNascimento.getText().toString());
//                cliente.setCpfCliente(campCPF.getText().toString());
//                endereco.setCEPEndereco(campCep.getText().toString());
//                endereco.setNomeEndereco(campEndereco.getText().toString());
//                endereco.setNumeroEndereco(campNumero.getText().toString());
//                endereco.setCidadeEndereco(campCidade.getText().toString());
//                endereco.setLogradouroEndereco(campLogradouro.getText().toString());
//                endereco.setComplementoEndereco(campComplemento.getText().toString());
//                endereco.setPaisEndereco(campPais.getText().toString());
//                endereco.setUFEndereco(campUF.getText().toString());
//                cliente.setCelularCliente(campCelular.getText().toString());
//                cliente.setTelResidencialCliente(campResidencial.getText().toString());
//                cliente.setTelComercialCliente(campComercial.getText().toString());
//                cliente.setEmailCliente(campEmail.getText().toString());
//                cliente.setSenhaCliente(campSenha.getText().toString());
//
//            }
//        });

        super.onActivityCreated(savedInstanceState);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
