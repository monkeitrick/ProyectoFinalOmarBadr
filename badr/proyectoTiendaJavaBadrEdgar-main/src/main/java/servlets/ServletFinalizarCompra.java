package servlets;

import beans.LineaPedido;
import beans.Usuario;
import dao.FinalizarCompraDAO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFinalizarCompra extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public ServletFinalizarCompra() {
    super();
  }

  protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    if (request.getParameter("total") != null) {
      double total = Double.parseDouble(request.getParameter("total"));
      response.sendRedirect("html/finalizarCompra.jsp?total=" + total);
    } 
    else {
      Double total = Double.valueOf(request.getParameter("compraTotal"));
      if (request.getParameter("pagar") != null) {
        FinalizarCompraDAO fc = new FinalizarCompraDAO();
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
        fc.CrearCompra(u.getIdUser(), total);
        HashMap<Integer, LineaPedido> carrito = (HashMap<Integer, LineaPedido>) request.getSession().getAttribute("carrito");
        Iterator<Integer> it = carrito.keySet().iterator();
        while (it.hasNext()) {
          Integer idJuego = it.next();
          LineaPedido lp = carrito.get(idJuego);
          fc.CrearLineaPedido(lp.getCantidad(), idJuego);
        }
        request.getSession().removeAttribute("carrito");
        response.sendRedirect("html/compraFinalizada.jsp");
        //				}
      } else {
        response.sendRedirect("index.jsp");
      }
    }
  }
}
