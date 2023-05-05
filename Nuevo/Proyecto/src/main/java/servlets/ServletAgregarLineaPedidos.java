package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import beans.VideoJuego;
import dao.PedidoDAO;
import dao.ProductoDAO;

/**
 * Servlet implementation class ServletAgregarLineaPedidos
 */
public class ServletAgregarLineaPedidos extends HttpServlet {
	private PedidoDAO bdPedido;
	private ProductoDAO bdProductos;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        bdPedido = new PedidoDAO();
        bdProductos = new ProductoDAO();
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
		if(request.getParameter("aniadir")!=null) {
			String idString=  request.getParameter("aniadir");
			Integer id= Integer.valueOf(idString);
			VideoJuego v= new VideoJuego();
			v.setIdJuego(id);
			ArrayList<VideoJuego> arr=(ArrayList<VideoJuego>) request.getSession().getAttribute("lstJuegos");
			int i=arr.indexOf(v);
			VideoJuego vReal=arr.get(i);
			Integer cantidad=0;
			String continuar="si";
			if(!request.getParameter(idString).equals("") && Integer.valueOf(request.getParameter(idString))>0) {
				cantidad= Integer.valueOf(request.getParameter(idString));
			}
			else {
				request.getSession().setAttribute("mensajeError", "La cantidad es inferior o igual a 0");
				continuar="no";
			}
			if(continuar=="si") {
				if(request.getSession().getAttribute("carro") == null) {
					ArrayList<VideoJuego> arrJuegos=new  ArrayList<VideoJuego>();
					vReal.setCantidad(cantidad);
					arrJuegos.add(vReal);
					request.getSession().setAttribute("carro", arrJuegos);
				}
				else {
					ArrayList<VideoJuego> arrJuegos= (ArrayList<VideoJuego>) request.getSession().getAttribute("carro");
					if(arrJuegos.contains(vReal)) {
						int index=arrJuegos.indexOf(vReal);
						cantidad=arrJuegos.get(index).getCantidad()+cantidad;
						arrJuegos.remove(index);
						vReal.setCantidad(cantidad);
						arrJuegos.add(vReal);
					}
					else {
						vReal.setCantidad(cantidad);
						arrJuegos.add(vReal);
					}
					request.getSession().setAttribute("carro", arrJuegos);
				}
			}
			response.sendRedirect("listadoProductos.jsp");
		}
		else {
			if(request.getParameter("detalles")!=null) {
				Integer idString=  Integer.valueOf(request.getParameter("detalles"));
				VideoJuego v= new VideoJuego();
				v.setIdJuego(idString);
				ArrayList<VideoJuego> arr=(ArrayList<VideoJuego>) request.getSession().getAttribute("lstJuegos");
				int i=arr.indexOf(v);
				VideoJuego vReal=arr.get(i);
				request.getSession().setAttribute("juego", vReal);
				response.sendRedirect("detallesProducto.jsp");
			}else {
				if(request.getParameter("verCesta")!=null) {
					if(request.getSession().getAttribute("carro") == null) {
						request.getSession().setAttribute("mensajeError", "No hay ningun producto en la cesta");
						response.sendRedirect("listadoProductos.jsp");
					}
					else {
						response.sendRedirect("carro.jsp");
					}
				}
			}
		}
			
	}

}
