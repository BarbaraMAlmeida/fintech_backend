package br.com.barbara.fintech.dao;

import br.com.barbara.fintech.connection.FintechDB;
import br.com.barbara.fintech.entities.Categoria;

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
                    "INSERT INTO T_GENERO VALUES (?,?)"
            );

            preparedStatement.setInt(1, categoria.getId());
            preparedStatement.setString(2, categoria.getNomeCategoria());
            preparedStatement.executeUpdate();

            System.out.println(("O produto foi gravado!!"));
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
