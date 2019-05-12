package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.gandalf.R;
import com.gandalf.activitys.LoginActivity;
import com.gandalf.WebClient;
import com.gandalf.models.Cliente;
import com.google.gson.Gson;

/**
 * Created by Silva on 04/11/2017.
 */

public class LoginTask extends AsyncTask<Void, Void, String> {
    private LoginActivity context;
    private ProgressDialog dialog;

    public LoginTask(LoginActivity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(
                context,
                context.getString(R.string.send_login_task_title),
                context.getString(R.string.send_login_task_message),
                true,
                true);
    }

    @Override
    protected String doInBackground(Void... params) {
        return new WebClient().get("/gandalf/rest/cliente/authentic/" + context.getLogin().getEmail() + "/" + context.getLogin().getSenha());
    }

    @Override
    protected void onPostExecute(String response) {
        dialog.dismiss();
        String feadback = context.getString(R.string.send_login_task_authentication);

        if (!response.equals("null")) {
            Cliente cliente = new Gson().fromJson(response, Cliente.class);
            context
                .getSharedPreferences("login", 0)
                .edit()
                .putInt("idCliente", cliente.getIdCliente())
                .commit();

            feadback = context.getString(R.string.send_login_task_welcome) + cliente.getNomeCompletoCliente();
            context.finish();
        }

        Toast.makeText(context, feadback, Toast.LENGTH_LONG).show();
    }
}
