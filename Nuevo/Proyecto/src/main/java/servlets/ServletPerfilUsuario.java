package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Compra;
import beans.Usuario;
import dao.ClienteDAO;

/**
 * Servlet implementation class ServletCompanias
 */
public class ServletPerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO bdCliente;
    
	 @Override
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       bdCliente = new ClienteDAO();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("idUser") != null) {
		    int idUser = Integer.parseInt(request.getParameter("idUser"));
            Usuario user = bdCliente.buscaClientePorID(idUser);
            ArrayList<Compra> comprasUsuario = bdCliente.obtenerComprasUsuarioPorId(idUser);
            request.getSession().setAttribute("comprasUsuario", comprasUsuario);
            request.getSession().setAttribute("datosUsuario", user);
            request.getRequestDispatcher("perfil.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}