package com.gandalf.models;

import java.io.Serializable;

/**
 * Created by Igor Ramos on 15/11/2017.
 */

public class StatusPedido implements Serializable {
    private int idStatus;
    private String descStatus;

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescStatus() {
        return descStatus;
    }

    public void setDescStatus(String descStatus) {
        this.descStatus = descStatus;
    }
}
