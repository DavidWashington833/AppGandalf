package com.example.david.gandalf;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Endereco;
import com.example.david.gandalf.tasks.PegaClienteTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class MinhaContaFragment extends Fragment {

    private Cliente cliente;
    private Endereco endereco;

    private EditText campNome;
    private EditText campNascimento;
    private EditText campCPF;
    private EditText campCep;
    private EditText campEndereco;
    private EditText campNumero;
    private EditText campCidade;
    private EditText campLogradouro;
    private EditText campComplemento;
    private EditText campPais;
    private EditText campUF;
    private EditText campCelular;
    private EditText campResidencial;
    private EditText campComercial;
    private EditText campEmail;
    private EditText campSenha;


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
        new PegaClienteTask(this, "5").execute();

        Button btn = (Button) getActivity().findViewById(R.id.minha_conta_editar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                campNome = (EditText) getActivity().findViewById(R.id.minha_conta_nome);
                campNascimento = (EditText) getActivity().findViewById(R.id.minha_conta_nascimento);
                campCPF = (EditText) getActivity().findViewById(R.id.minha_conta_cpf);
                campCep = (EditText) getActivity().findViewById(R.id.minha_conta_cep);
                campEndereco = (EditText) getActivity().findViewById(R.id.minha_conta_endereco);
                campNumero = (EditText) getActivity().findViewById(R.id.minha_conta_numero);
                campCidade = (EditText) getActivity().findViewById(R.id.minha_conta_cidade);
                campLogradouro = (EditText) getActivity().findViewById(R.id.minha_conta_logradouro);
                campComplemento = (EditText) getActivity().findViewById(R.id.minha_conta_complemento);
                campPais = (EditText) getActivity().findViewById(R.id.minha_conta_pais);
                campUF = (EditText) getActivity().findViewById(R.id.minha_conta_uf);
                campCelular = (EditText) getActivity().findViewById(R.id.minha_conta_celular);
                campResidencial = (EditText) getActivity().findViewById(R.id.minha_conta_residencial);
                campComercial = (EditText) getActivity().findViewById(R.id.minha_conta_comercial);
                campEmail = (EditText) getActivity().findViewById(R.id.minha_conta_email);
                campSenha = (EditText) getActivity().findViewById(R.id.minha_conta_senha);

                Cliente cliente = new Cliente();
                Endereco endereco = new Endereco();

                cliente.setNomeCompletoCliente(campNome.getText().toString());
                cliente.setDtNascCliente(campNascimento.getText().toString());
                cliente.setCpfCliente(campCPF.getText().toString());
                endereco.setCEPEndereco(campCep.getText().toString());
                endereco.setNomeEndereco(campEndereco.getText().toString());
                endereco.setNumeroEndereco(campNumero.getText().toString());
                endereco.setCidadeEndereco(campCidade.getText().toString());
                endereco.setLogradouroEndereco(campLogradouro.getText().toString());
                endereco.setComplementoEndereco(campComplemento.getText().toString());
                endereco.setPaisEndereco(campPais.getText().toString());
                endereco.setUFEndereco(campUF.getText().toString());
                cliente.setCelularCliente(campCelular.getText().toString());
                cliente.setTelResidencialCliente(campResidencial.getText().toString());
                cliente.setTelComercialCliente(campComercial.getText().toString());
                cliente.setEmailCliente(campEmail.getText().toString());
                cliente.setSenhaCliente(campSenha.getText().toString());

            }
        });

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
