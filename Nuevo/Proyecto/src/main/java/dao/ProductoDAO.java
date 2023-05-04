package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.sql.DataSource;


import beans.VideoJuego;
import conex.BDConex;

public class ProductoDAO {
	private BDConex bdConex;
	  private DataSource ds;
	  private Connection con;

	  public ProductoDAO() throws ServletException {
	    bdConex = new BDConex();
	    ds = bdConex.getDs();
	  }
	
	// Metodo que lista todos los productos que hay
	public ArrayList<VideoJuego> lstProductos() {
		ArrayList<VideoJuego> lstproductos = new ArrayList<VideoJuego>();
		 try{    
			 	String sql = "SELECT * FROM Videojuegos";              		         
			 	con = ds.getConnection();
			    PreparedStatement ps = con.prepareStatement(sql);
			    ResultSet rs = ps.executeQuery();          
	            while(rs.next()) { 
	            	VideoJuego p = new VideoJuego();
	            	p.setIdJuego(rs.getInt("idJuego"));
	            	p.setTitulo(rs.getString("titulo"));
	            	p.setDescripcion(rs.getString("descripcion"));
	            	p.setPrecio(rs.getDouble("precio"));
	            	lstproductos.add(p);
	            }
	            rs.close();
	            con.close();
	         }
	         catch (Exception e)  {
	             System.err.println("Error en lstProductos: " + e);
	         } 
		 return lstproductos;
	}
	
	// Metodo que elimina un producto pasado por id
	public void borrarProducto (int id){
		try{    
            String sql="DELETE FROM videojuegos WHERE idJuego=?";
            con = ds.getConnection();
		    PreparedStatement ps = con.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.err.println("Error en metodo borrarProducto: " + ex);
        }
	}
}
