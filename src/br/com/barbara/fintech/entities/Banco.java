package br.com.barbara.fintech.entities;

import java.io.Serializable;

public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int cdBanco;
    private String nomeBanco;

    public Banco() {

    }

    public Banco(int id, int cdBanco, String nomeBanco) {
        this.id = id;
        this.cdBanco = cdBanco;
        this.nomeBanco = nomeBanco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCdBanco() {
        return cdBanco;
    }

    public void setCdBanco(int cdBanco) {
        this.cdBanco = cdBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public Banco listar() {
        Banco banco = new Banco(4,001, "Banco do Brasil");
        return banco;
    }
}
