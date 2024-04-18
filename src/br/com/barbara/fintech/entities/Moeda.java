package br.com.barbara.fintech.entities;

import java.io.Serializable;

public abstract class Moeda implements Serializable {

    private Double valor;

    public Moeda() {

    }
    public Moeda(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
