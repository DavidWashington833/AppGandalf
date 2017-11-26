package com.storegandalf.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.storegandalf.david.gandalf.MinhaContaFragment;
import com.storegandalf.david.gandalf.R;
import com.storegandalf.david.gandalf.WebClient;
import com.storegandalf.david.gandalf.models.Endereco;


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
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/endereco/cliente/" + id);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();

        if (!resposta.equals("null")) {

            TextView campCep = (TextView) context.getActivity().findViewById(R.id.minha_conta_cep);
            TextView campEndereco = (TextView) context.getActivity().findViewById(R.id.minha_conta_endereco);
            TextView campNumero = (TextView) context.getActivity().findViewById(R.id.minha_conta_numero);
            TextView campCidade = (TextView) context.getActivity().findViewById(R.id.minha_conta_cidade);
            TextView campLogradouro = (TextView) context.getActivity().findViewById(R.id.minha_conta_logradouro);
            TextView campComplemento = (TextView) context.getActivity().findViewById(R.id.minha_conta_complemento);
            TextView campPais = (TextView) context.getActivity().findViewById(R.id.minha_conta_pais);
            TextView campUF = (TextView) context.getActivity().findViewById(R.id.minha_conta_uf);

            Endereco[] enderecos = new Gson().fromJson(resposta, Endereco[].class);

            if (resposta.equals("[]")){
                campCep.setText("");
                campEndereco.setText("");
                campNumero.setText("");
                campCidade.setText("");
                campLogradouro.setText("");
                campComplemento.setText("");
                campPais.setText("");
                campUF.setText("");
            } else {

                Endereco endereco = enderecos[0];

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
}
