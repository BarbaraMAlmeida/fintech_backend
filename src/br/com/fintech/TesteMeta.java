package br.com.fintech;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import br.com.fintech.dao.MetaDAO;
import br.com.fintech.dao.MetaDAOImpl;
import br.com.fintech.entities.Meta;
import br.com.fintech.entities.Usuario;

public class TesteMeta {
    public static void main(String[] args) {
        //cadastrarMeta();
        //atualizarMeta();
       // deletarMeta();
        listarMetas();
    }

    public static void cadastrarMeta() {
        try {
            MetaDAO metaDAO = new MetaDAOImpl();

            Meta meta = new Meta();
            meta.setNomeMeta("Meta 1");
            meta.setDtFimMeta(LocalDate.of(2024, 4, 30));
            meta.setValor(5000.00);
            Usuario usuario = new Usuario();
            usuario.setId(1);
            meta.setUsuario(usuario);
            metaDAO.insert(meta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarMeta() {
        try {
            int id = 1;
            MetaDAO metaDAO = new MetaDAOImpl();
            Meta meta = new Meta();
           
            meta.setNomeMeta("Nova Meta 1");
            meta.setDtFimMeta(LocalDate.of(2024, 5, 15));
            metaDAO.update(id, meta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarMeta() {
        try {
            int id = 1;
            MetaDAO metaDAO = new MetaDAOImpl();
            metaDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarMetas() {
        try {
            MetaDAO metaDAO = new MetaDAOImpl();
            List<Meta> metas = metaDAO.getAll();

            System.out.println("Todas as Metas:");
            for (Meta meta : metas) {
                System.out.println(meta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
