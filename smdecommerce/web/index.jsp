<%-- 
    Document   : index
    Created on : 22 de mai. de 2025, 18:42:53
    Author     : Leonardo Oliveira Moreira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>smd e-commerce</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    </head>
    <body class="flex min-h-screen items-center justify-center flex-col antialiased bg-neutral-100">
        
        <form action="Login" method="post" class="bg-white px-8 py-12 rounded-lg shadow-xl flex flex-col min-w-sm gap-3">
            <div>
                <img src="imgs/MOVFIT.png" class="w-28 mx-auto"/>
            </div>
            <h1>Login</h1>
            
            <input type="text" name="login" class="form-control mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-black focus:border-black" id="formControlLogin" placeholder="E-mail">
        
            <input type="password" name="senha" class="form-control mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-black focus:border-black" id="formControlSenha" placeholder="Senha">

            <input class="w-full cursor-pointer bg-black text-white py-2 rounded-md hover:bg-gray-800 transition-colors" type="submit" value="Entrar" />
                       <%
            String mensagem = (String) request.getAttribute("mensagem");
            if (mensagem != null) {
            %>
            <p class="text-red-400" role="alert">
                <%= mensagem %>
            </p>
            <%
                }
            %>
            <a class="text-sm text-center  mt-4 underline" href="cadastrarCliente.jsp">Criar uma conta</a>
        </form>
        </div>
        
    </body>
</html>
