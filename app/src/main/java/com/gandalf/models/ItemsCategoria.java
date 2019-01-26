package com.gandalf.models;

import java.io.Serializable;

/**
 * Created by Gabriel_Montibeller on 18/11/2017.
 */

public class ItemsCategoria implements Serializable {
    private String idProduto;
    private String nomeProduto;
    private String precProduto;
    private String descontoPromocao;
    private String qtdMinEstoque;
    private String imagem;
    private String descProduto;

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getPrecProduto() {
        return precProduto;
    }

    public void setPrecProduto(String precProduto) {
        this.precProduto = precProduto;
    }

    public String getDescontoPromocao() {
        return descontoPromocao;
    }

    public void setDescontoPromocao(String descontoPromocao) {
        this.descontoPromocao = descontoPromocao;
    }

    public String getQtdMinEstoque() {
        return qtdMinEstoque;
    }

    public void setQtdMinEstoque(String qtdMinEstoque) {
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }
}
