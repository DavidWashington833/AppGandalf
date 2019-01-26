package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.ViewGroup;

import com.gandalf.Fragments.CategoriesFragment;
import com.gandalf.WebClient;

/**
 * Created by Gabriel_Montibeller on 18/11/2017.
 */


public class PegaProdutosCategoriaTask extends AsyncTask<Void, Void, String> {
    private CategoriesFragment context;
    private ViewGroup container;
    private ProgressDialog dialog;

    public PegaProdutosCategoriaTask(CategoriesFragment context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }
    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Aguarde", "Carregando Produtos...", true, false);
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
//        TODO: Refactoring
//        EditText id = (EditText) context.getActivity().findViewById(R.id.hiddenIdCat);
//        String resposta = client.get("/gandalf/rest/produto/categoria/" + id.getText().toString());
//        dialog.dismiss();

//        return resposta;
        return "";
    }

    @Override
    protected void onPostExecute(String resposta) {

//        TODO: Refactoring
//        if (!resposta.equals("null")) {
//            Product[] produtos = new Gson().fromJson(resposta, Product[].class);
//            ProductAdapter adapter = new ProductAdapter(context.getContext(), Arrays.asList(produtos));
//            final ListView listView = (ListView) context.getActivity().findViewById(android.R.id.list);
//
//            listView.setAdapter(adapter);
//        }

    }

}