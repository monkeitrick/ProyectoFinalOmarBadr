package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import beans.VideoJuego;
import conex.BDConex;

public class PedidoDAO {
	private BDConex bdConex;
	  private DataSource ds;
	  private Connection con;

	  public PedidoDAO() throws ServletException {
	    bdConex = new BDConex();
	    ds = bdConex.getDs();
	  }
	// Metodo buscaProductoPorId devuelve el producto cuyo id se recibe como parametro o null
	public VideoJuego buscaProductoPorId(int idproducto) {
		VideoJuego producto = new VideoJuego();
		String sql = "SELECT * FROM producto WHERE id = ?";
        try {
        	con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idproducto);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	producto.setIdJuego(idproducto);
            	producto.setTitulo(rs.getString("titulo"));
            	producto.setDescripcion(rs.getString("descripcion"));
            	producto.setPrecio(rs.getDouble("precio"));
            }
            rs.close();
            con.close();
        }
        catch (SQLException ex) {
            System.err.println("Error en metodo buscaProductoPorId: " + ex);
        }
		return producto;
	}
}
