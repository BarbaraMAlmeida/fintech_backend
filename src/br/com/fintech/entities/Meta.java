package br.com.fintech.entities;


import java.io.Serializable;
import java.time.LocalDate;

public class Meta extends Moeda implements Serializable {
    private int id;
    private String nomeMeta;
    private LocalDate dtFimMeta;

    public Meta() {

    }

    public Meta(int id, String nomeMeta, LocalDate dtFimMeta) {
        this.id = id;
        this.nomeMeta = nomeMeta;
        this.dtFimMeta = dtFimMeta;
    }

    public Meta( int id, String nomeMeta, LocalDate dtFimMeta, Double valor) {
        super(valor);
        this.id = id;
        this.nomeMeta = nomeMeta;
        this.dtFimMeta = dtFimMeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public LocalDate getDtFimMeta() {
        return dtFimMeta;
    }

    public void setDtFimMeta(LocalDate dtFimMeta) {
        this.dtFimMeta = dtFimMeta;
    }

    public void cadastrar() {
        System.out.println("Meta " + this.nomeMeta + " cadastrada!");
    }

    public void editar(int id, Meta meta) {
        System.out.println("Meta atualizada");
    }

    public void excluir(int id) {
        System.out.println("Meta deletada");
    }

    public Meta listar() {
        this.cadastrar();
        return this;
    }

}
