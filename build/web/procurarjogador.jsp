<%-- 
    Document   : procurarjogador
    Created on : 31/05/2017, 21:38:48
    Author     : comp8
--%>

<h1 align="center">Procurar jogador</h1>

<div class="container bd-content">
    <div class="tab-content" id="myTabContent">
        <div class="tab-responsive">
            <!-- tem que colocar o post, pois assim não altera a URL-->
            <fieldsetd class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-10">
                        <input id="inputnomejogador" class="form-control" name="nomejogador" placeholder="Nome jogador"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <button id="btn_procura" class="btn btn-primary">Procurar jogador</button>
                        <span style="visibility: hidden; color: red;" id="naoachouninguem">Não achou ninguem</span>
                    </div>
                </div>
                
                <!-- Para quando achar um jogador -->
                <div style="visibility: hidden;" id="achoujogador" class="wrapper">
                    <hr  width="50%" size="10" style="border: 1px solid #070707" />
                    <div class="form-group">
                        <label class="control-label col-sm-2">Nome jogador</label>
                        <div class="col-sm-10">
                        <span id="mostranomejogador" class="form-control" />
                        </div>
                    </div>
                </div>                 
            </fieldsetd>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
       $('#btn_procura').click(function(){
           var nomejogador = $('#inputnomejogador').val();
           $.ajax({
               type:'GET',
               data: {nomejogador , nomejogador},
               url: 'procurarjogador',
               headers : {
                   Accept : "application/json; charset=utf-8",
                   "Content-Type" : "application/json; charset=utf-8"
               },
               success: function(result){
                   var product = $.parseJSON(result);
                   
                    if(product === null){
                       document.getElementById('achoujogador').style.visibility = "hidden";
                       document.getElementById('naoachouninguem').style.visibility = "visible";                       
                   }else{                       
                       document.getElementById('achoujogador').style.visibility = "visible";                        
                       document.getElementById('naoachouninguem').style.visibility = "hidden";                       
                       //alert(product.snome);  
                       $('#mostranomejogador').html(product.snome);
                   }
                   //$('#mostranome').html(msg);
               }
           });
       });
    });
</script>