<jsp:include page="/index.jsp" />

<div class="nomepadrao">
    <center>
        <h1>Cadastro Jogador</h1>
    </center>
    <div class="container">
        <form  action="acaocadastrar" method="post" class="form-horizontal">
            <div class="form-group">
                <label>Nome</label>
                <input name="nomepersonagem" type="text" class="form-control"placeholder="Digite seu nome">
            </div>
            <div class="form-group">
                <label>E-mail</label>
                <input name="email" type="email" class="form-control"placeholder="Digite seu e-mail">
                <small id="emailHelp" class="form-text text-muted">Nós nunca vamos compartilhar seu e-mail.</small>
            </div>
            <div class="form-group">
                <label>Senha</label>
                <input type="password" class="form-control" name="password" placeholder="Digite sua senha">
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
    </div>
</div>