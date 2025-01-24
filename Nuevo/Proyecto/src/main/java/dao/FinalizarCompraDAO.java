 package dao;

import conex.BDConex;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class FinalizarCompraDAO {

  private BDConex bdConex;
  private DataSource ds;
  private Connection con;

  public FinalizarCompraDAO() throws ServletException {
    bdConex = new BDConex();
    ds = bdConex.getDs();
  }

  private static final String capitalize(String str) {
    if (str == null || str.length() == 0) return str;

    return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
  }

  // Metodo que devuelve el ultimo id de la tabla compras de la BBDD; en caso de estar vacia devuelve 0
  public int IdMasGrande() {
    String sql = "select max(idCompra) from compra";
    int id = 0;
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery(sql);
      if (rs.next()) {
        id = rs.getInt("max(idCompra)");
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return id;
  }

  // Metodo que crea una Compra pasandole un id del Usuario que hace la compra y el total de esta
  public void CrearCompra(int idUsuario, double total) {
    int idCompra = IdMasGrande();
    if (idCompra == 0) {
      idCompra = 1;
    } else {
      idCompra += 1;
    }
    String sql =
      "INSERT INTO compra (idCompra, fecha, total, id_usuario) VALUES (?,?, ?, ?);";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idCompra);
      ps.setDate(2, new Date(System.currentTimeMillis()));
      ps.setDouble(3, total);
      ps.setInt(4, idUsuario);
      ps.executeUpdate();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
  }

  

}
