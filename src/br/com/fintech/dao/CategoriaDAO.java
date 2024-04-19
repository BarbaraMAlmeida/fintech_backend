package br.com.fintech.dao;

import br.com.fintech.entities.Categoria;

import java.sql.SQLException;
import java.util.List;

public interface CategoriaDAO {

    void cadastrar(Categoria categoria) throws SQLException;

    Categoria editar(int id, Categoria categoria);

    void excluir(int id);

    List<Categoria> listar();
}
