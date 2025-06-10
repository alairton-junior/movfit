<%-- 
    Document   : principal
    Created on : 27 de mai. de 2025, 19:34:15
    Author     : Leonardo Oliveira Moreira
--%>

<%@page import="modelo.usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>smd e-commerce</title>
    </head>
    <body>
        <h1>Olá, <%= usuario.getNome()%></h1>
        <h3>Perfil de: <%=(usuario.isAdministrador() ? "Administrador" : "Cliente") %></h3>
        <a href="atualizarDados.jsp">Atualizar Dados Pessoais</a> | 
        <a href="RemoverUsuario?id=<%= usuario.getId() %>">Remover Conta</a>
        | <a href="Logout">Sair</a>
    </body>
</html>
<%
    } else {
        request.setAttribute("mensagem", "Você não tem permissão para acessar esta página");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
%>
