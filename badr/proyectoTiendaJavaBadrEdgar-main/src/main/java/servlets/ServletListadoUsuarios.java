package servlets;

import beans.Usuario;
import dao.ClienteDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletListadoUsuarios extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    if (request.getParameter("obtenerUsuarios") == null) {
      response.sendRedirect("html/listadoDeUsuarios.jsp");
    } else {
      ClienteDAO cd = new ClienteDAO();
      ArrayList<Usuario> usuarios = cd.listarUsuarios();
      request.getSession().setAttribute("usuarios", usuarios);
      response.sendRedirect("html/listadoDeUsuarios.jsp");
    }
  }
}
