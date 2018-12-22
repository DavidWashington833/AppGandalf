package com.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.gandalf.CategoriaFragment;
import com.gandalf.R;
import com.gandalf.WebClient;
import com.gandalf.models.Categoria;
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
        dialog = ProgressDialog.show(context.getContext(), "Tenha calma, cavaleiro...", "Carregando Categorias...", true, false);
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        String resposta = client.get("http://192.168.15.17:8084/Gandalf/rest/categoria/");
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

                    //Toast t = Toast.makeText(context.getActivity(), id.toString() , Toast.LENGTH_LONG);
                   // t.show();

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