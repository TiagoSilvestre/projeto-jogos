package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->        \n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>        \n");
      out.write("        \n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/simple-sidebar.css\">        \n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Aspiraboo</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div style=\"background:url(imagens/castelo.jpg); height: 200px; background-size: 100%;\"></div>\n");
      out.write("        <header class=\"bs-docs-header\" style=\"background-color: black; height: 10px;\">     \n");
      out.write("        <div id=\"wrapper\" class=\"toggled\">            \n");
      out.write("            <!-- Sidebar -->\n");
      out.write("            <div id=\"sidebar-wrapper\">                \n");
      out.write("                <ul class=\"sidebar-nav\">\n");
      out.write("                    <li class=\"sidebar-brand\" style=\"font-size: 28px;color: white;\">                        \n");
      out.write("                        Lista de Opções\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"sidebar-brand\">                        \n");
      out.write("                        <!--<a href=\"#\" onclick=\"paginaJogador('cadastrojogador.jsp')\">Cadastro de Jogador</a>\n");
      out.write("                        -->\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginlogout == null ? \"cadastrojogador\" : \"minhaconta\" }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginlogout == null ? \"Cadastro de Jogador\" : \"Minha conta\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>                        \n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"sidebar-brand\">                        \n");
      out.write("                        <!--\n");
      out.write("                        <a href=\"#\" onclick=\"paginaJogador('login.jsp')\">Login</a>\n");
      out.write("                        -->\n");
      out.write("                        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginlogout == null ? \"login\" : \"logout\" }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginlogout == null ? \"login\" : \"logout\" }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    </li>                    \n");
      out.write("                    <li class=\"sidebar-brand\">                        \n");
      out.write("                        <a href=\"#\" onclick=\"paginaJogador('procurarjogador.jsp')\">Procurar Jogador</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"sidebar-brand\">\n");
      out.write("                        <a href=\"listarjogador\">Listar Todos</a>\n");
      out.write("                    </li>            \n");
      out.write("                    <li class=\"sidebar-brand\">\n");
      out.write("                        <a href=\"#\" onClick=\"paginaJogador('bibliografia.jsp')\">Bibliografia</a>\n");
      out.write("                    </li>                                \n");
      out.write("                </ul>                \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!-- Onde vai ser carregado as paginas -->\n");
      out.write("            <div id=\"page-content-wrapper\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("                        <div id=\"opcoesJogador\">\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>    \n");
      out.write("        <footer id=\"rodape\">\n");
      out.write("            <center>\n");
      out.write("                By aspiraboo    \n");
      out.write("            </center>                    \n");
      out.write("        </footer>           \n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        //  Usado para carregar uma pagina JSP ou um trecho de codigo html\n");
      out.write("        function paginaJogador(pagina){\n");
      out.write("            if (pagina.indexOf('.jsp') > 0){                \n");
      out.write("                $(\"#opcoesJogador\").load(pagina);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            //  Para carregar um html dentro de um elemento tem que usar esse js.            \n");
      out.write("            // $('.opcoesJogador').append($('.nomepadrao').html());\n");
      out.write("            \n");
      out.write("            // vai remover a div, como não está atualizando a pagina inteira\n");
      out.write("            //  tem que remover o elemento\n");
      out.write("            $('div').remove('.nomepadrao');            \n");
      out.write("        }\n");
      out.write("\n");
      out.write("        $(function() {          \n");
      out.write("            // Quando se carrega um novo jsp, ele coloca o codigo html ao final da pagina\n");
      out.write("            // então é necessario mover ele            \n");
      out.write("          $(\".nomepadrao\").appendTo(\"#opcoesJogador\");\n");
      out.write("        });\n");
      out.write("\n");
      out.write("    </script>    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
