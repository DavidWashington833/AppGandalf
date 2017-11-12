package com.example.david.gandalf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.david.gandalf.helpers.LoginHelper;
import com.example.david.gandalf.tasks.EnviaLoginTask;

public class LoginActivity extends AppCompatActivity {
    private ImageView visualizar;
    private LoginHelper helper;
    private Button login;
    private Button criarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login_logar);
        visualizar = (ImageView) findViewById(R.id.login_visualizar_senha);
        criarConta = (Button) findViewById(R.id.login_criar_conta);

        helper = new LoginHelper(this);

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
    }

    public LoginHelper getHelper() {
        return helper;
    }
}

