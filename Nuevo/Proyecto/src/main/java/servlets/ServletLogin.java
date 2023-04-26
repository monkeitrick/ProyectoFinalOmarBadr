package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.ClienteDAO;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private ClienteDAO cdao = new ClienteDAO();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("cerrar") != null) { 
			request.getSession().invalidate();
			request.getSession().setAttribute("mensaje", "Has cerrado sesión correctamente.");
			response.sendRedirect("login.jsp");  
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("login") != null) {
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			Usuario user = cdao.buscaCliente(email, pass);
			if (user == null) {
				request.getSession().setAttribute("mensaje", "El email o contraseña introducido incorrecto. Rellene los campos nuevamente.");
				response.sendRedirect("login.jsp");  
			}else {
				request.getSession().setAttribute("usuario", user); 
				if (user.getAdmin() == true) {
					request.getSession().setAttribute("esAdmin", "si"); 
					response.sendRedirect("listadoUsuarios.jsp");   
				}
				else
					response.sendRedirect("listadoProductos.jsp"); 
			} 
		}
	}
}
