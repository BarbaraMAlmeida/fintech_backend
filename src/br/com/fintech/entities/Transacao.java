package br.com.fintech.entities;


import br.com.fintech.enums.TipoTransacao;

import java.io.Serializable;
import java.time.LocalDate;

public class Transacao extends Moeda implements Serializable {
    private int id;
    private String descricao;
    private LocalDate dtLancamento;
    private TipoTransacao tipoTransacao;
    private Categoria categoria;

    public Transacao() {

    }

    public Transacao(int id, String descricao, LocalDate dtLancamento, TipoTransacao tipoTransacao, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.dtLancamento = dtLancamento;
        this.tipoTransacao = tipoTransacao;
        this.categoria = categoria;
    }

    public Transacao(int id, Double valor, String descricao, LocalDate dtLancamento, TipoTransacao tipoTransacao, Categoria categoria) {
        super(valor);
        this.id = id;
        this.descricao = descricao;
        this.dtLancamento = dtLancamento;
        this.tipoTransacao = tipoTransacao;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(LocalDate dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void cadastrar() {
        System.out.println("Transação de " + this.getValor() + " criada.");
    }

    public void editar(int id, Transacao transacao) {
        System.out.println("Transacao atualizada");
    }

    public void excluir(int id) {
        System.out.println("Transacao deletada");
    }

    public Transacao listar() {
        Categoria categoria = new Categoria(54,"Roupas mensais", "Roupas novas do mês");
        Transacao transacao =  new Transacao(80, 150.00,
                "Roupas novas", LocalDate.now(), TipoTransacao.DESPESA,
                categoria);
        cadastrar();
        return transacao;
    }
}
