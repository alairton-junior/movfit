package modelo.vendaprodutotamanho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o padrão DAO para a entidade VendaProdutoTamanho
 */
public class VendaProdutoTamanhoDAO {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/smdecommerce";
    private static final String JDBC_USUARIO = "postgres";
    private static final String JDBC_SENHA = "ufc123";

    /**
     * Método para listar todos os registros de venda_produto_tamanho
     * @return
     */
    public List<VendaProdutoTamanho> listar() {
        List<VendaProdutoTamanho> lista = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT venda_id, produto_tamanho_id, quantidade, preco_unitario FROM venda_produto_tamanho");
            while (rs.next()) {
                VendaProdutoTamanho vpt = new VendaProdutoTamanho();
                vpt.setVendaId(rs.getInt("venda_id"));
                vpt.setProdutoTamanhoId(rs.getInt("produto_tamanho_id"));
                vpt.setQuantidade(rs.getInt("quantidade"));
                vpt.setPrecoUnitario(rs.getDouble("preco_unitario"));
                lista.add(vpt);
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
     * Método para obter um registro específico de venda_produto_tamanho
     * @param vendaId
     * @param produtoTamanhoId
     * @return
     */
    public VendaProdutoTamanho obter(int vendaId, int produtoTamanhoId) {
        VendaProdutoTamanho vpt = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("SELECT venda_id, produto_tamanho_id, quantidade, preco_unitario FROM venda_produto_tamanho WHERE venda_id = ? AND produto_tamanho_id = ?");
            ps.setInt(1, vendaId);
            ps.setInt(2, produtoTamanhoId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vpt = new VendaProdutoTamanho();
                vpt.setVendaId(rs.getInt("venda_id"));
                vpt.setProdutoTamanhoId(rs.getInt("produto_tamanho_id"));
                vpt.setQuantidade(rs.getInt("quantidade"));
                vpt.setPrecoUnitario(rs.getDouble("preco_unitario"));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return vpt;
    }

    /**
     * Método para inserir um novo registro em venda_produto_tamanho
     * @param vendaId
     * @param produtoTamanhoId
     * @param quantidade
     * @param precoUnitario
     * @return
     */
    public boolean inserir(int vendaId, int produtoTamanhoId, int quantidade, java.math.BigDecimal precoUnitario) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("INSERT INTO venda_produto_tamanho (venda_id, produto_tamanho_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)");
            ps.setInt(1, vendaId);
            ps.setInt(2, produtoTamanhoId);
            ps.setInt(3, quantidade);
            ps.setBigDecimal(4, precoUnitario);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para atualizar um registro em venda_produto_tamanho
     * @param vendaId
     * @param produtoTamanhoId
     * @param quantidade
     * @param precoUnitario
     * @return
     */
    public boolean atualizar(int vendaId, int produtoTamanhoId, int quantidade, java.math.BigDecimal precoUnitario) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("UPDATE venda_produto_tamanho SET quantidade = ?, preco_unitario = ? WHERE venda_id = ? AND produto_tamanho_id = ?");
            ps.setInt(1, quantidade);
            ps.setBigDecimal(2, precoUnitario);
            ps.setInt(3, vendaId);
            ps.setInt(4, produtoTamanhoId);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para remover um registro em venda_produto_tamanho
     * @param vendaId
     * @param produtoTamanhoId
     * @return
     */
    public boolean remover(int vendaId, int produtoTamanhoId) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM venda_produto_tamanho WHERE venda_id = ? AND produto_tamanho_id = ?");
            ps.setInt(1, vendaId);
            ps.setInt(2, produtoTamanhoId);
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }
}
