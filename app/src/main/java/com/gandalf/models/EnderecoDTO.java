package com.gandalf.models;

import java.io.Serializable;

/**
 * Created by Silva on 24/11/2017.
 */
public class EnderecoDTO implements Serializable {
    public String idCliente;
    public String nomeEndereco;
    public String logradouroEndereco;
    public String numeroEndereco;
    public String CEPEndereco;
    public String complementoEndereco;
    public String cidadeEndereco;
    public String paisEndereco;
    public String UFEndereco;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Endereco endereco) {
        this.idCliente = String.valueOf(endereco.getIdCliente());
        this.nomeEndereco = endereco.getNomeEndereco();
        this.logradouroEndereco = endereco.getLogradouroEndereco();
        this.numeroEndereco = endereco.getNumeroEndereco();
        this.CEPEndereco = endereco.getCEPEndereco();
        this.complementoEndereco = endereco.getComplementoEndereco();
        this.cidadeEndereco = endereco.getCidadeEndereco();
        this.paisEndereco = endereco.getPaisEndereco();
        this.UFEndereco = endereco.getUFEndereco();
    }

    public Endereco getEndereco() {
        Endereco endereco = new Endereco();
        endereco.setIdCliente(Integer.getInteger(idCliente));
        endereco.setNomeEndereco(nomeEndereco);
        endereco.setLogradouroEndereco(logradouroEndereco);
        endereco.setNumeroEndereco(numeroEndereco);
        endereco.setCEPEndereco(CEPEndereco);
        endereco.setComplementoEndereco(complementoEndereco);
        endereco.setCidadeEndereco(cidadeEndereco);
        endereco.setPaisEndereco(paisEndereco);
        endereco.setUFEndereco(UFEndereco);
        return endereco;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCEPEndereco() {
        return CEPEndereco;
    }

    public void setCEPEndereco(String CEPEndereco) {
        this.CEPEndereco = CEPEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getPaisEndereco() {
        return paisEndereco;
    }

    public void setPaisEndereco(String paisEndereco) {
        this.paisEndereco = paisEndereco;
    }

    public String getUFEndereco() {
        return UFEndereco;
    }

    public void setUFEndereco(String UFEndereco) {
        this.UFEndereco = UFEndereco;
    }
}