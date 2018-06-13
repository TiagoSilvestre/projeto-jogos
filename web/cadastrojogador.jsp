<jsp:include page="/index.jsp" />

<div class="nomepadrao">
    <center>
        <h1>Cadastro Jogador</h1>
    </center>
    <div class="container bd-content">
        <form action="acaocadastrar" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label">Nome Personagem</label>
                <div class="col-sm-10">
                    <input class="form-control" name="nomepersonagem" placeholder="Nome Personagem">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">E-mail</label>
                <div class="col-sm-10">
                    <input  class="form-control" name="email" placeholder="E-mail">
                </div>
            </div>  
            <div class="form-group">
                <label class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                </div>
            </div>              

            <center>
                <button type="submit" class="btn btn-default">Salvar</button>
            </center>
        </form>
    </div>
</div>