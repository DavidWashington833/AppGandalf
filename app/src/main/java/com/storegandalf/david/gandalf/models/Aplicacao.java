package com.storegandalf.david.gandalf.models;

import java.io.Serializable;

/**
 * Created by Igor Ramos on 15/11/2017.
 */

public class Aplicacao implements Serializable {
    private int idAplicacao;
    private String DescAplicacao;
    private String TipoAplicacao;

    public int getIdAplicacao() {
        return idAplicacao;
    }

    public void setIdAplicacao(int idAplicacao) {
        this.idAplicacao = idAplicacao;
    }

    public String getDescAplicacao() {
        return DescAplicacao;
    }

    public void setDescAplicacao(String descAplicacao) {
        DescAplicacao = descAplicacao;
    }

    public String getTipoAplicacao() {
        return TipoAplicacao;
    }

    public void setTipoAplicacao(String tipoAplicacao) {
        TipoAplicacao = tipoAplicacao;
    }
}
