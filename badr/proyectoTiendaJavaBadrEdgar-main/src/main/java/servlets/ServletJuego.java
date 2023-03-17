package servlets;

import beans.VideoJuego;
import dao.JuegosDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletJuego extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ServletJuego() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    JuegosDAO jDao = new JuegosDAO();
    VideoJuego juego = jDao.obtenerJuegoPorId(
      Integer.parseInt(request.getParameter("idJuego"))
    );
    if (juego != null) {
      request.getSession().setAttribute("juego", juego);
      if (request.getParameter("noSession") == null) {
        if (request.getParameter("aniadido") == null) response.sendRedirect(
          "html/videojuegos.jsp?aWxsb2p1YW4gTWFuZGE"
        ); else response.sendRedirect(
          "html/videojuegos.jsp?aWxsb2p1YW4gTWFuZGE&bG1kc2hvdw"
        );
      } else response.sendRedirect(
        "html/videojuegos.jsp?aWxsb2p1YW4gTWFuZGE&w4Fsb1ByZXNpZGVudGU"
      );
    } else {
      response.sendRedirect("index.jsp");
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
