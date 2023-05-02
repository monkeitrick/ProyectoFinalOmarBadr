package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LineaPedido;
import dao.DetallesCompraDAO;

/**
 * Servlet implementation class ServletDetallesCompra 
 */
public class ServletDetallesCompra  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetallesCompraDAO dcDAO;
    
    @Override
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       dcDAO = new DetallesCompraDAO ();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null) {;
            Integer id = Integer.valueOf(request.getParameter("id"));
            request.getSession().setAttribute("lineasPedido", dcDAO.obtenerLineasDePedidoPorId(id));
            response.sendRedirect("detallesCompra.jsp");
        } 
        else {
            response.sendRedirect("perfilUsuario.jsp");
        }
	}
}