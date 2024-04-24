package br.com.fintech;

import java.time.LocalDate;
import java.util.List;
import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.dao.InvestimentoDAOImpl;
import br.com.fintech.entities.Banco;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.InvestimentoCDBS;
import br.com.fintech.entities.Usuario;
import br.com.fintech.enums.TipoInvestimento;

public class TesteInvestimento {

	 public static void main(String[] args) {
		 	cadastrarInvestimento();
//	        editarInvestimento();
//	        deletarInvestimento();
//	        getAllInvestimentos();
	    }

	 public static void cadastrarInvestimento() {
	        try {
	            InvestimentoDAO investimentoDAO = new InvestimentoDAOImpl();

	            Investimento investimento = new InvestimentoCDBS();
	            investimento.setId(67);
	            Banco banco = new Banco();
	            banco.setId(21);
	            investimento.setBanco(banco);
	            investimento.setTipoInvestimento(TipoInvestimento.CDBS);
	            Usuario usuario = new Usuario();
	            usuario.setId(16);
	            investimento.setUsuario(usuario);
	            investimento.setValor(3000.0);
	            investimento.setValorRetirado(13000.0);
	            investimento.setDtInvestimento(LocalDate.now());
	            investimento.setDtVencimento(LocalDate.of(2026, 8, 10));
	            investimentoDAO.insert(investimento);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void editarInvestimento() {
	        try {
	            int idEdit = 26;
	            InvestimentoDAO investimentoDAO = new InvestimentoDAOImpl();
	            Investimento investimento = new InvestimentoCDBS();
	            Banco banco = new Banco();
	            banco.setId(21);
	            investimento.setBanco(banco);
	            investimento.setDtInvestimento(LocalDate.now());
	            investimento.setValor(2500.0);
	            investimento.setValorRetirado(5000.0);
	            
	            investimentoDAO.update(idEdit, investimento);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void deletarInvestimento() {
	        try {
	            int idEdit = 27;
	            InvestimentoDAO investimentoDAO = new InvestimentoDAOImpl();

	            investimentoDAO.delete(idEdit);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void getAllInvestimentos() {
	        try {
	            InvestimentoDAO investimentoDAO = new InvestimentoDAOImpl();

	            List<Investimento>  listInvestimento = investimentoDAO.getAll();
	           
	            for (Investimento inv : listInvestimento) {
	                System.out.println(inv.toString());
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
}
