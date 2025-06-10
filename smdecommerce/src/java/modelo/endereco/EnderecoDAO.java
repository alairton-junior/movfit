package modelo.endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seu Nome
 *
 * Classe que implementa o padrão DAO para a entidade Endereco
 */
public class EnderecoDAO {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/smdecommerce";
    private static final String JDBC_USUARIO = "postgres";
    private static final String JDBC_SENHA = "ufc123";

    /**
     * Método para listar todos os endereços
     * @return
     */
    public List<Endereco> listar() {
        List<Endereco> enderecos = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT id, cidade, estado, cep, numero, complemento, bairro FROM endereco");
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCep(rs.getString("cep"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                enderecos.add(endereco);
            }
            rs.close();
            s.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return enderecos;
    }

    /**
     * Método para obter um endereço pelo ID
     * @param id
     * @return
     */
    public Endereco obter(int id) {
        Endereco endereco = null;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement(
                    "SELECT id, cidade, estado, cep, numero, complemento, bairro FROM endereco WHERE id = ?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCep(rs.getString("cep"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }

    /**
     * Método para inserir um novo endereço
     * @param endereco
     * @return
     */
    public boolean inserir(Endereco endereco) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO endereco (cidade, estado, cep, numero, complemento, bairro) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, endereco.getCidade());
            ps.setString(2, endereco.getEstado());
            ps.setString(3, endereco.getCep());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para atualizar um endereço existente
     * @param endereco
     * @return
     */
    public boolean atualizar(Endereco endereco) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement(
                    "UPDATE endereco SET cidade = ?, estado = ?, cep = ?, numero = ?, complemento = ?, bairro = ? WHERE id = ?"
            );
            ps.setString(1, endereco.getCidade());
            ps.setString(2, endereco.getEstado());
            ps.setString(3, endereco.getCep());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            ps.setInt(7, endereco.getId());
            sucesso = (ps.executeUpdate() == 1);
            ps.close();
            c.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucesso;
    }

    /**
     * Método para remover um endereço
     * @param id
     * @return
     */
    public boolean remover(int id) {
        boolean sucesso = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(JDBC_URL, JDBC_USUARIO, JDBC_SENHA);
            PreparedStatement ps = c.prepareStatement("DELETE FROM endereco WHERE id = ?");
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
