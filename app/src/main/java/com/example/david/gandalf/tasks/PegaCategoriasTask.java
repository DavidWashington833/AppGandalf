package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.david.gandalf.CategoriaFragment;
import com.example.david.gandalf.MainActivity;
import com.example.david.gandalf.QRCodeActivity;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.models.Categoria;
import com.google.gson.Gson;

/**
 * Created by Gabriel_Montibeller on 15/11/2017.
 */

public class PegaCategoriasTask extends AsyncTask<Void, Void, String> {
    private CategoriaFragment context;
    private ViewGroup container;
    private ProgressDialog dialog;

    public PegaCategoriasTask(CategoriaFragment context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Tenha calma, cavaleiro...", "Carregando Categorias...", true, true);

    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://gandalf.azurewebsites.net/gandalf/rest/categoria/");
        dialog.dismiss();
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        Categoria[] categorias = new Gson().fromJson(resposta, Categoria[].class);

        final ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(context.getContext(), android.R.layout.simple_list_item_1, categorias);

        final ListView listView = (ListView) context.getActivity().findViewById(android.R.id.list);

        if (listView != null) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    EditText reclicado = (EditText) context.getActivity().findViewById(R.id.hiddenReclicado);
                    reclicado.setText("0");

                    Categoria c = adapter.getItem(i);

                    EditText id = (EditText) context.getActivity().findViewById(R.id.hiddenIdCat);
                    id.setText(c.getIdCategoria().toString());

                    new PegaProdutosCategoriaTask(context, container).execute();
                }
            });
        }

        context.setListAdapter(adapter);
    }
}