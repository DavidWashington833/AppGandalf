package com.example.david.gandalf.models;

import java.io.Serializable;

/**
 * Created by Igor Ramos on 15/11/2017.
 */

public class Estoque implements Serializable {
    private int idProduto;
    private String qtdProdutoDisponivel;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getQtdProdutoDisponivel() {
        return qtdProdutoDisponivel;
    }

    public void setQtdProdutoDisponivel(String qtdProdutoDisponivel) {
        this.qtdProdutoDisponivel = qtdProdutoDisponivel;
    }
}
