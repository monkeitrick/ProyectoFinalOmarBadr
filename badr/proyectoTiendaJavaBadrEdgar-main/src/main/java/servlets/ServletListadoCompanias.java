package servlets;

import beans.Compania;
import beans.Usuario;
import dao.ClienteDAO;
import dao.CompaniaDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletListadoCompanias extends HttpServlet {

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
    if (request.getParameter("obtenerCompanias") == null) {
      response.sendRedirect("html/listadoDeCompanias.jsp");
    } else {
      CompaniaDAO cd = new CompaniaDAO();
      ArrayList<Compania> companias = cd.listarCompanias();
      request.getSession().setAttribute("companias", companias);
      response.sendRedirect("html/listadoDeCompanias.jsp");
    }
  }
}
