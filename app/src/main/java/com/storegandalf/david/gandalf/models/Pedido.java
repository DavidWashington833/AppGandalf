package com.storegandalf.david.gandalf.models;

import java.io.Serializable;

/**
 * Created by Igor Ramos on 15/11/2017.
 */

public class Pedido implements Serializable {
    private String idPedido;
    private String idCliente;
    private String idStatus;
    private String dataPedido;
    private String idTipoPagto;
    private String idEndereco;
    private String idAplicacao;

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(String idStatus) {
        this.idStatus = idStatus;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getIdTipoPagto() {
        return idTipoPagto;
    }

    public void setIdTipoPagto(String idTipoPagto) {
        this.idTipoPagto = idTipoPagto;
    }

    public String getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(String idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getIdAplicacao() {
        return idAplicacao;
    }

    public void setIdAplicacao(String idAplicacao) {
        this.idAplicacao = idAplicacao;
    }
}
