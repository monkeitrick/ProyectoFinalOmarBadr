package dao;

import beans.Compania;
import beans.Genero;
import beans.Imagen;
import beans.Personaje;
import beans.Usuario;
import beans.VideoJuego;
import conex.BDConex;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class JuegosDAO {

  private BDConex bdConex;
  private DataSource ds;
  private Connection con;

  public JuegosDAO() throws ServletException {
    bdConex = new BDConex();
    ds = bdConex.getDs();
  }

  // Metodo que devuelve una listad de todos los VideoJuego
  public ArrayList<VideoJuego> juegosBBDD() {
    ArrayList<VideoJuego> arrVideojuegos = new ArrayList<VideoJuego>();
    String sql = "SELECT * FROM videojuegos";
    try {
      con = ds.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        int idJuego = rs.getInt("idJuego");
        String titulo = rs.getString("titulo");
        String descripcion = rs.getString("descripcion");
        String trailer = rs.getString("trailer");
        Date fecha = rs.getDate("fecha");
        double precio = rs.getDouble("precio");
        
        // Compañia
        CompaniaDAO cDao = new CompaniaDAO();
        Compania compania = cDao.obtenerCompaniaPorId(rs.getInt("id_compania"));
        
        // Imagenes
        ImagenDAO imgDao = new ImagenDAO();
        Imagen imgCover = imgDao.obtenerImagenPorId(rs.getInt("id_imgCover"));
        Imagen imgCoverMobile = imgDao.obtenerImagenPorId(
          rs.getInt("id_imgCoverMobile")
        );
        Imagen imgBanner = imgDao.obtenerImagenPorId(rs.getInt("id_imgBanner"));
        
        // Plataformas
        PlataformaDAO pDao = new PlataformaDAO();
        
        // Crear Juego
        VideoJuego juego = new VideoJuego( idJuego, titulo, descripcion, trailer, fecha, precio, compania, imgCover, imgCoverMobile, imgBanner, pDao.obtenerPlataformasPorIdJuego(idJuego), obtenerGenerosDeJuegoPorId(idJuego), obtenerPersonajesDeJuegoPorId(idJuego));
        arrVideojuegos.add(juego);
      }
      rs.close();
      st.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    }

    return arrVideojuegos;
  }

  // Metodo que devuleve un VideoJuego pasandole su id
  public VideoJuego obtenerJuegoPorId(int idJuego) {
    VideoJuego juego = null;
    String sql = "SELECT * FROM videojuegos where idJuego = ?";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idJuego);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        String titulo = rs.getString("titulo");
        String descripcion = rs.getString("descripcion");
        String trailer = rs.getString("trailer");
        Date fecha = rs.getDate("fecha");
        double precio = rs.getDouble("precio");
        
        // Compañia
        CompaniaDAO cDao = new CompaniaDAO();
        Compania compania = cDao.obtenerCompaniaPorId(rs.getInt("id_compania"));
        
        // Imagenes
        ImagenDAO imgDao = new ImagenDAO();
        Imagen imgCover = imgDao.obtenerImagenPorId(rs.getInt("id_imgCover"));
        Imagen imgCoverMobile = imgDao.obtenerImagenPorId(
          rs.getInt("id_imgCoverMobile")
        );
        Imagen imgBanner = imgDao.obtenerImagenPorId(rs.getInt("id_imgBanner"));
        
        // Plataformas
        PlataformaDAO pDao = new PlataformaDAO();
        
        // Crear Juego
        juego =
          new VideoJuego(
            idJuego,
            titulo,
            descripcion,
            trailer,
            fecha,
            precio,
            compania,
            imgCover,
            imgCoverMobile,
            imgBanner,
            pDao.obtenerPlataformasPorIdJuego(idJuego),
            obtenerGenerosDeJuegoPorId(idJuego),
            obtenerPersonajesDeJuegoPorId(idJuego)
          );
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    }

    return juego;
  }

  // Metodo que devuelve una lista de los Generos de un VideoJuego pasandole la id de este
  public ArrayList<Genero> obtenerGenerosDeJuegoPorId(int idJuego) {
    ArrayList<Genero> arr = new ArrayList<Genero>();
    String sql =
      "SELECT * FROM `genero` WHERE idGenero in (SELECT id_gen FROM gen_jue WHERE id_juego = ?)";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idJuego);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        String nombre = rs.getString("nombre");
        int idGenero = rs.getInt("idGenero");
        arr.add(new Genero(idGenero, nombre));
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    return arr;
  }

  // Metodo que devuelve una lista de los Personaje de un VideoJuego pasandole la id de este
  public ArrayList<Personaje> obtenerPersonajesDeJuegoPorId(int idJuego) {
    ArrayList<Personaje> arr = new ArrayList<Personaje>();
    String sql = "SELECT * FROM `personaje` WHERE id_juego = ?";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idJuego);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int idPersonaje = rs.getInt("idPersonaje");
        String nombre = rs.getString("nombre");
        ImagenDAO iDao = new ImagenDAO();
        Imagen img = iDao.obtenerImagenPorId(rs.getInt("id_imagen"));
        arr.add(new Personaje(idPersonaje, idJuego, img, nombre));
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    }

    return arr;
  }
}
