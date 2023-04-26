package dao;

import beans.Compania;
import beans.Imagen;
import beans.Usuario;
import conex.BDConex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class CompaniaDAO {

  private BDConex bdConex;
  private DataSource ds;
  private Connection con;

  public CompaniaDAO() throws ServletException {
    bdConex = new BDConex();
    ds = bdConex.getDs();
  }

  private static final String capitalize(String str) {
    if (str == null || str.length() == 0) return str;

    return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
  }

  // Metodo que devuelove la compania pasandole un id
  public Compania obtenerCompaniaPorId(int id) {
    Compania compania = null;
    String sql = "SELECT * FROM compania where idCompania = ?";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) compania =
        new Compania(id, rs.getString("nombre"), rs.getString("enlaceOficial"));
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return compania;
  }
  
  // Metodo para modificar una compañia
  public void modificarCompania(String idCompania, String idImagen, String ruta, String nombre, String enlaceOficial) {
	  modificarImagenCompania(idImagen, ruta);
      String sql = "UPDATE compania SET nombre = ?, enlaceOficial = ? WHERE idCompania = ?";
      try {
          con = ds.getConnection();
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, nombre);
          ps.setString(2, enlaceOficial);
          ps.setString(3, idCompania);
          ps.executeUpdate();
          ps.close();
          con.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  
//Metodo para modificar la imagen de una compañia
 public void modificarImagenCompania(String idImagen, String ruta) {
     String sql = "UPDATE imagen SET ruta = ? WHERE idImagen = ?";
     try {
         con = ds.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setString(1, ruta);
         ps.setString(2, idImagen);
         ps.executeUpdate();
         ps.close();
         con.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

  // Metdod que devuelve un listad e todas las companias
  public ArrayList<Compania> listarCompanias() {
    ArrayList<Compania> companias = new ArrayList<Compania>();
    String sql =
      "select compania.idCompania, compania.nombre, compania.enlaceOficial, imagen.ruta from compania, imagen where compania.idImagen= imagen.idImagen";
    try {
      con = ds.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        int idCompania = rs.getInt("compania.idCompania");
        String nombre = capitalize(rs.getString("compania.nombre"));
        String enlaceOficial = capitalize(
          rs.getString("compania.enlaceOficial")
        );
        String ruta = rs.getString("imagen.ruta");
        Imagen img = new Imagen(0, ruta);
        Compania c = new Compania();
        c.setEnlaceOficial(enlaceOficial);
        c.setId(idCompania);
        c.setNombre(nombre);
        c.setImagen(img);
        companias.add(c);
      }

      rs.close();
      st.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return companias;
  }
}
