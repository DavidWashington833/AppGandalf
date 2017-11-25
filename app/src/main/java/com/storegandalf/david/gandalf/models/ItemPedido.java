package com.storegandalf.david.gandalf.models;

import java.io.Serializable;

/**
 * Created by Igor Ramos on 15/11/2017.
 */

public class ItemPedido implements Serializable {
    private int idProduto;
    private int idPedido;
    private String qtdProduto;
    private String precoVendaItem;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(String qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getPrecoVendaItem() {
        return precoVendaItem;
    }

    public void setPrecoVendaItem(String precoVendaItem) {
        this.precoVendaItem = precoVendaItem;
    }
}
