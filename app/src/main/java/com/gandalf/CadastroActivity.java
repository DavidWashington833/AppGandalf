package com.gandalf;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gandalf.helpers.CadastroHelper;
import com.gandalf.models.Cliente;
import com.gandalf.models.Endereco;

public class CadastroActivity extends AppCompatActivity {

    private CadastroHelper helper;
    private Cliente cliente;
    private Endereco endereco;

    public CadastroActivity() {
        this.endereco = new Endereco();
        this.cliente = new Cliente();
        this.helper = new CadastroHelper(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        helper = new CadastroHelper(this);
        helper.chamaFragment(new CadastroPt1Fragment());
    }

    public CadastroHelper getHelper() {
        return helper;
    }

    public void setHelper(CadastroHelper helper) {
        this.helper = helper;
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
