package servlets;

import beans.LineaPedido;
import beans.VideoJuego;
import dao.DetallesCompraDAO;
import dao.JuegosDAO;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDetallesCompra extends HttpServlet {

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
    if (request.getParameter("id") != null) {
      DetallesCompraDAO dc = new DetallesCompraDAO();
      Integer id = Integer.valueOf(request.getParameter("id"));
      request
        .getSession()
        .setAttribute("lineasPedido", dc.obtenerLineasDePedidoPorId(id));
      response.sendRedirect("html/detallesCompra.jsp");
    } else {
      response.sendRedirect("index.jsp");
    }
  }
}
