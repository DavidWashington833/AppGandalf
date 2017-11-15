package com.example.david.gandalf.models;

import java.io.Serializable;

/**
 * Created by Igor Ramos on 15/11/2017.
 */

public class Categoria implements Serializable {
    private int idCategoria;
    private String nomeCategoria;
    private String descCategoria;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }
}
