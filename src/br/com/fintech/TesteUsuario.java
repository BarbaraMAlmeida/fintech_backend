package br.com.fintech;

import br.com.fintech.dao.UsuarioDAO;
import br.com.fintech.dao.UsuarioDAOImpl;
import br.com.fintech.entities.Genero;
import br.com.fintech.entities.Usuario;

import java.time.LocalDate;
import java.util.List;

public class TesteUsuario {
	public static void main(String[] args) {
		insertUsuario();
        deletarUsuario();
        getAllUsuarios();
	}
	
	public static void insertUsuario() {
        try {
            UsuarioDAO UsuarioDAO = new UsuarioDAOImpl();

            Usuario usuario = new Usuario();
            usuario.setId(10);
            usuario.setNomeUsuario("Beatriz");                   
            usuario.setDtNascimento(LocalDate.of(2001, 12,8));
            Genero genero = new Genero();
            genero.setId(2);
            usuario.setGenero(genero);
            usuario.setEmail("bea@gmail.com");
            usuario.setSenha("1234");
            UsuarioDAO.insert(usuario);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
		
	
	public static void deletarUsuario() {
        try {
            int idEdit = 10;
            UsuarioDAO UsuarioDAO = new UsuarioDAOImpl();

            UsuarioDAO.delete(idEdit);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void getAllUsuarios() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

            List<Usuario>  listUsuario = usuarioDAO.getAll();

            for (Usuario cat : listUsuario) {
                System.out.println(cat.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
