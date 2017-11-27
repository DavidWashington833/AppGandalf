package com.storegandalf.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.storegandalf.david.gandalf.CheckoutPrincipalFragment;
import com.storegandalf.david.gandalf.R;
import com.storegandalf.david.gandalf.WebClient;
import com.storegandalf.david.gandalf.models.Endereco;

/**
 * Created by Igor Ramos on 26/11/2017.
 */

public class CheckoutTask extends AsyncTask<Void, Void, String> {
    private CheckoutPrincipalFragment context;
    private ProgressDialog dialog;

    public CheckoutTask(CheckoutPrincipalFragment context) {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Quase lá!", "Buscando seu endereço...", true, false);
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/endereco/cliente/43");
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();

        if (!resposta.equals("null")) {

            TextView campCep = (TextView) context.getActivity().findViewById(R.id.txtCEPCheckout);
            TextView campCidade = (TextView) context.getActivity().findViewById(R.id.txtCidadeCheckout);
            TextView campLogradouro = (TextView) context.getActivity().findViewById(R.id.txtRuaCheckout);

            Endereco[] enderecos = new Gson().fromJson(resposta, Endereco[].class);

            if (resposta.equals("[]")){
                campCep.setText("");
                campCidade.setText("");
                campLogradouro.setText("");
            } else {

                Endereco endereco = enderecos[0];

                campCep.setText(endereco.getCependereco());
                campCidade.setText(endereco.getCidadeEndereco());
                campLogradouro.setText(endereco.getLogradouroEndereco());
            }

        }
    }
}
