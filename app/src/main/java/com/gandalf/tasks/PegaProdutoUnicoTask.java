package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.gandalf.ProdutoUnicoFragment;
import com.gandalf.R;
import com.gandalf.WebClient;
import com.gandalf.models.Produto;
import com.google.gson.Gson;


public class PegaProdutoUnicoTask extends AsyncTask<Void, Void, String> {
    private ProdutoUnicoFragment context;
    private ProgressDialog dialog;
    private String id;

    public PegaProdutoUnicoTask(ProdutoUnicoFragment context) {
        this.context = context;
    }

    public PegaProdutoUnicoTask(ProdutoUnicoFragment context, String id) {
        this.context = context;
        this.id = id;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Aguarde", "Carregando Produto...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {

        WebClient client = new WebClient();
        String resposta = client.get("http://192.168.15.10:8084/Gandalf/rest/produto/" + id);
        dialog.dismiss();
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();
        System.out.println(resposta);

        if (!resposta.equals("null")) {
            Produto p = new Gson().fromJson(resposta, Produto.class);

            TextView nomeP = (TextView) context.getActivity().findViewById(R.id.nomeProduto);
            TextView codP = (TextView) context.getActivity().findViewById(R.id.codigoProduto);
            TextView precoP = (TextView) context.getActivity().findViewById(R.id.precoProduto);
            ImageView imgP = (ImageView) context.getActivity().findViewById(R.id.imgProduto);

            context.produtoP = p;
            TextView descP = (TextView) context.getActivity().findViewById(R.id.descProduto);

            context.produtoP = p;
            nomeP.setText(p.getNomeProduto());
            codP.setText(p.getIdProduto());
            precoP.setText(p.getPrecProduto());
            descP.setText(p.getDescProduto());
            byte[] imageAsBytes = Base64.decode(p.getImagem().getBytes(), Base64.DEFAULT);
            imgP.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
        }
    }
}