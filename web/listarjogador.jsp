<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/index.jsp" />

<div class="nomepadrao">
    <h1 align="center">Listar jogadores</h1>
        <div>
            <div class="container bd-content">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Nome personagem</th>
                                    <th>Email</th>
                                    ${jogadoradministrador == null ? "" : "<th>Excluir</th>" }
                                </tr>
                            </thead>
                            <c:forEach var="jogador" items="${listajogadores}">
                                <tr>
                                    <td><c:out value="${jogador.snome}"/></td>
                                    <td><c:out value="${jogador.semail}"/></td>
                                    <td>
                                        <button class="btn btn-default" onClick="window.location.href ='salvaredicaojogador?nomepersonagem=${jogador.snome}'"/>Editar</button>    
                                    </td>                       
                    
                                    <td>
                                        <button class="btn btn-default" onClick="window.location.href ='excluir?nome=${jogador.snome}'"/>Excluir</button>    
                                    </td>                                        
                                   
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>            
</div>