package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.ProdutoUnicoFragment;
import com.example.david.gandalf.MinhaContaFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

/**
 * Created by felipe.amiconi on 25/11/2017.
 */

public class PegaClienteTask extends AsyncTask<Void, Void, String> {
    private MinhaContaFragment context;
    private ProgressDialog dialog;
    private String id;

    public PegaClienteTask(MinhaContaFragment context) {
        this.context = context;
    }

    public PegaClienteTask(MinhaContaFragment context, String id) {
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
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/cliente/" + id);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();

        if (!resposta.equals("null")) {
            Cliente cliente = new Gson().fromJson(resposta, Cliente.class);

            EditText campNome = (EditText) context.getActivity().findViewById(R.id.minha_conta_nome);
            EditText campCPF = (EditText) context.getActivity().findViewById(R.id.minha_conta_cpf);
            EditText campNascimento = (EditText) context.getActivity().findViewById(R.id.minha_conta_nascimento);
            EditText campCelular = (EditText) context.getActivity().findViewById(R.id.minha_conta_celular);
            EditText campResidencial = (EditText) context.getActivity().findViewById(R.id.minha_conta_residencial);
            EditText campComercial = (EditText) context.getActivity().findViewById(R.id.minha_conta_comercial);
            EditText campEmail = (EditText) context.getActivity().findViewById(R.id.minha_conta_email);

            campNome.setText(cliente.getNomeCompletoCliente());
            campCPF.setText(cliente.getCpfCliente());
            campNascimento.setText(cliente.getDtNascCliente());
            campCelular.setText(cliente.getCelularCliente());
            campResidencial.setText(cliente.getTelResidencialCliente());
            campComercial.setText(cliente.getTelComercialCliente());
            campEmail.setText(cliente.getEmailCliente());

            new PegaEnderecoTask(context, id).execute();
        }
    }
}
