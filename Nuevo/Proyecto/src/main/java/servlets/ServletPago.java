package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import beans.VideoJuego;
import dao.ClienteDAO;
import dao.FinalizarCompraDAO;

/**
 * Servlet implementation class ServletRegistro
 */
public class ServletPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO cdao = new ClienteDAO();

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
		if(request.getParameter("pagar")!=null) {
			ArrayList<VideoJuego> arrvid = (ArrayList<VideoJuego>) request.getSession().getAttribute("carro");
			double total=0;
			for (VideoJuego videoJuego : arrvid) {
				total+=videoJuego.getPrecio()*videoJuego.getCantidad();
			}
			FinalizarCompraDAO fc= new FinalizarCompraDAO();
			Usuario Usuario=(beans.Usuario) request.getSession().getAttribute("usuario");
			fc.CrearCompra(Usuario.getIdUser(), total);
			request.getSession().removeAttribute("carro");
			response.sendRedirect("compraFinalizada.jsp");
		}
	}
}

