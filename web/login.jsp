<%-- 
    Document   : login
    Created on : 31/05/2017, 21:37:59
    Author     : comp8
--%>

<jsp:include page="/index.jsp" />
<div class="nomepadrao">
    <h1 align="center">Login</h1>
    <div class="container bd-content">
        <div class="tab-content" id="myTabContent">
            <form class="form-horizontal" action="login" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-2">E-mail</label>
                    <div class="col-sm-10">
                        <input class="form-control" name="email" placeholder="E-mail"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Password</label>
                    <div class="col-sm-10">
                        <input class="form-control" name="password" placeholder="Password">
                    </div>
                </div>  
                <!-- align="center" ??¿¿ -->
                <center>
                    <button type="submit" class="btn btn-default">Entrar</button>
                </center>
            </form>        
        </div>
    </div>
</div>