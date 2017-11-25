package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MinhaContaFragment extends Fragment {

<<<<<<< HEAD
    private MinhaContaHelper helper;
=======
>>>>>>> parent of fa0baef... Merge pull request #4 from DavidWashington833/branchIgorv3

    public MinhaContaFragment() {
        // Required empty public constructor
    }

    @Override
<<<<<<< HEAD
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.helper = new MinhaContaHelper(this);
        CarrinhoSingletonHelper carrinho = CarrinhoSingletonHelper.getInstance();
        SharedPreferences preferences = getContext().getApplicationContext().getSharedPreferences("login", 0);
        int id = preferences.getInt("idCliente", 0);
        View v  =  inflater.inflate(R.layout.fragment_minha_conta, container, false);
        new PegaClienteTask(this, id);
        return v;
=======
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minha_conta, container, false);
>>>>>>> parent of fa0baef... Merge pull request #4 from DavidWashington833/branchIgorv3
    }

}
