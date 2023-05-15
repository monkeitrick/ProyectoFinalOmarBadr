package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.ClienteDAO;

/**
 * Servlet implementation class ServletRegistro
 */
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO cdao = new ClienteDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario(request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("email"), request.getParameter("pass1"), false);
		boolean todoBn = cdao.guardarCliente(u);
		if (todoBn == true) {
			request.getSession().setAttribute("mensaje", "Se ha registrado correctamente, itroduzca el email y la contraseña para acceder.");
			response.sendRedirect("login.jsp");  
		}else {
			request.getSession().setAttribute("mensaje", "ERROR: Contacte con el servicio tecnico.");
			response.sendRedirect("login.jsp");  
		}
	}
}

