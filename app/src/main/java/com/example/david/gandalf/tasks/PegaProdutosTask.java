package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.gandalf.LoginActivity;
import com.example.david.gandalf.ProdutoFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Cliente;
import com.example.david.gandalf.models.Login;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

/**
 * Created by fernando.hyamamoto on 16/11/2017.
 */

public class PegaProdutosTask extends AsyncTask<Void, Void, String> {
    private ProdutoFragment context;
    private ProgressDialog dialog;

    public PegaProdutosTask(ProdutoFragment context) {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/2");
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
       //String feadback = "Não tem nem produto!";
        /*
        if (!resposta.equals("null")) {
           Produto produto = new Gson().fromJson(resposta, Produto.class);
            produto.getNomeProduto();
            context.nome = resposta;
            Toast.makeText(context, produto.toString(), Toast.LENGTH_LONG).show();
            //feadback = resposta;
        }*/

        if (!resposta.equals("null")) {
            Produto c = new Gson().fromJson(resposta, Produto.class);
            Toast t = Toast.makeText(context.getActivity(), c.getNomeProduto(), Toast.LENGTH_SHORT);
            t.show();

            TextView nomeP = (TextView) context.getActivity().findViewById(R.id.nomeProduto);
            TextView codP = (TextView) context.getActivity().findViewById(R.id.codigoProduto);
            TextView precoP = (TextView) context.getActivity().findViewById(R.id.precoProduto);


            nomeP.setText(c.getNomeProduto());
            codP.setText(c.getIdProduto());
            precoP.setText(c.getPrecProduto());




            }


    }
}
