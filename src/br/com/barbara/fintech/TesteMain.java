package br.com.barbara.fintech;

import br.com.barbara.fintech.dao.CategoriaDAO;
import br.com.barbara.fintech.dao.CategoriaDAOImpl;
import br.com.barbara.fintech.entities.Categoria;

public class TesteMain {
    public static void main(String[] args) {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

            Categoria categoria = new Categoria();
            categoria.setId(82);
            categoria.setNomeCategoria("TESTE PELO JAVA 3");
            categoriaDAO.cadastrar(categoria);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
