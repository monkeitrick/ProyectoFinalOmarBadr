package servlets;

import beans.Compra;
import beans.Usuario;
import dao.ClienteDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPerfilUSuario
 */
public class ServletPerfilUsuario extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ServletPerfilUsuario() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    if (request.getParameter("idUser") != null) {
      ClienteDAO cDao = new ClienteDAO();
      int idUser = Integer.parseInt(request.getParameter("idUser"));
      Usuario user = cDao.buscaClientePorID(idUser);
      ArrayList<Compra> comprasUsuario = cDao.obtenerComprasUsuarioPorId(
        idUser
      );
      request.getSession().setAttribute("comprasUsuario", comprasUsuario);
      request.getSession().setAttribute("datosUsuario", user);
      response.sendRedirect("html/perfilUsuario.jsp");
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}
