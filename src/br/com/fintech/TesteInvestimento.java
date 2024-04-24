package br.com.fintech;

import java.time.LocalDate;
import java.util.List;

import br.com.fintech.dao.CategoriaDAO;
import br.com.fintech.dao.CategoriaDAOImpl;
import br.com.fintech.dao.InvestimentoDAO;
import br.com.fintech.dao.InvestimentoDAOImpl;
import br.com.fintech.entities.Banco;
import br.com.fintech.entities.Categoria;
import br.com.fintech.entities.Investimento;
import br.com.fintech.entities.InvestimentoCDBS;

public class TesteInvestimento {

	 public static void main(String[] args) {
	        editarInvestimento();
	        deletarInvestimento();
	        getAllInvestimentos();
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
	            int idEdit = 29;
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
