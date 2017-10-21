package com.example.david.gandalf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText et_email;
    private EditText et_senha;
    private Button bt_rsenha;
    private Button bt_login;
    private Button bt_cc;
    private Button bt_vsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = (EditText) findViewById(R.id.et_email);
        et_senha = (EditText) findViewById(R.id.et_senha);
        bt_rsenha = (Button) findViewById(R.id.bt_rsenha);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_cc = (Button) findViewById(R.id.bt_cc);
        bt_vsenha = (Button) findViewById(R.id.bt_vsenha);

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                //Ação aqui!
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        };
        bt_cc.setOnClickListener(listener);

    }
}

