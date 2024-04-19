package br.com.fintech.dao;

import br.com.fintech.connection.FintechDB;
import br.com.fintech.entities.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {

    private Connection connection;
    PreparedStatement preparedStatement = null;

    @Override
    public void cadastrar(Categoria categoria) throws SQLException {
        try {
            connection = FintechDB.getConnectionDB();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO T_CATEGORIA VALUES (?,?,?)"
            );

            preparedStatement.setInt(1, categoria.getId());
            preparedStatement.setString(2, categoria.getNomeCategoria());
            preparedStatement.setString(3, categoria.getDescricao());
            preparedStatement.executeUpdate();

            System.out.println(("A categoria foi gravada!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Categoria editar(int id, Categoria categoria) {
        return null;
    }

    @Override
    public void excluir(int id) {

    }

    @Override
    public List<Categoria> listar() {
        return null;
    }
}
