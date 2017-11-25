package com.storegandalf.david.gandalf;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import com.storegandalf.david.gandalf.helpers.LoginHelper;
import com.storegandalf.david.gandalf.tasks.EnviaLoginTask;

public class LoginActivity extends AppCompatActivity {
    private ImageView visualizar;
    private LoginHelper helper;
    private Button login;
    private Button criarConta;
    private Button recuperarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login_logar);
        visualizar = (ImageView) findViewById(R.id.login_visualizar_senha);
        criarConta = (Button) findViewById(R.id.login_criar_conta);
        recuperarSenha = (Button) findViewById(R.id.login_recuperar_senha);

        helper = new LoginHelper(this);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.alternaSenha();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EnviaLoginTask(LoginActivity.this).execute();
            }
        });

        criarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        recuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
                startActivity(intent);
            }
        });
    }

    public LoginHelper getHelper() {
        return helper;
    }
}


