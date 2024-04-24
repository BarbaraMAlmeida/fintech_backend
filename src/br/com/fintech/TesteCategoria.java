package br.com.fintech;

import br.com.fintech.dao.CategoriaDAO;
import br.com.fintech.dao.CategoriaDAOImpl;
import br.com.fintech.entities.Categoria;

import java.util.List;

public class TesteCategoria {
    public static void main(String[] args) {
        cadastrarCategoria();
        editarCategoria();
        deletarCategoria();
        getAllCategorias();
    }

    public static void cadastrarCategoria() {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

            Categoria categoria = new Categoria();
            categoria.setNomeCategoria("bbbfffnn");
            categoria.setDescricao("Salário Empresa X mensal");
            categoriaDAO.insert(categoria);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarCategoria() {
        try {
            int idEdit = 26;
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
            Categoria categoria = new Categoria();

            categoria.setNomeCategoria("Teste atualizaçãoasdsasad de categoriass");
            categoria.setDescricao("Teste atualização");
            categoriaDAO.update(idEdit, categoria);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletarCategoria() {
        try {
            int idEdit = 44;
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

            categoriaDAO.delete(idEdit);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllCategorias() {
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAOImpl();

            List<Categoria>  listCategoria = categoriaDAO.getAll();

            for (Categoria cat : listCategoria) {
                System.out.println(cat.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
