package br.com.fintech.dao;

import br.com.fintech.connection.FintechDB;
import br.com.fintech.entities.Banco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDAOImpl implements BancoDAO {

    private Connection connection;
    String sql;
    Statement statement = null;

    @Override
    public void insert(Banco banco) throws SQLException {
        sql = "INSERT INTO T_BANCO VALUES (?,?,?)";
        try {
            connection = FintechDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, banco.getId());
            preparedStatement.setInt(2, banco.getCdBanco());
            preparedStatement.setString(3, banco.getNomeBanco());
            preparedStatement.executeUpdate();

            System.out.println(("O Banco foi gravado!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao cadastrar Banco", e);
        } finally {
            connection.close();
        }

    }

    @Override
    public Banco update(int id, Banco banco) throws SQLException {
        sql = "UPDATE T_BANCO SET NM_BANCO = ? , CD_BANCO = ? WHERE ID_BANCO = ?";
        try {
            connection = FintechDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql
            );

            preparedStatement.setString(1, banco.getNomeBanco());
            preparedStatement.setInt(2, banco.getCdBanco());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

            System.out.println(("O Banco foi atualizado!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao editar banco", e);
        } finally {
            connection.close();
        }

        return banco;

    }

    @Override
    public void delete(int id) throws SQLException {
        sql = "DELETE T_BANCO WHERE CD_BANCO = ?";
        try {
            connection = FintechDB.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql
            );

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println(("O banco foi deletado!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao excluir banco", e);
        } finally {
            connection.close();
        }
    }

    @Override
    public List<Banco> getAll() throws SQLException {
        List <Banco> listbancos = new ArrayList<Banco>();
        sql = "SELECT * FROM T_BANCO";
        try {
            connection =  FintechDB.getInstance().getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Banco banco = new Banco();
                banco.setId(resultSet.getInt("id_banco"));
                banco.setCdBanco(resultSet.getInt("cd_banco"));
                banco.setNomeBanco(resultSet.getString("nm_banco"));
                listbancos.add(banco);
            }

            connection.commit();

        } catch (SQLException e) {
            throw new SQLException("Não foi possivel encontrar dados em Bancos", e);
        } finally {
            connection.close();
        }
        return listbancos;

    }
}
