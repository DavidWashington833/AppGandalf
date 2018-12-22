package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ListView;

import com.gandalf.BuscaProdutoFragment;
import com.gandalf.R;
import com.gandalf.WebClient;
import com.gandalf.adapter.ProdutoAdapter;
import com.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by Igor Ramos on 19/11/2017.
 */

public class BuscaProdutoTask extends AsyncTask<Void, Void, String> {

    private BuscaProdutoFragment context;
    private ProgressDialog dialog;

    public BuscaProdutoTask(BuscaProdutoFragment context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Aguarde", "Buscando Produto...", true, true);

    }

    @Override
    protected String doInBackground(Void... params) {
        String resposta;
        WebClient client = new WebClient();
        EditText editText = (EditText) context.getActivity().findViewById(R.id.txtBuscaProduto);
        resposta = client.get("http://192.168.15.17:8084/Gandalf/rest/produto/like/" + recebendoValor(editText));
        dialog.dismiss();
        return resposta;
    }

    @Override
    protected void onPostExecute(final String resposta) {

        if (!resposta.equals("null")) {
            Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
            ProdutoAdapter adapter = new ProdutoAdapter(context.getContext(), Arrays.asList(produtos));
            final ListView listView = (ListView) context.getActivity().findViewById(R.id.list_produto);
            listView.setAdapter(adapter);
        }
    }

    public String recebendoValor(EditText editText){

        String valor = editText.getText().toString();

        return valor;
    }

}
