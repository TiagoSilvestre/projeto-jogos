<jsp:include page="/index.jsp" />

<div class="nomepadrao">
    <h1 align="center">Dados do jogador</h1>
    
        <div class="container bd-content">
            <div class="tab-content" id="myTabContent">
                <form class="form-horizontal" action="editarjogador" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Nome</label>
                        <div class="col-sm-10">
                            <input disabled class="form-control" value="${jogador.snome}" name="nomepersonagem" placeholder="Nome personagem"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Email</label>
                        <div class="col-sm-10">
                            <input class="form-control" value="${jogador.semail}" name="email" placeholder="E-mail"/>
                        </div>                  
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Password</label>
                        <div class="col-sm-10">
                            <input class="form-control" value="${jogador.spassword}" name="password" placeholder="Password"/>
                        </div>                  
                    </div>                        
                    <div class="form-group">
                        <label class="control-label col-sm-2">Data criação</label>
                        <div class="col-sm-10">
                            <input disabled class="form-control" value="${jogador.ddatecriacao}"/>
                        </div>                  
                    </div>

                        
                       
                        <center>
                            <button type="submit" class="btn btn-default">Salvar</button>
                        </center>
                </form>
            </div>
        </div>
</div>


