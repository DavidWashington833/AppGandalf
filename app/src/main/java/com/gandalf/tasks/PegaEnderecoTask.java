package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.EditText;

import com.gandalf.MinhaContaFragment;
import com.gandalf.R;
import com.gandalf.WebClient;
import com.gandalf.models.Endereco;
import com.google.gson.Gson;

/**
 * Created by Igor Ramos on 19/11/2017.
 */

public class PegaEnderecoTask extends AsyncTask<Void, Void, String> {
    private MinhaContaFragment context;
    private ProgressDialog dialog;
    private String id;

    public PegaEnderecoTask(MinhaContaFragment context) {
        this.context = context;
    }

    public PegaEnderecoTask(MinhaContaFragment context, String id) {
        this.context = context;
        this.id = id;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Aguarde", "Buscando dados...", true, false);
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://192.168.15.10:8084/Gandalf/rest/endereco/cliente/" + id);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();

        if (!resposta.equals("null")) {
            Endereco[] enderecos = new Gson().fromJson(resposta, Endereco[].class);
            Endereco endereco = enderecos[0];

            EditText campCep = (EditText) context.getActivity().findViewById(R.id.minha_conta_cep);
            EditText campEndereco = (EditText) context.getActivity().findViewById(R.id.minha_conta_endereco);
            EditText campNumero = (EditText) context.getActivity().findViewById(R.id.minha_conta_numero);
            EditText campCidade = (EditText) context.getActivity().findViewById(R.id.minha_conta_cidade);
            EditText campLogradouro = (EditText) context.getActivity().findViewById(R.id.minha_conta_logradouro);
            EditText campComplemento = (EditText) context.getActivity().findViewById(R.id.minha_conta_complemento);
            EditText campPais = (EditText) context.getActivity().findViewById(R.id.minha_conta_pais);
            EditText campUF = (EditText) context.getActivity().findViewById(R.id.minha_conta_uf);

            campCep.setText(endereco.getCEPEndereco());
            campEndereco.setText(endereco.getNomeEndereco());
            campNumero.setText(endereco.getNumeroEndereco());
            campCidade.setText(endereco.getCidadeEndereco());
            campLogradouro.setText(endereco.getLogradouroEndereco());
            campComplemento.setText(endereco.getComplementoEndereco());
            campPais.setText(endereco.getPaisEndereco());
            campUF.setText(endereco.getUFEndereco());
        }
    }
}
