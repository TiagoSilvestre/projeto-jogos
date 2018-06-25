/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.conn_Jogador;
import modelo.Jogador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tiago Silvestre
 */
@WebServlet(name = "ControlerJogador", urlPatterns = {"/cadastrojogador", "/acaocadastrar", "/procurarjogador", "/salvaredicaojogador", "/listarjogador", "/logout", "/minhaconta", "/editarjogador", "/excluir"})
public class ControllerJogador extends HttpServlet {

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

        if (uri.endsWith("cadastrojogador")) {
            jsp = cadastrojogador(request, response);
        } else if (uri.endsWith("listarjogador")) {
            jsp = listarjogador(request);
        } else if (uri.endsWith("acaocadastrar")) {
            jsp = acaocadastrar(request, response);

        } else if (uri.endsWith("salvaredicaojogador")) {
            jsp = salvaredicaojogador(request);
        } else if (uri.endsWith("editarjogador")) {
            jsp = editarjogador(request);
        } else if (uri.endsWith("excluir")) {
            jsp = excluirjogador(request);
        }
        if (jsp != null) {
            request.getRequestDispatcher(jsp).forward(request, response);
        }

        response.sendRedirect("/");

    }

    private String excluirjogador(HttpServletRequest request) {
        String sNomeJogador = request.getParameter("nome");
        Jogador jogador = conn_Jogador.getJogador(sNomeJogador);
        conn_Jogador.excluirJogador(jogador);
        return "listarjogador";
    }

    private String editarjogador(HttpServletRequest request) {
        if (request.getParameter("nomepersonagem") == null || request.getParameter("email") == null || request.getParameter("password") == null) {
            return "listagem.jsp";
        }
        String sNomeJogador = request.getParameter("nomepersonagem");
        Jogador jogador = conn_Jogador.getJogador(sNomeJogador);

        jogador.setSemail(request.getParameter("email"));
        jogador.setSpassword(request.getParameter("password"));

        conn_Jogador.updateJogador(jogador);
        return "listarjogador";
    }

    private String listarjogador(HttpServletRequest request) {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores = conn_Jogador.getJogadores(jogadores);
        request.setAttribute("listajogadores", jogadores);
        return "listarjogador.jsp";
    }

    private String salvaredicaojogador(HttpServletRequest request) {
        if (request.getParameter("nomepersonagem") == null) {
            return "paginaerro.jsp";
        }
        String sNome = request.getParameter("nomepersonagem");

        Jogador jogador = conn_Jogador.getJogador(sNome);

        if (jogador == null) {
            return "paginaerro.jsp";
        }

           jogador.setSpassword(jogador.getSpassword());
          jogador.setSemail(jogador.getSemail());
          jogador = conn_Jogador.updateJogador(jogador);
//          necessario para verificar se deu algum erro no update
        request.setAttribute("jogador", jogador);
        return "aftersuccess.jsp";
    }

    private String cadastrojogador(HttpServletRequest request, HttpServletResponse response) {
        return "cadastrojogador.jsp";

    }

    private String acaocadastrar(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter("nomepersonagem") == null || request.getParameter("email") == null || request.getParameter("password") == null) {
            return "listagem.jsp";
        }
        String sNomePersonagem = request.getParameter("nomepersonagem");
        String sEmail = request.getParameter("email");
        String sPassword = request.getParameter("password");

        Jogador jogador = new Jogador();
        jogador.setDdatecriacao(new Date());

        jogador.setSnome(sNomePersonagem);
        jogador.setSemail(sEmail);
        jogador.setSpassword(sPassword);

        System.out.println(jogador);

        jogador = conn_Jogador.insert(jogador);
        if (jogador == null) {
            return "paginaerro.jsp";
        }

        return "cadastrojogador.jsp";
    }

    private String acaoCadastrojogador(HttpServletRequest request, HttpServletResponse response) {
        //  dados incompletos
        if (request.getParameter("nomepersonagem") == null || request.getParameter("email") == null || request.getParameter("password") == null) {
            //     return "listagem.jsp";
        }
        String sNomePersonagem = request.getParameter("nomepersonagem");
        String sEmail = request.getParameter("email");
        String sPassword = request.getParameter("password");

        Jogador jogador = conn_Jogador.getJogador(sNomePersonagem);
        if (jogador == null) {
            jogador = new Jogador();
            jogador.setDdatecriacao(new Date());
        }

        jogador.setSnome(sNomePersonagem);
        jogador.setSemail(sEmail);
        jogador.setSpassword(sPassword);

        jogador = conn_Jogador.insert(jogador);
        if (jogador == null) {
            return "paginaerro.jsp";
        }

        request.setAttribute("jogador", jogador);

        return "listarjogador.jsp";
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
