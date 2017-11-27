package com.storegandalf.david.gandalf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.storegandalf.david.gandalf.helpers.CarrinhoSingletonHelper;

public class RecuperarSenhaActivity extends AppCompatActivity {

    Button btnRedefinirSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        btnRedefinirSenha = (Button) findViewById(R.id.btnRedefinirSenha);

        btnRedefinirSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Uma nova senha foi enviada para o seu e-mail! :)", Toast.LENGTH_SHORT).show();
                Intent newAct = new Intent(RecuperarSenhaActivity.this, MainActivity.class);
                startActivity(newAct);
            }
        });
    }
}
