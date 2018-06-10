<%-- 
    Document   : aftersuccess
    Created on : 04/06/2017, 10:37:04
    Author     : Felipe

--%>

<jsp:include page="/index.jsp" />

<div class="nomepadrao">
    <h1 align="center">Dados do jogador</h1>
    
        <div class="container bd-content">
            <div class="tab-content" id="myTabContent">
                <form class="form-horizontal" action="salvaredicaojogador" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Nome</label>
                        <div class="col-sm-10">
                            <input readonly class="form-control" value="${jogador.snome}" name="nomepersonagem" placeholder="Nome personagem"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Email</label>
                        <div class="col-sm-10">
                            <input readonly class="form-control" value="${jogador.semail}" name="email" placeholder="E-mail"/>
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
                            <input disabled class="form-control" value="${jogador.ddatecriacao}" placeholder="Password"/>
                        </div>                  
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Vocação</label>
                        <div class="col-sm-10">
                            <input readonly class="form-control" value="${jogador.ivocacao}" name="vocacao" placeholder="Vocação"/>
                        </div>                  
                    </div>                        
                    <div class="form-group">
                        <label class="control-label col-sm-2">Adiministrador?</label>
                        <div class="col-sm-10">
                            <input id="jogadoreadministrador" readonly class="form-control" value="${jogador.badministrador}" name="administrador" placeholder="Administrador"/>
                        </div>                  
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Banido?</label>
                        <div class="col-sm-10">
                            <input readonly class="form-control" value="${jogador.bbanido}" name="banido" placeholder="Banido"/>
                        </div>                  
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Poder de magia</label>
                        <div class="col-sm-10">
                            <input readonly class="form-control" value="${jogador.ipoderdemagia}" name="ipoderdemagia" placeholder="Poder de magia"/>
                        </div>                  
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Poder sword</label>
                        <div class="col-sm-10">
                            <input readonly class="form-control" value="${jogador.ipoderdesword}" name="ipoderdesword" placeholder="Poder sword"/>
                        </div>                  
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Poder axe</label>
                        <div class="col-sm-10">
                            <input readonly class="form-control" value="${jogador.ipoderdeaxe}" name="ipoderdeaxe" placeholder="Poder axe"/>
                        </div>                  
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Poder defesa</label>
                        <div class="col-sm-10">
                            <input readonly class="form-control" value="${jogador.ipoderdedefesa}" name="ipoderdedefesa" placeholder="Poder defesa"/>
                        </div>                  
                    </div>      
                        <center>
                            <button type="submit" class="btn btn-default">Salvar</button>
                        </center>
                </form>
            </div>
        </div>
</div>
    <script>
        $(function(){
            
            var jogadoreadministrador = $('#jogadoreadministrador').val();
            if(jogadoreadministrador == "true"){
                //https://stackoverflow.com/questions/16298281/set-readonly-property-to-false-for-an-html-text-input-on-clicking-an-anchor-tag
                //  remove todos os valores
                $("input").prop('readonly', false);
            }
        });
    </script>


