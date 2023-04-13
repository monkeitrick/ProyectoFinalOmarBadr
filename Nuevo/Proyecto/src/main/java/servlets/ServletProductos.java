package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JuegosDAO;

/**
 * Servlet implementation class servletProductos
 */

public class ServletProductos extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JuegosDAO bdJuegos;
    
	 @Override
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       bdJuegos = new JuegosDAO();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("lstJuegos") == null) {
			request.getSession().setAttribute("lstJuegos", bdJuegos.juegosBBDD());
		}
		if (request.getSession().getAttribute("esAdmin") != null) {
			if(request.getSession().getAttribute("esAdmin").equals("si"))
		        request.getRequestDispatcher("listadoProductosAdmin.jsp").forward(request, response);
		} 
        request.getRequestDispatcher("listadoProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Double precio = Double.parseDouble(request.getParameter("precio"));
		String categoria = request.getParameter("categoria");
		if(nombre.equals("") || descripcion.equals("") || categoria.equals("") || precio>0) {
			request.setAttribute("mensajeError", "Debes de rellenar todas las casillas");
			request.getRequestDispatcher("aniadirProducto.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("listadoProductosAdmin.jsp").forward(request, response);
	}

}
