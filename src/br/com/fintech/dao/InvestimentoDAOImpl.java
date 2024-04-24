package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import br.com.fintech.connection.FintechDB;
import br.com.fintech.entities.Banco;
import br.com.fintech.entities.Categoria;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.InvestimentoCDBS;

public class InvestimentoDAOImpl implements InvestimentoDAO {

	private Connection connection;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    String sql;
	
	@Override
	public void calculateInvestimento(double valorInvestido) {
		// TODO Auto-generated method stub		
	}

	@Override
	public Investimento update(int id, Investimento investimento) throws SQLException {
		 sql = "UPDATE T_INVESTIMENTO SET ID_BANCO = ? , VAL_INVESTIDO = ?, VAL_RETIRADO = ?, DT_VENCIMENTO = ? WHERE CD_INVESTIMENTO = ?";
	        try {
	        	connection = FintechDB.getInstance().getConnection();
	            preparedStatement = connection.prepareStatement(sql);

	            preparedStatement.setInt(1, investimento.getBanco().getId());
	            preparedStatement.setDouble(2, investimento.getValor());
	            preparedStatement.setDouble(3, investimento.getValorRetirado());
	            Date date = Date.valueOf(investimento.getDtInvestimento());
	            preparedStatement.setDate(4, date);
	            preparedStatement.setInt(5, id);
	            
	            int rowCountResult = preparedStatement.executeUpdate();
	            
	            if(rowCountResult <= 0) {
	            	throw new SQLException("Erro ao tentar editar o investimento. "
	            			+ "Nenhum dado foi atualizado, verifique as informações e tente novamente.");
	            	
	            } else {
	            	  System.out.println(("O investimento foi atualizada!!"));
	                  connection.commit();
	            }
	          
	        }
	        catch (Exception e) {
	        	connection.rollback();
	        	System.err.println(e);
	        }
	        return investimento;	
	 }
	
	

	@Override
	public void delete(int id) throws SQLException {
		sql = "DELETE T_INVESTIMENTO WHERE CD_INVESTIMENTO = ?";
        try {
        	connection = FintechDB.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rowCountResult = preparedStatement.executeUpdate();
            if(rowCountResult <= 0) {
            	throw new SQLException("Erro ao tentar deletar o investimento. "
            			+ "Nenhum dado foi deletado, verifique as informações e tente novamente.");
            	
            } else {
            	 System.out.println(("O investimento foi deletada!!"));
                 connection.commit();
            }
           
        } catch (Exception e) {
        	connection.rollback();
        	System.err.println(e);
        }
		
	}
	
	  @Override
	    public List<Investimento> getAll() throws SQLException {
	        List<Investimento> listInvestimentos = new ArrayList<Investimento>();
	        sql = "SELECT * FROM T_INVESTIMENTO";
	        try {
	        	connection = FintechDB.getInstance().getConnection();
	            statement  = connection.createStatement();

	            ResultSet result = statement.executeQuery(sql);
	           

	            while (result.next()) {
	                Investimento investimento = new InvestimentoCDBS();
	                investimento.setId(result.getInt("cd_investimento"));	
	                Banco banco = new Banco();
	                banco.setId(result.getInt("id_banco"));
	                investimento.setBanco(banco);
	                investimento.setValorRetirado(result.getDouble("val_retirado"));
	                investimento.setValor(result.getDouble("val_investido"));	
	                listInvestimentos.add(investimento);
	            }
	          
	            connection.commit();
	        } catch (SQLException e) {
	            connection.rollback();
	            throw new SQLException("Erro ao listar investimentos", e);
	        }

	        return listInvestimentos;
	    }

	@Override
	public void insert(Investimento investimento) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
