package br.com.fintech.dao;
import br.com.fintech.connection.FintechDB;
import br.com.fintech.entities.Categoria;
import br.com.fintech.entities.Genero;
import br.com.fintech.entities.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private static final Usuario Usuario = null;
	private Connection connection;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    String sql;
    
    
    @Override
    public void insert(Usuario Usuario) throws SQLException {
        sql = "INSERT INTO T_USUARIO VALUES (?,?,?)";
        try {
            connection = FintechDB.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Usuario.getId());
            preparedStatement.setString(2, Usuario.getNomeUsuario());
            Date date = Date.valueOf(Usuario.getDtNascimento());
            preparedStatement.setDate(3, date);
            preparedStatement.setInt(4, Usuario.getGenero().getId());
            preparedStatement.setString(5, Usuario.getEmail());
            preparedStatement.setString(6, Usuario.getSenha());
            preparedStatement.executeUpdate();

            System.out.println(("O usuário foi gravado!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
           throw new SQLException("Erro ao cadastrar usuário", e);
        } finally {
            connection.close();
        }

    }
    
    @Override
    public Usuario update(int id, Usuario Usuario) throws SQLException {
        sql = "UPDATE T_USUARIO SET CD_USUARIO = ? , NM_USUARIO = ?, CD_GENERO = ?, DT_NASCIMENTO = ?, EMAIL = ?, SENHA = ? WHERE CD_USUARIO = ?";
        try {
            connection = FintechDB.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    sql
            );

            preparedStatement.setInt(1, Usuario.getId());
            preparedStatement.setString(2, Usuario.getNomeUsuario());
            Date date = Date.valueOf(Usuario.getDtNascimento());
            preparedStatement.setDate(3, date);
            preparedStatement.setInt(4, Usuario.getGenero().getId());
            preparedStatement.setString(5, Usuario.getEmail());
            preparedStatement.setString(6, Usuario.getSenha());
            preparedStatement.executeUpdate();

            System.out.println(("O usuário foi atualizada!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao editar usuário", e);
        } finally {
            connection.close();
        }

        return Usuario;

    }
    
    @Override
    public void delete(int id) throws SQLException {
        sql = "DELETE T_USUARIO WHERE CD_USUARIO = ?";
        try {
            connection = FintechDB.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(
                    sql
            );

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println(("O usuário foi deletado!!"));
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao excluir usuário", e);
        } finally {
            connection.close();
        }
    }
    
    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        sql = "SELECT * FROM T_USUARIO";
        try {
            connection = FintechDB.getInstance().getConnection();
            statement  = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
            	Genero genero = new Genero();
            	genero.setId(result.getInt("cd_genero"));
                Usuario usuario = new Usuario(result.getInt("cd_usuario"), result.getString("nm_usuario"),
                		result.getDate("dt_nascimento").toLocalDate(), genero,
                		result.getString("email"), result.getString("senha"));

                listUsuario.add(usuario);
            }

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new SQLException("Erro ao cadastrar usuário", e);
        } finally {
            connection.close();
        }

        return listUsuario;
    }
}
