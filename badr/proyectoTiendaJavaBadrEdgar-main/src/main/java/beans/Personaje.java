package beans;

public class Personaje {

  private int idPersonaje;
  private String nombre;
  private int idJuego;
  private Imagen imagen;

  public Personaje(int idPersonaje, int idJuego, Imagen imagen, String nombre) {
    this.idPersonaje = idPersonaje;
    this.idJuego = idJuego;
    this.imagen = imagen;
    this.nombre = nombre;
  }

  public Personaje() {}

  public int getIdPersonaje() {
    return idPersonaje;
  }

  public void setIdPersonaje(int idPersonaje) {
    this.idPersonaje = idPersonaje;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getJuego() {
    return idJuego;
  }

  public void setJuego(int idJuego) {
    this.idJuego = idJuego;
  }

  public Imagen getImagen() {
    return imagen;
  }

  public void setImagen(Imagen imagen) {
    this.imagen = imagen;
  }

  @Override
  public String toString() {
    return nombre;
  }
}
