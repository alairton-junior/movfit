package modelo.venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o padrão DAO para a entidade Venda
 */
public class VendaDAO {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/smdecommerce";
    private static final String JDBC_USUARIO = "postgres";
    private static final String JDBC_SENHA = "ufc123";

    /**
     * Método para listar todas as vendas
     * @return
     */
    public List<Venda> listar() {
        List<Venda> vendas = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT id, data_hora, usuario_id FROM venda");
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setDataHora(rs.getTimestamp("data_hora"));
                venda.setUsuarioId(rs.getInt("usuario_id"));
                vendas.add(venda);
            }
            rs.close();
            s.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return vendas;
    }

    /**
     * Método para obter uma venda pelo id
     * @param id
     * @return
     */
    public Venda obter(int id) {
        Venda venda = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, data_hora, usuario_id FROM venda WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setDataHora(rs.getTimestamp("data_hora"));
                venda.setUsuarioId(rs.getInt("usuario_id"));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return venda;
    }

    /**
     * Método para inserir uma nova venda
     * @param usuarioId
     * @return
     */
    public boolean inserir(int usuarioId) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO venda (usuario_id) VALUES (?)");
            ps.setInt(1, usuarioId);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para atualizar uma venda
     * @param id
     * @param usuarioId
     * @return
     */
    public boolean atualizar(int id, int usuarioId) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE venda SET usuario_id = ? WHERE id = ?");
            ps.setInt(1, usuarioId);
            ps.setInt(2, id);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para remover uma venda
     * @param id
     * @return
     */
    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM venda WHERE id = ?");
            ps.setInt(1, id);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }
}
