package com.example.david.gandalf;


<<<<<<< HEAD
=======
import android.content.SharedPreferences;
>>>>>>> origin/branchIgorv3
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
=======
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.david.gandalf.helpers.CarrinhoSingletonHelper;
import com.example.david.gandalf.helpers.MinhaContaHelper;
import com.example.david.gandalf.tasks.PegaClienteTask;

import org.w3c.dom.Text;
>>>>>>> origin/branchIgorv3


/**
 * A simple {@link Fragment} subclass.
 */
public class MinhaContaFragment extends Fragment {

<<<<<<< HEAD

    public MinhaContaFragment() {
        // Required empty public constructor
=======
    private MinhaContaHelper helper;


    public MinhaContaFragment() {
        this.helper = new MinhaContaHelper(this);
>>>>>>> origin/branchIgorv3
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minha_conta, container, false);
    }

=======
        this.helper = new MinhaContaHelper(this);
        CarrinhoSingletonHelper carrinho = CarrinhoSingletonHelper.getInstance();
        SharedPreferences preferences = getContext().getApplicationContext().getSharedPreferences("login", 0);
        int id = preferences.getInt("idCliente", 0);
        View v  =  inflater.inflate(R.layout.fragment_minha_conta, container, false);
        new PegaClienteTask(this, id);
        return v;
    }

    public MinhaContaHelper getHelper() {
        return helper;
    }

    public void setHelper(MinhaContaHelper helper) {
        this.helper = helper;
    }
>>>>>>> origin/branchIgorv3
}
