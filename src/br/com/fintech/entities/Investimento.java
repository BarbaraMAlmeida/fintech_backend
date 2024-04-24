package br.com.fintech.entities;

import java.io.Serializable;
import java.time.LocalDate;


public abstract class Investimento extends Moeda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
    private double valorRetirado;
    private LocalDate dtInvestimento;
    private Banco banco;

    public Investimento() {

    }

    public Investimento(int id, double valorRetirado, LocalDate dtInvestimento, Banco banco) {
        this.id = id;
        this.valorRetirado = valorRetirado;
        this.dtInvestimento = dtInvestimento;
        this.banco = banco;
    }

    public Investimento(Double valor, int id, double valorRetirado, LocalDate dtInvestimento, Banco banco) {
        super(valor);
        this.id = id;
        this.valorRetirado = valorRetirado;
        this.dtInvestimento = dtInvestimento;
        this.banco = banco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorRetirado() {
        return valorRetirado;
    }

    public void setValorRetirado(double valorRetirado) {
        this.valorRetirado = valorRetirado;
    }

    public LocalDate getDtInvestimento() {
        return dtInvestimento;
    }

    public void setDtInvestimento(LocalDate dtInvestimento) {
        this.dtInvestimento = dtInvestimento;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    @Override
    public String toString() {
        return "Investimento [codigo = " + id
                + ", banco = " + banco.getId()
                + ", valor = " + getValor()
                + ", data do investimento = " + dtInvestimento
                + "]";
    }


}
