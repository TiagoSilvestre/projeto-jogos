/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.ConexaoJogador;
import br.com.modelo.Jogador;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author comp8
 */
@WebServlet(name = "ControlerJogador", urlPatterns = {"/cadastrojogador", "/login", "/procurarjogador", "/salvaredicaojogador", "/listarjogador", "/logout", "/minhaconta", "/banir", "/excluir" })
public class SvControllerJogador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //https://github.com/BlackrockDigital/startbootstrap-simple-sidebar/blob/master/index.html
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String uri = request.getRequestURI();
                
        String jsp = null;        
        
        if(uri.endsWith("cadastrojogador")){                  
            jsp = cadastrojogador(request, response);
        }else if(uri.endsWith("listarjogador")){
            jsp = listarjogador(request);
        }else if(uri.endsWith("login")){
            jsp = login(request, response);
        }else if(uri.endsWith("salvaredicaojogador")){
            jsp = salvaredicaojogador(request);
        }else if(uri.endsWith("logout")){
            jsp = logout(request);
        }else if(uri.endsWith("minhaconta")){
            jsp = minhaconta(request);
        }else if(uri.endsWith("banir")){
            jsp = banirjogador(request);
        }else if(uri.endsWith("excluir")){
            jsp = excluirjogador(request);
        }else if(uri.endsWith("procurarjogador")){            
            procurarjogador(request, response);
        }     
        
        if(jsp != null){            
            request.getRequestDispatcher(jsp).forward(request, response);
        }else{
            //  usado para o funcionamento do ajax, ele estava retornando para a
            //  pagina inicial
            if(uri.endsWith("procurarjogador")){
                // 0x0
            }else{
            //  remove o que tem no link e volta para a pagina inicial
                response.sendRedirect("./");
            }
        }
    }
        private String excluirjogador(HttpServletRequest request){
            String sNomeJogador = request.getParameter("nome");
            Jogador jogador = ConexaoJogador.getJogador(sNomeJogador);
            ConexaoJogador.excluirJogador(jogador);
            return "listarjogador";
        }
        
        private String banirjogador(HttpServletRequest request){
            String sNomeJogador = request.getParameter("nome");
            Jogador jogador = ConexaoJogador.getJogador(sNomeJogador);
            ConexaoJogador.banirJogador(jogador);            
            return "listarjogador";
        }
        
        private String minhaconta(HttpServletRequest request){
            getEstaLogado(request);
            return "aftersuccess.jsp";
        }
        
        private String logout(HttpServletRequest request){
            HttpSession session = request.getSession();
            session.setAttribute("loginlogout", null);
            session.setAttribute("jogadorlogado", null);
            session.setAttribute("jogadoradministrador", null);    
            return "login.jsp";
        }
        
        private boolean getEstaLogado(HttpServletRequest request){
            //  ele retorna um objeto, sendo necessario fazer um quest com a class
            //  de jogador
            //Jogador jogador = (Jogador)request.getAttribute("jogador");
            HttpSession session = request.getSession();
            Object jogador = session.getAttribute("jogadorlogado");            
            
            if(jogador == null){
                return false;
            }
            
            request.setAttribute("jogador", jogador);
            session.setAttribute("loginlogout", true);
            return true;
        }
                
        private String listarjogador(HttpServletRequest request){
            List<Jogador> jogadores = new ArrayList<>();
            jogadores = ConexaoJogador.getJogadores(jogadores);
            request.setAttribute("listajogadores", jogadores);
            return "listarjogador.jsp";
        }
        
        private String salvaredicaojogador(HttpServletRequest request){
            String sNome = request.getParameter("nomepersonagem");            
            String sPassword = request.getParameter("password");
            
            Jogador jogador = ConexaoJogador.getJogador(sNome);
            
            if(jogador == null || sPassword == null){
                return "paginaerro.jsp";
            }
            
            jogador.setSpassword(sPassword);
            jogador = ConexaoJogador.updatePassword(jogador);
            //  necessario para verificar se deu algum erro no update
            if(jogador == null){
                return "paginaerro.jsp";
            }
            
            request.setAttribute("jogador", jogador);
            return "aftersuccess.jsp";
        }
        
        private String cadastrojogador(HttpServletRequest request, HttpServletResponse response){
            //  verifica se o usuario está logado
            boolean bEstaLogado = getEstaLogado(request);
            if(!bEstaLogado){
                //  dados incompletos
                if(request.getParameter("nomepersonagem") == null || request.getParameter("email") == null || request.getParameter("password") == null || request.getParameter("vocacao") == null){
                    return "cadastrojogador.jsp";
                }            
                String sNomePersonagem = request.getParameter("nomepersonagem");
                String sEmail = request.getParameter("email");
                String sPassword = request.getParameter("password");

                //  como ele está fazendo um cast de um valor null, vai para a pagina de erro
                //  tem que ser verificado antes se todos os valores estão preenchidos
                int sVocacao = Integer.valueOf(request.getParameter("vocacao"));

                Jogador jogador = ConexaoJogador.getJogador(sNomePersonagem);
                if(jogador == null){
                    jogador = new Jogador();
                    jogador.setDdatecriacao(new Date());
                }

                jogador.setSnome(sNomePersonagem);
                jogador.setSemail(sEmail);
                jogador.setSpassword(sPassword);
                jogador.setIvocacao(sVocacao);

                jogador = ConexaoJogador.insert(jogador);
                if(jogador == null){
                    return "paginaerro.jsp";
                }
                
                HttpSession session = request.getSession();
                session.setAttribute("jogadorlogado", jogador);
                session.setAttribute("loginlogout", true);
                
                request.setAttribute("jogador", jogador);
            }
            return "aftersuccess.jsp";
        }
        
        private String login(HttpServletRequest request, HttpServletResponse response){
            //  verifica se o usuario está logado
            boolean bEstaLogado = getEstaLogado(request);
                        
            if(!bEstaLogado){
                String sEmail = request.getParameter("email");
                String sPassword = request.getParameter("password");            
                Jogador jogador = ConexaoJogador.getTemLoginJogador(sEmail, sPassword);

                if(jogador != null){
                // se tem jogador então tem que enviar os dados para a tela de edição
                    HttpSession session = request.getSession();
                    if(jogador.isBadministrador()){
                        session.setAttribute("jogadoradministrador", true);    
                    }
                    session.setAttribute("jogadorlogado", jogador);
                    
                    session.setAttribute("loginlogout", true);

                    request.setAttribute("jogador", jogador);
                    return "aftersuccess.jsp";
                }
                //  Ele estava retornado direto para a pagina de erro
                //  pois pegava o login.jsp sem nada
                return "login.jsp";            
            }
            
            return "aftersuccess.jsp";
        }
        private void procurarjogador(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String sNomeJogador = request.getParameter("nomejogador");            
        Jogador jogador = ConexaoJogador.getJogador(sNomeJogador);
        
        PrintWriter out = response.getWriter();    
        // local de download https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.1/
        Gson gson = new Gson();
        
//        if(jogador == null){
//            out.print(gson.toJson(jogador));
//        }else{
            //request.setAttribute("nomedojogadoretorno", jogador.getSnome());
            
            out.print(gson.toJson(jogador));
//        }                
        //out.flush();
        //out.close();        
    }    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);     
        
            
           
    }

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
