package com.example.david.gandalf;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.david.gandalf.helpers.LoginHelper;
import com.example.david.gandalf.tasks.EnviaLoginTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private ImageView visualizar;
    private LoginHelper helper;
    private Button login;
    private Button criarConta;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        login = (Button) view.findViewById(R.id.login_logar);
        visualizar = (ImageView) view.findViewById(R.id.login_visualizar_senha);
        criarConta = (Button) view.findViewById(R.id.login_criar_conta);

        visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.alternaSenha();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EnviaLoginTask(LoginFragment.this).execute();
            }
        });

        criarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(LoginFragment.this, CadastroActivity.class);
                //startActivity(intent);
            }
        });

        return view;


    }

    public LoginHelper getHelper() {
        return helper;
    }

}
