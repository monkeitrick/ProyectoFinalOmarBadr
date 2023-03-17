package dao;

import beans.Compania;
import beans.Imagen;
import beans.Plataforma;
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

public class PlataformaDAO {

  private BDConex bdConex;
  private DataSource ds;
  private Connection con;

  public PlataformaDAO() throws ServletException {
    bdConex = new BDConex();
    ds = bdConex.getDs();
  }

  public ArrayList<Plataforma> obtenerPlataformasPorIdJuego(int id) {
    ArrayList<Plataforma> arrPlataformas = new ArrayList<Plataforma>();
    String sql =
      "SELECT * FROM plataforma WHERE idPlataforma IN ( SELECT id_plataforma FROM vid_pla WHERE vid_pla.id_juego = ? )";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) arrPlataformas.add(
        new Plataforma(
          id,
          rs.getString("nombre"),
          rs.getString("enlaceOficial"),
          rs.getString("slugIcono")
        )
      );
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    return arrPlataformas;
  }
}
