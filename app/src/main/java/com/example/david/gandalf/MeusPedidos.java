package com.example.david.gandalf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MeusPedidos extends AppCompatActivity {
    private ViewGroup mensagens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_pedidos);

        mensagens = (ViewGroup) findViewById(R.id.container);
        addItem("Título 1", "Exemplo de mensagem.");
    }
    private void addItem(String textoDoTitulo, String textoDaMensagem) {
        CardView cardView = (CardView) LayoutInflater.from(this)
                .inflate(R.layout.activity_meus_pedidos, mensagens, false);
        ImageView imagem1 = (ImageView) cardView.findViewById(R.id.image1);
        TextView titulo = (TextView) cardView.findViewById(R.id.titulo);
        TextView mensagem = (TextView) cardView.findViewById(R.id.mensagem);
        titulo.setText(textoDoTitulo);
        mensagem.setText(textoDaMensagem);
        mensagens.addView(cardView);
    }
}
