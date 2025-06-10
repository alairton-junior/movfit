<%-- 
    Document   : atualizarDados
    Created on : 3 de jun. de 2025, 18:49:36
    Author     : Leonardo Oliveira Moreira
--%>

<%@page import="modelo.usuario.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>smd e-commerce</title>
    </head>
    <body>
        <h1>Atualizar Dados Pessoais</h1>
        <form action="AtualizarUsuario" method="post">
            Id: <input type="text" readonly="" name="id" value="<%= usuario.getId() %>" /><br/>
            Nome: <input type="text" name="nome" value="<%= usuario.getNome() %>" /><br/>
            Endereço: <input type="text" name="endereco" value="<%= usuario.getEndereco() %>" /><br/>
            Email: <input type="text" name="email" value="<%= usuario.getEmail() %>" /><br/>
            Login: <input type="text" name="login" value="<%= usuario.getLogin() %>" /><br/>
            Senha: <input type="password" name="senha" value="<%= usuario.getSenha()%>" /><br/>
            <input type="submit" value="Salvar" />
        </form>
    </body>
</html>
