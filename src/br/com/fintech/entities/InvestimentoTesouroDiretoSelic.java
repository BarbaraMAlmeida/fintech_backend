package br.com.fintech.entities;

import java.io.Serializable;
import java.time.LocalDate;
public class InvestimentoTesouroDiretoSelic extends Investimento implements Serializable {
    private double taxaSelicAnual;

    private LocalDate dtVencimento;

    public InvestimentoTesouroDiretoSelic() {}

    public InvestimentoTesouroDiretoSelic(double taxaSelicAnual, LocalDate dtVencimento) {
        this.taxaSelicAnual = taxaSelicAnual;
        this.dtVencimento = dtVencimento;
    }

    public InvestimentoTesouroDiretoSelic(int id, double valorRetirado, LocalDate dtInvestimento, Banco banco, double taxaSelicAnual, LocalDate dtVencimento) {
        super(id, valorRetirado, dtInvestimento, banco);
        this.taxaSelicAnual = taxaSelicAnual;
        this.dtVencimento = dtVencimento;
    }

    public double getTaxaSelicAnual() {
        return taxaSelicAnual;
    }

    public void setTaxaSelicAnual(double taxaSelicAnual) {
        this.taxaSelicAnual = taxaSelicAnual;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Double calcularRendimentoDiario() {
       return getValor() * (this.taxaSelicAnual / 100) / 252;
    }

    public Double calcularRendimentoAnual() {
        Double total = calcularRendimentoDiario() * 252;

        return total;
    }

    public void cadastrar() {
        System.out.println("Investimento Tesouro Direto Selic que possui vencimento em " + this.dtVencimento
                + "foi criado." );
    }

}
