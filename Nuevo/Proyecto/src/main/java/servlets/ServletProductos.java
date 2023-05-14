package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.VideoJuego;
import dao.JuegosDAO;


public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JuegosDAO bdJuegos;
    
	 @Override
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       bdJuegos = new JuegosDAO();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("lstJuegos")!=null) {
			String idString=  request.getParameter("borrar");
			Integer id= Integer.valueOf(idString);
			VideoJuego v= new VideoJuego();
			v.setIdJuego(id);
			ArrayList<VideoJuego> arr=(ArrayList<VideoJuego>) request.getSession().getAttribute("lstJuegos");
			arr.remove(v);
			request.getSession().setAttribute("lstJuegos", arr);
			request.getRequestDispatcher("listadoProductos.jsp").forward(request, response);
		}
		if(request.getSession().getAttribute("lstJuegos") == null) {
			request.getSession().setAttribute("lstJuegos", bdJuegos.juegosBBDD());
		}
		if (request.getSession().getAttribute("esAdmin") != null) {
			if(request.getSession().getAttribute("esAdmin").equals("si")) {
		        request.getRequestDispatcher("listadoProductos.jsp").forward(request, response);
			}
		}
        response.sendRedirect("listadoProductos.jsp");
	}

}
