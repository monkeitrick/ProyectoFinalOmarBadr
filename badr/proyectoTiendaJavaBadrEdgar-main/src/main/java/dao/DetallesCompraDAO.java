package dao;

import beans.Compra;
import beans.Imagen;
import beans.LineaPedido;
import beans.VideoJuego;
import conex.BDConex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class DetallesCompraDAO {

  private BDConex bdConex;
  private DataSource ds;
  private Connection con;

  // con = ds.getConnection();

  public DetallesCompraDAO() throws ServletException {
    bdConex = new BDConex();
    ds = bdConex.getDs();
  }

  public ArrayList<LineaPedido> obtenerLineasDePedidoPorId(int id) {
    ArrayList<LineaPedido> arrLineasPedido = new ArrayList<LineaPedido>();
    String sql =
      "select idLineaPedido, cantidad, id_juego from lineapedido where id_compra= ?";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        LineaPedido lp = new LineaPedido();
        int idLineaPedido = rs.getInt("idLineaPedido");
        int cantidad = rs.getInt("cantidad");
        int id_juego = rs.getInt("id_juego");
        VideoJuego vid = obtenerJuegoPorId(id_juego);
        lp.setCantidad(cantidad);
        lp.setIdLineaPedido(idLineaPedido);
        lp.setJuego(vid);
        arrLineasPedido.add(lp);
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return arrLineasPedido;
  }

  public VideoJuego obtenerJuegoPorId(int id) {
    VideoJuego v = new VideoJuego();
    String sql =
      "select videojuegos.titulo, videojuegos.precio, imagen.ruta from videojuegos, imagen where idJuego=? and videojuegos.id_imgCover = imagen.idImagen";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        String titulo = rs.getString("videojuegos.titulo");
        double precio = rs.getDouble("videojuegos.precio");
        String ruta = rs.getString("imagen.ruta");
        Imagen img = new Imagen(0, ruta);
        v.setImgCover(img);
        v.setTitulo(titulo);
        v.setPrecio(precio);
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return v;
  }
}
