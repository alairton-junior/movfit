package modelo.produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seu Nome
 *
 * Classe que implementa o padrão DAO para a entidade Produto
 */
public class ProdutoDAO {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/smdecommerce";
    private static final String JDBC_USUARIO = "postgres";
    private static final String JDBC_SENHA = "ufc123";

    /**
     * Método para listar todos os produtos
     * @return
     */
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT id, descricao, preco, foto, quantidade FROM produto");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setFoto(rs.getString("foto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            rs.close();
            s.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return produtos;
    }

    /**
     * Método para obter um produto pelo ID
     * @param id
     * @return
     */
    public Produto obter(int id) {
        Produto produto = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement(
                    "SELECT id, descricao, preco, foto, quantidade FROM produto WHERE id = ?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setFoto(rs.getString("foto"));
                produto.setQuantidade(rs.getInt("quantidade"));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return produto;
    }

    /**
     * Método para inserir um novo produto
     * @param produto
     * @return
     */
    public boolean inserir(Produto produto) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO produto (descricao, preco, foto, quantidade) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, produto.getDescricao());
            ps.setDouble(2, produto.getPreco());
            ps.setString(3, produto.getFoto());
            ps.setInt(4, produto.getQuantidade());
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para atualizar um produto existente
     * @param produto
     * @return
     */
    public boolean atualizar(Produto produto) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE produto SET descricao = ?, preco = ?, foto = ?, quantidade = ? WHERE id = ?"
            );
            ps.setString(1, produto.getDescricao());
            ps.setDouble(2, produto.getPreco());
            ps.setString(3, produto.getFoto());
            ps.setInt(4, produto.getQuantidade());
            ps.setInt(5, produto.getId());
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para remover um produto
     * @param id
     * @return
     */
    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM produto WHERE id = ?");
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
