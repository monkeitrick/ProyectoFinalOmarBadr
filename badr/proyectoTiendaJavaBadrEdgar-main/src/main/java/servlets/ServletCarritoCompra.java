package servlets;

import beans.LineaPedido;
import beans.VideoJuego;
import dao.JuegosDAO;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCarritoCompra
 */
public class ServletCarritoCompra extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ServletCarritoCompra() {}

  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    if (request.getParameter("vaciarCarrito") != null) {
      request.getSession().removeAttribute("carrito");
      response.sendRedirect("index.jsp?Z2FycmlMb3ZlVQ");
    } else {
      if (request.getParameter("cambiarCantidad") != null) {
        HashMap<Integer, LineaPedido> carrito = obtenerCarritoDeSesion(request);
        int idJuego = Integer.parseInt(request.getParameter("idJuego"));
        int nuevaCantidad;
        if (request.getParameter("cantidad" + idJuego) != "") nuevaCantidad =
          Integer.parseInt(
            request.getParameter("cantidad" + idJuego)
          ); else nuevaCantidad = 0;
        if (nuevaCantidad != 0) {
          LineaPedido lp = carrito.get(idJuego);
          lp.setCantidad(nuevaCantidad);
          carrito.put(idJuego, lp);
        } else {
          carrito.remove(idJuego);
        }
        request.getSession().setAttribute("carrito", carrito);
        response.sendRedirect("html/carrito.jsp");
      } else {
        if (request.getParameter("eliminarTodaLaCantidad") != null) {
          HashMap<Integer, LineaPedido> carrito = obtenerCarritoDeSesion(
            request
          );
          int idJuego = Integer.parseInt(request.getParameter("idJuego"));
          carrito.remove(idJuego);
          request.getSession().setAttribute("carrito", carrito);
          response.sendRedirect("html/carrito.jsp");
        } else {
          if (
            request.getParameter("idJuego") != null &&
            request.getParameter("idJuego") != ""
          ) {
            /* Obtener juego */
            int idJuego = Integer.parseInt(request.getParameter("idJuego"));
            JuegosDAO jDao = new JuegosDAO();
            VideoJuego juego = jDao.obtenerJuegoPorId(idJuego);

            if (estaLaSesionIniciada(request)) {
              HashMap<Integer, LineaPedido> carrito = obtenerCarritoDeSesion(
                request
              );
              LineaPedido lp = null;
              if (carrito == null) {
                carrito = new HashMap<Integer, LineaPedido>();
                lp = new LineaPedido(1, juego);
                carrito.put(idJuego, lp);
              } else {
                if (carrito.containsKey(idJuego)) {
                  lp = carrito.get(idJuego);
                  lp.setCantidad(lp.getCantidad() + 1);
                } else {
                  lp = new LineaPedido(1, juego);
                }
                carrito.put(idJuego, lp);
              }
              request.getSession().setAttribute("carrito", carrito);
              response.sendRedirect(
                "ServletJuego?idJuego=" + idJuego + "&aniadido"
              );
            } else response.sendRedirect(
              "ServletJuego?idJuego=" + idJuego + "&noSession"
            );
          } else {
            response.sendRedirect("index.jsp");
          }
        }
      }
    }
  }

  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    doGet(request, response);
  }

  private HashMap<Integer, LineaPedido> obtenerCarritoDeSesion(
    HttpServletRequest request
  ) {
    HashMap<Integer, LineaPedido> carrito = null;
    if (request.getSession().getAttribute("carrito") != null) carrito =
      (HashMap<Integer, LineaPedido>) request
        .getSession()
        .getAttribute("carrito");
    return carrito;
  }

  private boolean estaLaSesionIniciada(HttpServletRequest request) {
    if (request.getSession().getAttribute("usuario") != null) return true;
    return false;
  }
}
