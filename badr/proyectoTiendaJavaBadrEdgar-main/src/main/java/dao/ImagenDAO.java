package dao;

import beans.Imagen;
import conex.BDConex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class ImagenDAO {

  private BDConex bdConex;
  private DataSource ds;
  private Connection con;

  // con = ds.getConnection();

  public ImagenDAO() throws ServletException {
    bdConex = new BDConex();
    ds = bdConex.getDs();
  }

  public Imagen obtenerImagenPorId(int id) {
    Imagen img = null;
    String sql = "SELECT * FROM imagen where idImagen = ?";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) img = new Imagen(id, rs.getString("ruta"));
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return img;
  }
}
