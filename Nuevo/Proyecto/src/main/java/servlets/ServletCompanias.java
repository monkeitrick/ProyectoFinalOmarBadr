package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Compania;
import beans.Imagen;
import dao.CompaniaDAO;
import dao.ImagenDAO;

/**
 * Servlet implementation class ServletCompanias
 */
public class ServletCompanias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompaniaDAO bdCompania;
	private ImagenDAO bdImagen;
    
	 @Override
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       bdCompania = new CompaniaDAO();
       bdImagen = new ImagenDAO();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// En caso de no existir un array de todas las companias, lo crea y redirige a listadoCompanias
		if(request.getSession().getAttribute("lstCompanias") == null) {
			request.getSession().setAttribute("lstCompanias", bdCompania.listarCompanias());
		} 
        request.getRequestDispatcher("listadoCompanias.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// En caso de querer editar una compania, crea un objeto de esta para modificarlo en modificarCompania
	    if(request.getParameter("editar") != null) {
	    	Compania compania = bdCompania.obtenerCompaniaPorId(Integer.parseInt(request.getParameter("editar")));
	    	Imagen imagen = compania.getImg();
			request.getSession().setAttribute("compania", compania);
			request.getSession().setAttribute("imagen", imagen);
	        request.getRequestDispatcher("modificarCompania.jsp").forward(request, response);
		} 

	    // Si desea confirmar la modificacion, la cambia en la BBDD
	    if(request.getParameter("modificar") != null) {
	    	bdCompania.modificarCompania(request.getParameter("idCompania"), request.getParameter("idImagen"), request.getParameter("ruta"), request.getParameter("nombre"), request.getParameter("enlace"));
	    }
	    
	    // Redirige a listadoCompanias
	    request.getSession().setAttribute("lstCompanias", bdCompania.listarCompanias());
		doGet(request, response);
	}

}
