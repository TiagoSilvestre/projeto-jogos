<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>      
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/dashboard.css">        

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PROJETO JOGOS</title>
    </head>
    <body>
        <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">PROJETO JOGOS</a>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link active" href="/jogo">
                                    <span data-feather="home"></span>
                                    Dashboard <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="cadastrojogador">
                                    <span data-feather="file"></span>
                                    Cadastro
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="listarjogador">
                                    <span data-feather="users"></span>
                                    Jogadores
                                </a>
                            </li>
                        </ul>


                    </div>
                </nav>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Dashboard</h1>
                    </div>
                    <div id="opcoesJogador"></div>
                </main>
            </div>
        </div>



        <!--        
                <div class="headeres"></div>
                <header class="bs-docs-header" style="background-color: black; height: 10px;">     
                <div id="wrapper" class="toggled">            
        <!-- Sidebar 
        <div id="sidebar-wrapper">                
            <ul class="sidebar-nav">
                <li class="sidebar-brand" style="font-size: 28px;color: white;">                        
                    Lista de Opções
                </li>
                <li class="sidebar-brand">                        
                    <a href="cadastrojogador">Cadastro de Jogador</a>           
                </li>
        -->
        <!-- <li>             
             <a href="#" onclick="paginaJogador('procurarjogador.jsp')">Procurar Jogador</a>
         </li>
         <li class="sidebar-brand">
             <a href="listarjogador">Listar Todos</a>
         </li>            
         
     </ul>                
 </div>
        -->            
        <!-- Onde vai ser carregado as paginas 
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
            Todos direitos reservados
        </center>                    
    </footer>
        -->  

        <script src="https://code.jquery.com/jquery-3.2.1.js"></script>      
        <script src="js/bootstrap.min.js"></script>  
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>

        <!-- Icons -->
        <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
        <script>
            feather.replace()
        </script>
    </body>
    <script>
        //  Usado para carregar uma pagina JSP ou um trecho de codigo html
        function paginaJogador(pagina) {
            if (pagina.indexOf('.jsp') > 0) {
                $("#opcoesJogador").load(pagina);
            }

            //  Para carregar um html dentro de um elemento tem que usar esse js.            
            // $('.opcoesJogador').append($('.nomepadrao').html());

            // vai remover a div, como não está atualizando a pagina inteira
            //  tem que remover o elemento
            $('div').remove('.nomepadrao');
        }

        $(function () {
            // Quando se carrega um novo jsp, ele coloca o codigo html ao final da pagina
            // então é necessario mover ele            
            $(".nomepadrao").appendTo("#opcoesJogador");
        });

    </script>    
</html>
