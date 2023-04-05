package dao;

import beans.Compra;
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
import javax.websocket.Session;

public class ClienteDAO {

  private BDConex bdConex;
  private DataSource ds;
  private Connection con;

  public ClienteDAO() throws ServletException {
    bdConex = new BDConex();
    ds = bdConex.getDs();
  }

  private static final String capitalize(String str) {
    if (str == null || str.length() == 0) return str;

    return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
  }

  // Metodo que devuelve un cliente pasandole el nombre y la contrase�a
  public Usuario buscaCliente(String nombre, String password) {
    nombre = capitalize(nombre);
    String sql =
      "SELECT * FROM usuario, imagen WHERE usuario.nombre = '" + nombre + "' AND usuario.password = '" + password + "' ";
    Usuario user = null;
    try {
      con = ds.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      if (rs.next()) {
        
        // Usuario
        user = new Usuario();
        user.setIdUser(rs.getInt("idUsuario"));
        user.setNombre(capitalize(rs.getString("nombre")));
        user.setApellidos(rs.getString("apellidos"));
        user.setEmail(rs.getString("email"));
        user.setPassw(rs.getString("password"));
        user.setAdmin(rs.getBoolean("admin"));
      }
      rs.close();
      st.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return user;
  }

  // Metodo que devuelve un cliente pasandole el nombre y la contrase�a
  public Usuario buscaClientePorID(int idUsuario) {
    String sql =
      "SELECT * FROM usuario, imagen WHERE usuario.idUsuario = ? ";
    Usuario user = null;
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idUsuario);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        
        // Usuario 
        user = new Usuario();
        user.setIdUser(rs.getInt("idUsuario"));
        user.setNombre(capitalize(rs.getString("nombre")));
        user.setApellidos(rs.getString("apellidos"));
        user.setEmail(rs.getString("email"));
        user.setPassw(rs.getString("password"));
        user.setAdmin(rs.getBoolean("admin"));
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return user;
  }

  // Metodo para cambiar contrase�a pasndole la nueva contrase�a y el nombre del usuario
  public void cambiarPassw(String username, String passw) {
    String sql = "UPDATE usuario SET password = ? WHERE nombre = ?";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, passw);
      ps.setString(2, capitalize(username));
      ps.executeUpdate();
      ps.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Metodo que devuelve si existe un cliente pasandole el nombre 
  public boolean buscaCliente(String nombre) {
    nombre = capitalize(nombre);
    boolean existe = false;
    String sql = "SELECT * FROM usuario WHERE nombre = '" + nombre + "'";
    try {
      con = ds.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      if (rs.next()) existe = true;
      rs.close();
      st.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return existe;
  }

  //Metodo para introducir un nuevo usuario en la base de datos
  public boolean guardarCliente(Usuario u) {
    boolean guardado = false;
    String sql =
      "INSERT INTO usuario(nombre, apellidos, email, password, admin) " +
      "VALUES(?, ?, ?, ?, ?)";
    try {
      Connection con = ds.getConnection();
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, capitalize(u.getNombre()));
      st.setString(2, u.getApellidos());
      st.setString(3, u.getEmail());
      st.setString(4, u.getPassw());
      if (u.getAdmin() == false) {
        st.setInt(5, 0);
      } else {
        st.setInt(5, 1);
      }
      st.executeUpdate();
      guardado = true;

      st.close();
      con.close();
    } catch (SQLException ex) {
      System.err.println("Error en metodo guardarCliente: " + ex);
    }

    return guardado;
  }

  // Metodo que devuelve todos los usuarios
  public ArrayList<Usuario> listarUsuarios() {
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    String sql =
      "select usuario.idUsuario, usuario.nombre, usuario.apellidos, usuario.admin from usuario;";
    try {
      con = ds.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        int idUsuario = rs.getInt("usuario.idUsuario");
        String nombre = capitalize(rs.getString("usuario.nombre"));
        String apellidos = capitalize(rs.getString("usuario.apellidos"));
        int admin = rs.getInt("usuario.admin");
        Usuario u = new Usuario();
        u.setAdminInt(admin);
        u.setNombre(nombre);
        u.setIdUser(idUsuario);
        u.setApellidos(apellidos);
        usuarios.add(u);
      }

      rs.close();
      st.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  // Metodo que devuelve un ArrayList con todas las compras de un usuario pasandole un idUsuario
  public ArrayList<Compra> obtenerComprasUsuarioPorId(int idUser) {
    ArrayList<Compra> arrCompras = new ArrayList<Compra>();
    Usuario user = buscaClientePorID(idUser);
    String sql = "select * from compra where id_usuario = ?";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idUser);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        arrCompras.add(
          new Compra(
            rs.getInt("idCompra"),
            user,
            rs.getDate("fecha"),
            rs.getDouble("total")
          )
        );
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return arrCompras;
  }
}
