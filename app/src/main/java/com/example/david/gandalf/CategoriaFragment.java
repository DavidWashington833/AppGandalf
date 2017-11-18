package com.example.david.gandalf;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD:app/src/main/java/com/example/david/gandalf/FragmentCategoria.java
import android.widget.ArrayAdapter;

import com.example.david.gandalf.helpers.CategoriaHelper;
import com.example.david.gandalf.tasks.PegaCategoriasTask;

import org.json.JSONArray;
import org.json.JSONStringer;

=======
import com.example.david.gandalf.tasks.PegaProdutosCategoriaTask;
import com.example.david.gandalf.tasks.PegaCategoriasTask;
>>>>>>> 5eeebe02a62043925134d2e36b6f25a0a5612bcc:app/src/main/java/com/example/david/gandalf/CategoriaFragment.java

/**
 * Created by igorr on 18/10/2017.
 */



public class CategoriaFragment extends ListFragment {


    private CategoriaHelper helper;

    WebClient web = new WebClient();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_categoria, container, false);
<<<<<<< HEAD:app/src/main/java/com/example/david/gandalf/FragmentCategoria.java
        new PegaCategoriasTask(FragmentCategoria.this, container).execute();
=======
        new PegaProdutosCategoriaTask(CategoriaFragment.this, container).execute();
>>>>>>> 5eeebe02a62043925134d2e36b6f25a0a5612bcc:app/src/main/java/com/example/david/gandalf/CategoriaFragment.java
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
