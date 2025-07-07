package controle.produto;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.produto.Produto;
import modelo.produto.ProdutoDAO;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe de controle para preparar o formulário para inserir ou atualizar a
 * foto de um produto
 */
public class AtualizarProdutoFotoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listar();
        request.setAttribute("produtos", produtos);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/produto/atualizarFoto.jsp");
        rd.forward(request, response);
    }
}
