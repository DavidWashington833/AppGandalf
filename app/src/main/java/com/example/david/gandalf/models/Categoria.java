package com.example.david.gandalf.models;

import java.io.Serializable;

/**
 * Created by Gabriel_Montibeller on 15/11/2017.
 */

public class Categoria implements Serializable {
    private String idCategoria;
    private String nomeCategoria;

    @Override
    public String toString() {
        return getNomeCategoria();
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
