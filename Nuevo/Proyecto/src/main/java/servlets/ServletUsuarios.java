package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.ClienteDAO;

/**
 * Servlet implementation class ServletUsuarios
 */
public class ServletUsuarios extends HttpServlet {
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
        // Comprueba si se ha pulsaod el boton borrar y hace lo pertinente
        if (request.getParameter("BorrarUsuario") != null) {
            if(bdCliente.borrarUsuario(Integer.parseInt(request.getParameter("BorrarUsuario"))))
                request.getSession().setAttribute("mensaje", "Se ha eliminado el usuario correctamente.");
            else
                request.getSession().setAttribute("mensaje", "No se ha podido eliminar el usuario correctamente.");
        }

        // Crear los arrays de listado de Usuarios y Administradores
		if(request.getSession().getAttribute("lstUsuarios") == null) {
            ArrayList<Usuario> lstTodosUsuarios = bdCliente.listarUsuarios();
            ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario>();
            ArrayList<Usuario> lstAdmins = new ArrayList<Usuario>();
			for(Usuario usuario : lstTodosUsuarios){
                if(usuario.getAdmin())
                    lstAdmins.add(usuario);
                else
                	lstUsuarios.add(usuario);
            }
            request.getSession().setAttribute("lstUsuarios", lstUsuarios);
            request.getSession().setAttribute("lstAdmins", lstAdmins);
		}

        // Redirigimos a la vista de Listado de Usuarios
        request.getRequestDispatcher("listadoUsuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}