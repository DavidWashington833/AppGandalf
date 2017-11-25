package com.example.david.gandalf.helpers;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.david.gandalf.MinhaContaFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.models.Cliente;

/**
 * Created by igorr on 23/11/2017.
 */

public class MinhaContaHelper {

    private TextView nomeCompleto;
    private TextView emailCliente;
    private TextView cpfcliente;
    private TextView celularCliente;
    private TextView telComercialCliente;
    private TextView telResidencialCliente;
    private TextView dtNascCliente;
    private CheckBox recebeNewsLetter;
    private MinhaContaFragment context;


    public MinhaContaHelper(MinhaContaFragment context) {
        this.context = context;
        Activity v = context.getActivity();
        nomeCompleto = (TextView) v.findViewById(R.id.minha_conta_nome);
        cpfcliente = (TextView) v.findViewById(R.id.minha_conta_cpf);
        telComercialCliente = (TextView) v.findViewById(R.id.minha_conta_comercial);
        telResidencialCliente = (TextView) v.findViewById(R.id.minha_conta_residencial);
        dtNascCliente = (TextView) v.findViewById(R.id.minha_conta_nascimento);
    }

    public void inputText(Cliente cliente, MinhaContaFragment context) {
        this.context = context;
        Activity v = this.context.getActivity();
//        nomeCompleto = (TextView) v.findViewById(R.id.txtNomeCompleto);
//        cpfcliente = (TextView) v.findViewById(R.id.txtCPF);
//        celularCliente = (TextView) v.findViewById(R.id.txtTelefoneCelular);
//        telComercialCliente = (TextView) v.findViewById(R.id.txtTelefoneComercial);
//        telResidencialCliente = (TextView) v.findViewById(R.id.txtTelefoneResidencial);
//        dtNascCliente = (TextView) v.findViewById(R.id.txtDataNascimento);
//
//        nomeCompleto.setText(cliente.getNomeCompletoCliente());
//        cpfcliente.setText(cliente.getNomeCompletoCliente());
//        celularCliente.setText(cliente.getNomeCompletoCliente());
//        telComercialCliente.setText(cliente.getNomeCompletoCliente());
//        telResidencialCliente.setText(cliente.getNomeCompletoCliente());
//        dtNascCliente.setText(cliente.getNomeCompletoCliente());
    }

    public TextView getNomeCompleto() {
        return nomeCompleto;
    }

    public TextView getEmailCliente() {
        return emailCliente;
    }

    public TextView getCpfcliente() {
        return cpfcliente;
    }

    public TextView getCelularCliente() {
        return celularCliente;
    }

    public TextView getTelComercialCliente() {
        return telComercialCliente;
    }

    public TextView getTelResidencialCliente() {
        return telResidencialCliente;
    }

    public TextView getDtNascCliente() {
        return dtNascCliente;
    }

    public CheckBox getRecebeNewsLetter() {
        return recebeNewsLetter;
    }
}
