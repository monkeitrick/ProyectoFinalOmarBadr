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

  public ClienteDAO(){
	try {
		bdConex = new BDConex();
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    ds = bdConex.getDs();
  }

  private static final String capitalize(String str) {
    if (str == null || str.length() == 0) return str;

    return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
  }

  // Metodo que devuelve un cliente pasandole el email y la contraseña
  public Usuario buscaCliente(String email, String password) {
    String sql =
      "SELECT * FROM usuario WHERE email = '" + email + "' AND password = '" + password + "' ";
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

  // Metodo que devuelve un cliente pasandole el id del usuario
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

  // Metodo para cambiar contraseña pasandole la nueva contraseña y el email del usuario
  public void cambiarPassw(String email, String passw) {
    String sql = "UPDATE usuario SET password = ? WHERE email = ?";
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, passw);
      ps.setString(2, email);
      ps.executeUpdate();
      ps.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // Metodo que devuelve si existe un cliente pasandole el email 
  public boolean buscaCliente(String email) {
    boolean existe = false;
    String sql = "SELECT * FROM usuario WHERE email = '" + email + "'";
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
	  if(buscaCliente(u.getEmail()))
			return false;
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
        if(admin == 1)
        	u.setAdmin(true);
        else
        	u.setAdmin(false);
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
  
  //Metodo que elimina un usuario pasado su id
	public boolean borrarUsuario(int id){
		try{    
			con = ds.getConnection();
	       		PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id=?");
	       		ps.setInt(1, id); 
	       		ps.executeUpdate();
	       		ps.close();
	       		con.close();
	       		return true;
	   	} catch (SQLException ex) {
	       		System.err.println("Error en metodo borrarProducto: " + ex);
	       		return false;
	   	}
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
