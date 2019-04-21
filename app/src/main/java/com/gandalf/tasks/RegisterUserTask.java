package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.gandalf.activitys.RegisterActivity;
import com.gandalf.WebClient;
import com.gandalf.models.Cliente;
import com.gandalf.models.ClienteDTO;
import com.google.gson.Gson;

/**
 * Created by felipe.amiconi on 22/11/2017.
 */

public class RegisterUserTask extends AsyncTask<Void, Void, String> {
    private RegisterActivity context;
    private ProgressDialog dialog;

    public RegisterUserTask(RegisterActivity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Cadastrando cliente...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {
        ClienteDTO clienteDTO = new ClienteDTO(context.getCliente());
        Gson gson = new Gson();
        String jsonInString = gson.toJson(clienteDTO);
        return new WebClient().post("/gandalf/rest/cliente/", jsonInString);
    }

    @Override
    protected void onPostExecute(String reponse) {
        dialog.dismiss();

        if (!reponse.equals("null")) {
            Cliente cliente = new Gson().fromJson(reponse, Cliente.class);

            context
                .getSharedPreferences("login", 0)
                .edit()
                .putInt("idCliente", cliente.getIdCliente())
                .commit();
        }
    }
}
