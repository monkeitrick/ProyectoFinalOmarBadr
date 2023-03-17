package beans;

public class Plataforma {

  private int idPlataforma;
  private String nombre, enlaceOficial, slugIcono;

  public Plataforma(
    int idPlataforma,
    String nombre,
    String enlaceOficial,
    String slugIcono
  ) {
    this.idPlataforma = idPlataforma;
    this.nombre = nombre;
    this.enlaceOficial = enlaceOficial;
    this.slugIcono = slugIcono;
  }

  public Plataforma() {}

  public int getIdPlataforma() {
    return idPlataforma;
  }

  public void setIdPlataforma(int idPlataforma) {
    this.idPlataforma = idPlataforma;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEnlaceOficial() {
    return enlaceOficial;
  }

  public void setEnlaceOficial(String enlaceOficial) {
    this.enlaceOficial = enlaceOficial;
  }

  public String getSlugIcono() {
    return slugIcono;
  }

  public void setSlugIcono(String slugIcono) {
    this.slugIcono = slugIcono;
  }
}
