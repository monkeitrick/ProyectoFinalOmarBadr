package beans;

import java.sql.Date;

public class Compra {

  private int idCompra;
  private Usuario usuario;
  private Date fecha;
  private Double total;

  public Compra(int idCompra, Usuario usuario, Date fecha) {
    this.idCompra = idCompra;
    this.usuario = usuario;
    this.fecha = fecha;
  }

  public Compra(int idCompra, Usuario usuario, Date fecha, double total) {
    this.idCompra = idCompra;
    this.usuario = usuario;
    this.fecha = fecha;
    this.total = total;
  }

  public Compra() {}

  public int getIdCompra() {
    return idCompra;
  }

  public void setIdCompra(int idCompra) {
    this.idCompra = idCompra;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return (
      "Compra [idCompra=" +
      idCompra +
      ", usuario=" +
      usuario +
      ", fecha=" +
      fecha +
      ", total=" +
      total +
      "]"
    );
  }
}
