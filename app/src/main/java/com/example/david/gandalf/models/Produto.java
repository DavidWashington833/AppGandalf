package com.example.david.gandalf.models;

import java.io.Serializable;

/**
 * Created by Igor Ramos on 15/11/2017.
 */

public class Produto implements Serializable {
    private int idProduto;
    private String nomeProduto;
    private String descProduto;
    private String precProduto;
    private String descontoPromocao;
    private int idCategoria;
    private String ativoProduto;
    private int idUsuario;
    private String qtdMinEstoque;
    private long imagem;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getAtivoProduto() {
        return ativoProduto;
    }

    public void setAtivoProduto(String ativoProduto) {
        this.ativoProduto = ativoProduto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getQtdMinEstoque() {
        return qtdMinEstoque;
    }

    public void setQtdMinEstoque(String qtdMinEstoque) {
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public long getImagem() {
        return imagem;
    }

    public void setImagem(long imagem) {
        this.imagem = imagem;
    }
}
