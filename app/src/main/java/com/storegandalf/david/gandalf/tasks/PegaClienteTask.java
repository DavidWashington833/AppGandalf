package com.storegandalf.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.storegandalf.david.gandalf.MinhaContaFragment;
import com.storegandalf.david.gandalf.R;
import com.storegandalf.david.gandalf.WebClient;
import com.storegandalf.david.gandalf.models.Cliente;

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
        dialog = ProgressDialog.show(context.getContext(), "Quem é você?", "Buscando dados...", true, false);
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

            TextView campNome = (TextView) context.getActivity().findViewById(R.id.minha_conta_nome);
            TextView campCPF = (TextView) context.getActivity().findViewById(R.id.minha_conta_cpf);
            TextView campNascimento = (TextView) context.getActivity().findViewById(R.id.minha_conta_nascimento);
            TextView campCelular = (TextView) context.getActivity().findViewById(R.id.minha_conta_celular);
            TextView campResidencial = (TextView) context.getActivity().findViewById(R.id.minha_conta_residencial);
            TextView campComercial = (TextView) context.getActivity().findViewById(R.id.minha_conta_comercial);

            campNome.setText(cliente.getNomeCompletoCliente());
            campCPF.setText(cliente.getCpfcliente());
            campNascimento.setText(cliente.getDtNascCliente());
            campCelular.setText(cliente.getCelularCliente());
            campResidencial.setText(cliente.getTelResidencialCliente());
            campComercial.setText(cliente.getTelComercialCliente());

            new PegaEnderecoTask(context, id).execute();
        }
    }
}