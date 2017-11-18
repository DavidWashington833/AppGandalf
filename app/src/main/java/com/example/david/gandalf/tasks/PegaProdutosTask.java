package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.ProdutoFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
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
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/1");
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {

        if (!resposta.equals("null")) {
            Produto c = new Gson().fromJson(resposta, Produto.class);
//            Toast t = Toast.makeText(context.getActivity(), c.getNomeProduto(), Toast.LENGTH_SHORT);
//            t.show();

            TextView nomeP = (TextView) context.getActivity().findViewById(R.id.nomeProduto);
            TextView codP = (TextView) context.getActivity().findViewById(R.id.codigoProduto);
            TextView precoP = (TextView) context.getActivity().findViewById(R.id.precoProduto);
            TextView descP = (TextView) context.getActivity().findViewById(R.id.descProduto);

            ImageView imgP = (ImageView) context.getActivity().findViewById(R.id.imgProduto);


            nomeP.setText(c.getNomeProduto());
            codP.setText(c.getIdProduto());
            precoP.setText(c.getPrecProduto());
            descP.setText(c.getDescProduto());
            byte[] imageAsBytes = Base64.decode(c.getImagem().getBytes(), Base64.DEFAULT);

            imgP.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));


        }


    }
}