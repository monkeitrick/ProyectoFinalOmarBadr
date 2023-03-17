package beans;

public class LineaPedido {

  private int idLineaPedido, cantidad;
  private VideoJuego juego;
  private Compra compr;

  public LineaPedido(
    int idLineaPedido,
    int cantidad,
    VideoJuego juego,
    Compra compr
  ) {
    this.idLineaPedido = idLineaPedido;
    this.cantidad = cantidad;
    this.juego = juego;
    this.compr = compr;
  }

  public LineaPedido(int cantidad, VideoJuego juego) {
    this.cantidad = cantidad;
    this.juego = juego;
  }

  public LineaPedido() {}

  public int getIdLineaPedido() {
    return idLineaPedido;
  }

  public void setIdLineaPedido(int idLineaPedido) {
    this.idLineaPedido = idLineaPedido;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public VideoJuego getJuego() {
    return juego;
  }

  public void setJuego(VideoJuego juego) {
    this.juego = juego;
  }

  public Compra getCompr() {
    return compr;
  }

  public void setCompr(Compra compr) {
    this.compr = compr;
  }

  @Override
  public String toString() {
    return (
      "LineaPedido [idLineaPedido=" +
      idLineaPedido +
      ", cantidad=" +
      cantidad +
      ", juego=" +
      juego +
      ", compr=" +
      compr +
      "]"
    );
  }
}
