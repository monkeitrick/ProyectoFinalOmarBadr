package beans;

import java.sql.Date;
import java.util.ArrayList;

public class VideoJuego {

  private int idJuego;
  private String titulo, descripcion, trailer, fecha;
  private double precio;
  private Compania compania;
  private Imagen imgCover, imgCoverMobile, imgBanner;
  private ArrayList<Plataforma> plataformas;
  private ArrayList<Genero> generos;
  private ArrayList<Personaje> personajes;

  public VideoJuego(
    int idJuego,
    String titulo,
    String descripcion,
    String trailer,
    Date fecha,
    double precio,
    Compania compania,
    Imagen imgCover,
    Imagen imgCoverMobile,
    Imagen imgBanner,
    ArrayList<Plataforma> plataformas,
    ArrayList<Genero> generos,
    ArrayList<Personaje> personajes
  ) {
    this.idJuego = idJuego;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.trailer = trailer;
    this.precio = precio;
    this.compania = compania;
    this.imgCover = imgCover;
    this.imgCoverMobile = imgCoverMobile;
    this.imgBanner = imgBanner;
    this.plataformas = plataformas;
    this.generos = generos;
    this.personajes = personajes;
    this.fecha = obtenerStringFecha(fecha);
  }

  public VideoJuego() {}

  private String obtenerStringFecha(Date fecha) {
    String str = fecha + "";
    String[] partes = str.split("-");
    String mes = "";
    switch (partes[1]) {
      case "01":
        mes = "Enero";
        break;
      case "02":
        mes = "Febrero";
        break;
      case "03":
        mes = "Marzo";
        break;
      case "04":
        mes = "Abril";
        break;
      case "05":
        mes = "Mayo";
        break;
      case "06":
        mes = "Junio";
        break;
      case "07":
        mes = "Julio";
        break;
      case "08":
        mes = "Agosto";
        break;
      case "09":
        mes = "Septiembre";
      case "10":
        mes = "Octubre";
        break;
      case "11":
        mes = "Noviembre";
        break;
      case "12":
        mes = "Diciembre";
        break;
    }
    return partes[2] + " de " + mes + ", " + partes[0];
  }

  public int getIdJuego() {
    return idJuego;
  }

  public void setIdJuego(int idJuego) {
    this.idJuego = idJuego;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getTrailer() {
    return trailer;
  }

  public void setTrailer(String trailer) {
    this.trailer = trailer;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public Compania getCompania() {
    return compania;
  }

  public void setCompania(Compania compania) {
    this.compania = compania;
  }

  public Imagen getImgCover() {
    return imgCover;
  }

  public void setImgCover(Imagen imgCover) {
    this.imgCover = imgCover;
  }

  public Imagen getImgCoverMobile() {
    return imgCoverMobile;
  }

  public void setImgCoverMobile(Imagen imgCoverMobile) {
    this.imgCoverMobile = imgCoverMobile;
  }

  public Imagen getImgBanner() {
    return imgBanner;
  }

  public void setImgBanner(Imagen imgBanner) {
    this.imgBanner = imgBanner;
  }

  public ArrayList<Plataforma> getPlataformas() {
    return plataformas;
  }

  public void setPlataformas(ArrayList<Plataforma> plataformas) {
    this.plataformas = plataformas;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public ArrayList<Genero> getGeneros() {
    return generos;
  }

  public void setGeneros(ArrayList<Genero> generos) {
    this.generos = generos;
  }

  public ArrayList<Personaje> getPersonajes() {
    return personajes;
  }

  public void setPersonajes(ArrayList<Personaje> personajes) {
    this.personajes = personajes;
  }
}
