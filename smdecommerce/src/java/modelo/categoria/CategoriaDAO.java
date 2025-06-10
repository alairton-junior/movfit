package modelo.categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe que implemnta o padrão DAO para a entidade categoria
 */
public class CategoriaDAO {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/smdecommerce";
    private static final String JDBC_USUARIO = "postgres";
    private static final String JDBC_SENHA = "ufc123";

    /**
     * Método para listar todas as categorias existentes
     * @return
     */
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL,JDBC_USUARIO, JDBC_SENHA);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT id, descricao FROM categoria");
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
            rs.close();
            s.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categorias;
    }

    /**
     * Método para obter uma categoria pelo o identificador
     *
     * @param id
     * @return
     */
    public Categoria obter(int id) {
        Categoria categoria = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL,JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, descricao FROM categoria WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }

    /**
     * Método para inserir uma nova categoria
     *
     * @param descricao
     * @return
     */
    public boolean inserir(String descricao) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL,JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO categoria (descricao) VALUES (?)");
            ps.setString(1, descricao);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para atualizar uma  categoria
     *
     * @param descricao
     * @param id
     * @return
     */
    public boolean atualizar(String descricao, int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL,JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE categoria SET descricao = ? WHERE id = ?");
            ps.setString(1, descricao);
            ps.setInt(2, id);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para deletar uma  categoria
     *
     * @param id
     * @return
     */
    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL,JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM categoria WHERE id = ?");
            ps.setInt(1, id);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }
}
