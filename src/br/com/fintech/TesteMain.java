package br.com.fintech;

import br.com.fintech.dao.CategoriaDAO;
import br.com.fintech.dao.CategoriaDAOImpl;
import br.com.fintech.entities.Categoria;

public class TesteMain {
    public static void main(String[] args) {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

            Categoria categoria = new Categoria();
            categoria.setId(6);
            categoria.setNomeCategoria("Em grupo teste 02");
            categoria.setDescricao("Descrição");
            categoriaDAO.cadastrar(categoria);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
