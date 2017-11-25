package com.storegandalf.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.storegandalf.david.gandalf.ProdutoUnicoFragment;
import com.storegandalf.david.gandalf.R;
import com.storegandalf.david.gandalf.WebClient;
import com.storegandalf.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.text.DecimalFormat;


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
        dialog = ProgressDialog.show(context.getContext(), "My Precious! *-*", "Carregando Produto...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {

        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/" + id);
        dialog.dismiss();
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        System.out.println(resposta);
        if (!resposta.equals("null")) {
            Produto p = new Gson().fromJson(resposta, Produto.class);

            DecimalFormat format = new DecimalFormat("###,###,###,###,##0.00");

            TextView nomeP = (TextView) context.getActivity().findViewById(R.id.nomeProduto);
            TextView codP = (TextView) context.getActivity().findViewById(R.id.codigoProduto);
            TextView precoP = (TextView) context.getActivity().findViewById(R.id.precoProduto);
            ImageView imgP = (ImageView) context.getActivity().findViewById(R.id.imgProduto);
            TextView descP = (TextView) context.getActivity().findViewById(R.id.descProduto);

            context.produtoP = p;
            nomeP.setText(p.getNomeProduto());
            codP.setText(p.getIdProduto());

            String preco = p.getPrecProduto();
            Double preco2 = Double.parseDouble(preco);
            format.format(preco2);
            precoP.setText(preco2.toString() + "0");
            descP.setText(p.getDescProduto());
            byte[] imageAsBytes = Base64.decode(p.getImagem().getBytes(), Base64.DEFAULT);
            imgP.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
        }
    }
}