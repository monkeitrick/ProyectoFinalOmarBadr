package beans;

public class Imagen {

  private int idImagen;
  private String ruta;

  public Imagen(int idImagen, String ruta) {
    this.idImagen = idImagen;
    this.ruta = ruta;
  }

  public Imagen() {}

  public int getIdImagen() {
    return idImagen;
  }

  public void setIdImagen(int idImagen) {
    this.idImagen = idImagen;
  }

  public String getRuta() {
    return ruta;
  }

  public void setRuta(String ruta) {
    this.ruta = ruta;
  }

  @Override
  public String toString() {
    return ruta;
  }
}
