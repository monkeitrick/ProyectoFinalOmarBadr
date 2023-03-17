package beans;

public class Usuario {

  private int idUser;
  private Imagen img;
  private String nombre, apellidos, desc, dir, cp, municipio, provincia, pais, tlf, email, passw;
  private boolean admin;

  public Usuario(
    int idUser,
    Imagen img,
    String nombre,
    String apellidos,
    String desc,
    String dir,
    String cp,
    String municipio,
    String provincia,
    String pais,
    String tlf,
    String email,
    String passw,
    int admin
  ) {
    this.idUser = idUser;
    this.img = img;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.desc = desc;
    this.dir = dir;
    this.cp = cp;
    this.municipio = municipio;
    this.provincia = provincia;
    this.pais = pais;
    this.tlf = tlf;
    this.email = email;
    this.passw = passw;
    if (admin == 1) {
      this.admin = true;
    } else {
      this.admin = false;
    }
  }

  public Usuario() {}

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public Imagen getImg() {
    return img;
  }

  public void setImg(Imagen img) {
    this.img = img;
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

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getDir() {
    return dir;
  }

  public void setDir(String dir) {
    this.dir = dir;
  }

  public String getCp() {
    return cp;
  }

  public void setCp(String cp) {
    this.cp = cp;
  }

  public String getMunicipio() {
    return municipio;
  }

  public void setMunicipio(String municipio) {
    this.municipio = municipio;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getTlf() {
    return tlf;
  }

  public void setTlf(String tlf) {
    this.tlf = tlf;
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

  public void setAdminInt(int admin) {
    if (admin == 1) {
      this.admin = true;
    } else {
      this.admin = false;
    }
  }

  @Override
  public String toString() {
    return (
      "Usuario [idUser=" +
      idUser +
      ", img=" +
      img +
      ", nombre=" +
      nombre +
      ", apellidos=" +
      apellidos +
      ", desc=" +
      desc +
      ", dir=" +
      dir +
      ", cp=" +
      cp +
      ", municipio=" +
      municipio +
      ", provincia=" +
      provincia +
      ", pais=" +
      pais +
      ", tlf=" +
      tlf +
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
