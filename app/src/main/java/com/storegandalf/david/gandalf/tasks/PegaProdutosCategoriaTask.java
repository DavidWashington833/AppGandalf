package com.storegandalf.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.storegandalf.david.gandalf.ProdutosCategoriaFragment;
import com.storegandalf.david.gandalf.R;
import com.storegandalf.david.gandalf.WebClient;
import com.storegandalf.david.gandalf.adapter.ProdutoAdapter;
import com.storegandalf.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by Gabriel_Montibeller on 18/11/2017.
 */


public class PegaProdutosCategoriaTask extends AsyncTask<Void, Void, String> {
    private ProdutosCategoriaFragment context;
    private ViewGroup container;
    private ProgressDialog dialog;
    private String id;

    public PegaProdutosCategoriaTask(ProdutosCategoriaFragment context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }

    public PegaProdutosCategoriaTask(ProdutosCategoriaFragment context, ViewGroup container, String id) {
        this.context = context;
        this.container = container;
        this.id = id;
    }
    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Abrindo o Baú", "Carregando Produtos...", true, false);
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/categoria/" + id);
        dialog.dismiss();

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {

        if (!resposta.equals("null")) {
            Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
            ProdutoAdapter adapter = new ProdutoAdapter(context.getContext(), Arrays.asList(produtos));
            final ListView listView = (ListView) context.getActivity().findViewById(R.id.list_produto_categoria);

            listView.setAdapter(adapter);

        }

    }

}