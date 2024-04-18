package br.com.barbara.fintech.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class InvestimentoCDBS extends Investimento implements Serializable {
    private double taxaCdi;
    private double percentualCdi;
    private LocalDate dtVencimento;

    public InvestimentoCDBS() {

    }

    public InvestimentoCDBS(double taxaCdi, double percentualCdi, LocalDate dtVencimento) {
        this.taxaCdi = taxaCdi;
        this.percentualCdi = percentualCdi;
        this.dtVencimento = dtVencimento;
    }

    public InvestimentoCDBS(int id, double valorRetirado, LocalDate dtInvestimento, Banco banco, double taxaCdi, double percentualCdi, LocalDate dtVencimento) {
        super(id, valorRetirado, dtInvestimento, banco);
        this.taxaCdi = taxaCdi;
        this.percentualCdi = percentualCdi;
        this.dtVencimento = dtVencimento;
    }

    public InvestimentoCDBS(int id, Double valor, double valorRetirado, LocalDate dtInvestimento, Banco banco, double taxaCdi, double percentualCdi, LocalDate dtVencimento) {
        super(valor, id, valorRetirado, dtInvestimento, banco);
        this.taxaCdi = taxaCdi;
        this.percentualCdi = percentualCdi;
        this.dtVencimento = dtVencimento;
    }

    public double getTaxaCdi() {
        return taxaCdi;
    }

    public void setTaxaCdi(double taxaCdi) {
        this.taxaCdi = taxaCdi;
    }

    public double getPercentualCdi() {
        return percentualCdi;
    }

    public void setPercentualCdi(double percentualCdi) {
        this.percentualCdi = percentualCdi;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Integer calcularDiasInvestimento() {
        Integer dias =  getDtVencimento().getDayOfMonth() - getDtInvestimento().getDayOfMonth();
        return dias;
    }

    @Override
    public void calcularInvestimento(double valorInvestido) {
        Double total = getValor() * (getTaxaCdi() * getPercentualCdi());

        this.setValorRetirado(total);
    }

    public void cadastrar() {
        System.out.println("Investimento CDBS que possui vencimento em " + this.dtVencimento
                + "foi criado." );
    }

    @Override
    public void editar(int id, Investimento meta) {
        System.out.println("Investimento atualizado");
    }

    @Override
    public void excluir(int id) {
        System.out.println("Investimento deletado");
    }



}
