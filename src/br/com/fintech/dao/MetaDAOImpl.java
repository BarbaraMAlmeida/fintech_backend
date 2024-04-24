package br.com.fintech.dao;
import br.com.fintech.connection.FintechDB;
import br.com.fintech.entities.Meta;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MetaDAOImpl implements MetaDAO {

    
    @Override
    public void insert(Meta meta) throws SQLException {
        String sql = "INSERT INTO T_META (id, nomeMeta, dtFimMeta) VALUES (?, ?, ?)";
        try (Connection connection = FintechDB.getConnectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, meta.getId());
            preparedStatement.setString(2, meta.getNomeMeta());
            preparedStatement.setObject(3, meta.getDtFimMeta());
            preparedStatement.executeUpdate();

            System.out.println("A meta foi gravada!!");
            connection.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar meta: " + e.getMessage());
            throw new SQLException("Erro ao cadastrar meta", e);
        }
    }

    @Override
    public Meta update(int id, Meta meta) throws SQLException {
        String sql = "UPDATE T_META SET nomeMeta = ?, dtFimMeta = ? WHERE CD_META = ?";
        try (Connection connection = FintechDB.getConnectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, meta.getNomeMeta());
            preparedStatement.setObject(2, meta.getDtFimMeta());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

            System.out.println("A meta foi atualizada!!");
            connection.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao editar meta: " + e.getMessage());
            throw new SQLException("Erro ao editar meta", e);
        }
        return meta;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM T_META WHERE CD_META = ?";
        try (Connection connection = FintechDB.getConnectionDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("A meta foi deletada!!");
            connection.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir meta: " + e.getMessage());
            throw new SQLException("Erro ao excluir meta", e);
        }
    }

   @Override
    public List<Meta> getAll() throws SQLException {
        List<Meta> listMetas = new ArrayList<>();
        String sql = "SELECT * FROM T_META";
        try (Connection connection = FintechDB.getConnectionDB();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                Meta meta = new Meta(result.getInt("id"),
                        result.getString("nomeMeta"), result.getDate("dtFimMeta"));
                listMetas.add(meta);
            }
            connection.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao buscar metas: " + e.getMessage());
            throw new SQLException("Erro ao buscar metas", e);
        }
        return listMetas;
    }
}
