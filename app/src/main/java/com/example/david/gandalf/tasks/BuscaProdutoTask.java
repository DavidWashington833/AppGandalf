package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.david.gandalf.BuscaProdutoFragment;
import com.example.david.gandalf.QRCodeActivity;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.Arrays;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by Igor Ramos on 19/11/2017.
 */

public class BuscaProdutoTask extends AsyncTask<Void, Void, String> {

    private BuscaProdutoFragment context;

    public BuscaProdutoTask(BuscaProdutoFragment context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        EditText like = (EditText)context.getActivity().findViewById(R.id.txtBusca);
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/produto/like/lum");

        return resposta;
    }

    @Override
    protected void onPostExecute(final String resposta) {

        if (!resposta.equals("null")) {

            context.btnBusca.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.txtBusca.getText().toString();
                    Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
                    ProdutoAdapter adapter = new ProdutoAdapter(context.getContext(), Arrays.asList(produtos));
                    final ListView listView = (ListView) context.getActivity().findViewById(R.id.list_produto);

                    listView.setAdapter(adapter);
                }
            });


        }
    }

}
