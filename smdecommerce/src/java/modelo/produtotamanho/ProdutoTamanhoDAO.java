package modelo.produtotamanho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe que implementa o padrão DAO para a entidade ProdutoTamanho
 */
public class ProdutoTamanhoDAO {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/smdecommerce";
    private static final String JDBC_USUARIO = "postgres";
    private static final String JDBC_SENHA = "ufc123";

    /**
     * Método para listar todos os registros de ProdutoTamanho
     * @return
     */
    public List<ProdutoTamanho> listar() {
        List<ProdutoTamanho> lista = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT id, tamanho, quantidade, produto_id FROM produto_tamanho");
            while (rs.next()) {
                ProdutoTamanho pt = new ProdutoTamanho();
                pt.setId(rs.getInt("id"));
                pt.setTamanho(rs.getString("tamanho"));
                pt.setQuantidade(rs.getInt("quantidade"));
                pt.setProdutoId(rs.getInt("produto_id"));
                lista.add(pt);
            }
            rs.close();
            s.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    /**
     * Método para obter um ProdutoTamanho pelo id
     * @param id
     * @return
     */
    public ProdutoTamanho obter(int id) {
        ProdutoTamanho pt = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT id, tamanho, quantidade, produto_id FROM produto_tamanho WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pt = new ProdutoTamanho();
                pt.setId(rs.getInt("id"));
                pt.setTamanho(rs.getString("tamanho"));
                pt.setQuantidade(rs.getInt("quantidade"));
                pt.setProdutoId(rs.getInt("produto_id"));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return pt;
    }

    /**
     * Método para inserir um novo ProdutoTamanho
     * @param tamanho
     * @param quantidade
     * @param produtoId
     * @return
     */
    public boolean inserir(String tamanho, int quantidade, int produtoId) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO produto_tamanho (tamanho, quantidade, produto_id) VALUES (?, ?, ?)");
            ps.setString(1, tamanho);
            ps.setInt(2, quantidade);
            ps.setInt(3, produtoId);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para atualizar um ProdutoTamanho
     * @param id
     * @param tamanho
     * @param quantidade
     * @param produtoId
     * @return
     */
    public boolean atualizar(int id, String tamanho, int quantidade, int produtoId) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE produto_tamanho SET tamanho = ?, quantidade = ?, produto_id = ? WHERE id = ?");
            ps.setString(1, tamanho);
            ps.setInt(2, quantidade);
            ps.setInt(3, produtoId);
            ps.setInt(4, id);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para remover um ProdutoTamanho
     * @param id
     * @return
     */
    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM produto_tamanho WHERE id = ?");
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
