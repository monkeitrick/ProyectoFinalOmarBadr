package beans;

public class Usuario {

  private int idUser;
  private String nombre, apellidos, email, passw;
  private boolean admin;

  // Constructores
  public Usuario() {
	  
  }
  
  public Usuario(String nombre, String apellidos, String email, String passw, boolean admin) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.email = email;
    this.passw = passw;
    this.admin = admin;
  }

  // get/set
  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassw() {
    return passw;
  }

  public void setPassw(String passw) {
    this.passw = passw;
  }

  public boolean getAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public void setAdminInt(boolean admin) {
	  this.admin = admin;
  }

  // toString
  @Override
  public String toString() {
    return (
      "Usuario [idUser=" +
      idUser +
      ", nombre=" +
      nombre +
      ", apellidos=" +
      apellidos +
      ", email=" +
      email +
      ", passw=" +
      passw +
      ", admin=" +
      admin +
      "]"
    );
  }
}
