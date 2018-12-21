package com.gandalf.models;

/**
 * Created by felipe.amiconi on 22/11/2017.
 */

public class ClienteDTO {
    public String nomeCompletoCliente;
    public String emailCliente;
    public String senhaCliente;
    public String cpfcliente;
    public String celularCliente;
    public String telComercialCliente;
    public String telResidencialCliente;
    public String dtNascCliente;
    public String recebeNewsLetter;

    public ClienteDTO() {}

    public ClienteDTO(Cliente cliente) {
        this.nomeCompletoCliente = cliente.getNomeCompletoCliente();
        this.emailCliente = cliente.getEmailCliente();
        this.senhaCliente = cliente.getSenhaCliente();
        this.cpfcliente = cliente.getCpfCliente();
        this.celularCliente = cliente.getCelularCliente();
        this.telComercialCliente = cliente.getTelComercialCliente();
        this.telResidencialCliente = cliente.getTelResidencialCliente();
        this.dtNascCliente = cliente.getDtNascCliente();
        this.recebeNewsLetter = cliente.getRecebeNewsLetter();
    }

    public Cliente getCliente() {
        Cliente cliente = new Cliente();
        cliente.setNomeCompletoCliente(this.nomeCompletoCliente);
        cliente.setEmailCliente(this.emailCliente);
        cliente.setSenhaCliente(this.senhaCliente);
        cliente.setCpfCliente(this.cpfcliente);
        cliente.setCelularCliente(this.celularCliente);
        cliente.setTelComercialCliente(this.telComercialCliente);
        cliente.setTelResidencialCliente(this.telResidencialCliente);
        cliente.setDtNascCliente(this.dtNascCliente);
        cliente.setRecebeNewsLetter(this.recebeNewsLetter);
        return cliente;
    }

    public String getNomeCompletoCliente() {
        return nomeCompletoCliente;
    }

    public void setNomeCompletoCliente(String nomeCompletoCliente) {
        this.nomeCompletoCliente = nomeCompletoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getTelComercialCliente() {
        return telComercialCliente;
    }

    public void setTelComercialCliente(String telComercialCliente) {
        this.telComercialCliente = telComercialCliente;
    }

    public String getTelResidencialCliente() {
        return telResidencialCliente;
    }

    public void setTelResidencialCliente(String telResidencialCliente) {
        this.telResidencialCliente = telResidencialCliente;
    }

    public String getDtNascCliente() {
        return dtNascCliente;
    }

    public void setDtNascCliente(String dtNascCliente) {
        this.dtNascCliente = dtNascCliente;
    }

    public String getRecebeNewsLetter() {
        return recebeNewsLetter;
    }

    public void setRecebeNewsLetter(String recebeNewsLetter) {
        this.recebeNewsLetter = recebeNewsLetter;
    }
}
