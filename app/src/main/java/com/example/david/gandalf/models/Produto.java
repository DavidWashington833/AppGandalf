package com.example.david.gandalf.models;

/**
 * Created by fernando.hyamamoto on 16/11/2017.
 */

public class Produto {
    private String idProduto;
    private String nomeProduto;
    private String precProduto;
    private String descontoPromocao;
    private String qtdMinEstoque;
    private String imagem;
    private String descProduto;

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

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
}