package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;

import com.gandalf.Fragments.ProductsFragment;
import com.gandalf.R;
import com.gandalf.WebClient;

import com.gandalf.adapter.ProdutoAdapter;
import com.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by fernando.hyamamoto on 16/11/2017.
 */

public class PegaProdutosTask extends AsyncTask<Void, Void, String> {
    private String id;
    private ProductsFragment context;

    private ProgressDialog dialog;

    public PegaProdutosTask(ProductsFragment context) {
        this.context = context;
    }

    public PegaProdutosTask(ProductsFragment context, String id) {
        this.context = context;
        this.id = id;
    }


    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Aguarde", "Carregando Produtos...", true, true);

    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://192.168.15.12:8084/Gandalf/rest/produto/");
        dialog.dismiss();
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        if (!resposta.equals("null")) {
            Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
            final ProdutoAdapter adapter = new ProdutoAdapter(context.getContext(), Arrays.asList(produtos));
            final ListView listView = (ListView) context.getActivity().findViewById(R.id.list_produto);

            listView.setAdapter(adapter);
        }
    }
}