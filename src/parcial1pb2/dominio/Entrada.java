package parcial1pb2.dominio;

public class Entrada {

	private Integer nroEntrada;
	private Integer cantidadEntradas;
	private Double precio;
	private Boolean esEnVenta;
	private Veedor comprador;
	public Entrada(Integer nroEntrada, Double precio, Integer cantidadEntradas) {
		super();
		this.nroEntrada = nroEntrada;
		this.precio = precio;
		this.cantidadEntradas=cantidadEntradas;
		this.esEnVenta=true;
		this.comprador=null;
	}
	public Integer getNroEntrada() {
		return nroEntrada;
	}
	public void setNroEntrada(Integer nroEntrada) {
		this.nroEntrada = nroEntrada;
	}
	public Integer getCantidadEntradas() {
		return cantidadEntradas;
	}
	public void setCantidadEntradas(Integer cantidadEntradas) {
		this.cantidadEntradas = cantidadEntradas;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Boolean getEsEnVenta() {
		return esEnVenta;
	}
	public void setEsEnVenta(Boolean esEnVenta) {
		this.esEnVenta = esEnVenta;
	}
	public Veedor getComprador() {
		return comprador;
	}
	public void setComprador(Veedor comprador) {
		this.comprador = comprador;
	}
	public Double getTotalPrecio() {
		return this.cantidadEntradas*this.precio;
	}
	
}
