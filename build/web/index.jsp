<%-- 
    Document   : index
    Created on : 31/05/2017, 19:32:04
    Author     : comp8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://code.jquery.com/jquery-3.2.1.js"></script>

        <!-- Latest compiled and minified JavaScript -->        
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>        
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/simple-sidebar.css">        

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aspiraboo</title>
    </head>
    <body>
        <div style="background:url(imagens/castelo.jpg); height: 200px; background-size: 100%;"></div>
        <header class="bs-docs-header" style="background-color: black; height: 10px;">     
        <div id="wrapper" class="toggled">            
            <!-- Sidebar -->
            <div id="sidebar-wrapper">                
                <ul class="sidebar-nav">
                    <li class="sidebar-brand" style="font-size: 28px;color: white;">                        
                        Lista de Opções
                    </li>
                    <li class="sidebar-brand">                        
                        <!--<a href="#" onclick="paginaJogador('cadastrojogador.jsp')">Cadastro de Jogador</a>
                        -->
                        <a href="${loginlogout == null ? "cadastrojogador" : "minhaconta" }">${loginlogout == null ? "Cadastro de Jogador" : "Minha conta"}</a>                        
                    </li>
                    <li class="sidebar-brand">                        
                        <!--
                        <a href="#" onclick="paginaJogador('login.jsp')">Login</a>
                        -->
                        <a href="${loginlogout == null ? "login" : "logout" }">${loginlogout == null ? "login" : "logout" }</a>
                    </li>                    
                    <li class="sidebar-brand">                        
                        <a href="#" onclick="paginaJogador('procurarjogador.jsp')">Procurar Jogador</a>
                    </li>
                    <li class="sidebar-brand">
                        <a href="listarjogador">Listar Todos</a>
                    </li>            
                    <li class="sidebar-brand">
                        <a href="#" onClick="paginaJogador('bibliografia.jsp')">Bibliografia</a>
                    </li>                                
                </ul>                
            </div>
            
            <!-- Onde vai ser carregado as paginas -->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="col-lg-12">
                        <div id="opcoesJogador">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>    
        <footer id="rodape">
            <center>
                By aspiraboo    
            </center>                    
        </footer>           
    </body>
    <script>
        //  Usado para carregar uma pagina JSP ou um trecho de codigo html
        function paginaJogador(pagina){
            if (pagina.indexOf('.jsp') > 0){                
                $("#opcoesJogador").load(pagina);
            }
            
            //  Para carregar um html dentro de um elemento tem que usar esse js.            
            // $('.opcoesJogador').append($('.nomepadrao').html());
            
            // vai remover a div, como não está atualizando a pagina inteira
            //  tem que remover o elemento
            $('div').remove('.nomepadrao');            
        }

        $(function() {          
            // Quando se carrega um novo jsp, ele coloca o codigo html ao final da pagina
            // então é necessario mover ele            
          $(".nomepadrao").appendTo("#opcoesJogador");
        });

    </script>    
</html>
