<%-- 
    Document   : listar
    Created on : 31/05/2017, 21:39:28
    Author     : comp8
--%>

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
                                    <th>Vocação</th>
                                    <th>Skill Magia</th>
                                    <th>Skill Sword</th>
                                    <th>Skill Axe</th>
                                    <th>Skill Defesa</th>
                                    ${jogadoradministrador == null ? "" : "<th>Banir</th>" }
                                    ${jogadoradministrador == null ? "" : "<th>Excluir</th>" }
                                </tr>
                            </thead>
                            <c:forEach var="jogador" items="${listajogadores}">
                                <tr>
                                    <td><c:out value="${jogador.snome}"/></td>
                                    <td><c:out value="${jogador.ivocacao}"/></td>
                                    <td><c:out value="${jogador.ipoderdemagia}"/></td>
                                    <td><c:out value="${jogador.ipoderdesword}"/></td>
                                    <td><c:out value="${jogador.ipoderdeaxe}"/></td>
                                    <td><c:out value="${jogador.ipoderdedefesa}"/></td>  
                                    
                                    <c:if test= "${jogadoradministrador != null}">
                                        <td>
                                            <button class="btn btn-default" onClick="window.location.href ='banir?nome=${jogador.snome}'"/>Banir</button>    
                                        </td>
                                        <td>
                                            <button class="btn btn-default" onClick="window.location.href ='excluir?nome=${jogador.snome}'"/>Excluir</button>    
                                        </td>                                        
                                    </c:if>
                                </tr>
                            </c:forEach>
                                <%-- 
                                    
                                    <button class="btn btn-default"><c:out value="${loginlogout == null ? '' : jogador.snome}"/></button>                                                                    
                                Funcionando
                                <button><c:out value="${loginlogout == null ? '' : jogador.snome}"/></button>
                                <td><c:out value="${loginlogout == null ? '' : jogador.snome}"/></td>
                                --%>
                        </table>
                    </div>
                </div>
            </div>
        </div>            
</div>