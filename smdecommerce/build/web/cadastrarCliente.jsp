<%-- 
    Document   : cadastrarCliente
    Created on : 27 de mai. de 2025, 18:58:27
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
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex min-h-screen items-center justify-center flex-col antialiased bg-neutral-100">

    <form action="InserirCliente" method="post" class="bg-white px-8 py-12 rounded-lg shadow-xl flex flex-col min-w-sm gap-3 w-full max-w-md">
        <div>
            <img src="imgs/MOVFIT.png" alt="Logo MOVFIT" class="w-28 mx-auto mb-4" />
        </div>
        <h1 class="text-xl font-bold text-center mb-4">Criar uma conta</h1>

        <input type="text" name="nome" placeholder="Nome"
               class="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-black focus:border-black" />

        <input type="text" name="endereco" placeholder="Endereço"
               class="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-black focus:border-black" />

        <input type="email" name="email" placeholder="Email"
               class="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-black focus:border-black" />

        <input type="text" name="login" placeholder="Login"
               class="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-black focus:border-black" />

        <input type="password" name="senha" placeholder="Senha"
               class="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-black focus:border-black" />

        <input type="submit" value="Cadastrar"
               class="w-full cursor-pointer bg-black text-white py-2 rounded-md hover:bg-gray-800 transition-colors" />

        <a href="index.jsp"
           class="text-sm text-center mt-4 underline hover:text-gray-700">Já tenho um conta</a>
    </form>

</body>
</html>
