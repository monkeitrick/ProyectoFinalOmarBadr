package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompaniaDAO;

/**
 * Servlet implementation class ServletCompanias
 */
public class ServletCompanias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompaniaDAO bdCompania;
    
	 @Override
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       bdCompania = new CompaniaDAO();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("lstCompanias") == null) {
			request.getSession().setAttribute("lstCompanias", bdCompania.listarCompanias());
		} 
        request.getRequestDispatcher("listadoCompanias.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
