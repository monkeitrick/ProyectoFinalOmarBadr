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

  /* M�todo que devuelve un cliente pasandole el nombre y la contrase�a*/
  public Usuario buscaCliente(String nombre, String password) {
    nombre = capitalize(nombre);
    String sql =
      "SELECT * FROM usuario, imagen WHERE usuario.nombre = '" +
      nombre +
      "' AND usuario.password = '" +
      password +
      "' " +
      "AND usuario.id_imagen = imagen.idImagen";
    Usuario user = null;
    try {
      /*
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, password);
			*/
      con = ds.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      if (rs.next()) {
        /*  img user*/
        Imagen img = new Imagen(rs.getInt("idImagen"), rs.getString("ruta"));
        /* Usuario */
        user = new Usuario();
        user.setIdUser(rs.getInt("idUsuario"));
        user.setNombre(capitalize(rs.getString("nombre")));
        user.setApellidos(rs.getString("apellidos"));
        user.setDesc(rs.getString("descripcion"));
        user.setDir(rs.getString("direccion"));
        user.setCp(rs.getString("codigoPostal"));
        user.setMunicipio(rs.getString("municipio"));
        user.setProvincia(rs.getString("provincia"));
        user.setPais(rs.getString("pais"));
        user.setTlf(rs.getString("telefono"));
        user.setEmail(rs.getString("email"));
        user.setPassw(rs.getString("password"));
        user.setAdmin(rs.getBoolean("admin"));
        user.setImg(img);
      }
      rs.close();
      st.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return user;
  }

  /* M�todo que devuelve un cliente pasandole el nombre y la contrase�a*/
  public Usuario buscaClientePorID(int idUsuario) {
    String sql =
      "SELECT * FROM usuario, imagen WHERE usuario.idUsuario = ? AND usuario.id_imagen = imagen.idImagen";
    Usuario user = null;
    try {
      con = ds.getConnection();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, idUsuario);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        /*  img user*/
        Imagen img = new Imagen(rs.getInt("idImagen"), rs.getString("ruta"));
        /* Usuario */
        user = new Usuario();
        user.setIdUser(rs.getInt("idUsuario"));
        user.setNombre(capitalize(rs.getString("nombre")));
        user.setApellidos(rs.getString("apellidos"));
        user.setDesc(rs.getString("descripcion"));
        user.setDir(rs.getString("direccion"));
        user.setCp(rs.getString("codigoPostal"));
        user.setMunicipio(rs.getString("municipio"));
        user.setProvincia(rs.getString("provincia"));
        user.setPais(rs.getString("pais"));
        user.setTlf(rs.getString("telefono"));
        user.setEmail(rs.getString("email"));
        user.setPassw(rs.getString("password"));
        user.setAdmin(rs.getBoolean("admin"));
        user.setImg(img);
      }
      rs.close();
      ps.close();
      con.close();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return user;
  }

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

  /* M�todo que devuelve si existe un cliente pasandole el nombre */
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

  //M�todo para introducir un nuevo usuario en la base de datos
  public boolean guardarCliente(Usuario u) {
    boolean guardado = false;
    String sql =
      "INSERT INTO usuario(nombre, apellidos, descripcion, direccion, codigoPostal, municipio, provincia, pais, telefono, email, password, admin, id_imagen) " +
      "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
      Connection con = ds.getConnection();
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, capitalize(u.getNombre()));
      st.setString(2, u.getApellidos());
      st.setString(3, u.getDesc());
      st.setString(4, u.getDir());
      st.setString(5, u.getCp());
      st.setString(6, u.getMunicipio());
      st.setString(7, u.getProvincia());
      st.setString(8, u.getPais());
      st.setString(9, u.getTlf());
      st.setString(10, u.getEmail());
      st.setString(11, u.getPassw());
      if (u.getAdmin() == false) {
        st.setInt(12, 0);
      } else {
        st.setInt(12, 1);
      }
      if (u.getImg() == null) {
        st.setInt(13, 1);
      } else {
        st.setInt(13, u.getImg().getIdImagen());
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
      "select usuario.idUsuario, usuario.nombre, usuario.apellidos, usuario.admin, imagen.ruta from usuario, imagen where imagen.idImagen=usuario.id_imagen;";
    try {
      con = ds.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        int idUsuario = rs.getInt("usuario.idUsuario");
        String nombre = capitalize(rs.getString("usuario.nombre"));
        String apellidos = capitalize(rs.getString("usuario.apellidos"));
        int admin = rs.getInt("usuario.admin");
        String ruta = rs.getString("imagen.ruta");
        Imagen img = new Imagen(0, ruta);
        Usuario u = new Usuario();
        u.setAdminInt(admin);
        u.setNombre(nombre);
        u.setIdUser(idUsuario);
        u.setApellidos(apellidos);
        u.setImg(img);
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

  // M�todo que devuelve un ArrayList con todas las compras de un usuario pasandole un idUsuario
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
  /* M�todo que devuelve si existe un cliente pasandole el nombre */
  /*
	public int cantClientesRegistrados() {
		String sql = "SELECT count(*) AS cantCli FROM clientes";
		int cantClientes = 0;
		try {
			con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
            	cantClientes = rs.getInt("cantCli");
            rs.close();
            st.close();
            con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cantClientes;
	}
	*/

  /*
	public boolean actualizarCliente(Cliente c) {
		boolean editado = false;
		String sql = "UPDATE clientes SET nombre = ?, pasword = ?, domicilio = ?, "
				+ "codigopostal = ?, telefono = ?, email = ?)";
        try {
            Connection con = ds.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            ;
            st.setString(1, c.getNombre());
            st.setString(2, c.getPassword());
            st.setString(3, c.getDomicilio());
            st.setString(4, c.getCodigoPostal());
            st.setString(5, c.getTelefono());
            st.setString(6, c.getEmail());
            
            st.executeUpdate();
            editado = true;
            
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error en metodo actualizarCliente: " + ex);
        }
		
		return editado;
	}
	*/
}
