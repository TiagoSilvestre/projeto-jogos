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
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="/jogo">PROJETO JOGOS</a>
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
