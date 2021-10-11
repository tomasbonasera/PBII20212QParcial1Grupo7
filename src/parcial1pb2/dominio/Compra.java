package parcial1pb2.dominio;

public class Compra {

	private Veedor[] compradores;
	private Entrada[] entradas;
	private Integer cantidadCompras;
	
	public Compra() {
		this.compradores= new Veedor[200];
		this.entradas= new Entrada[200];
		this.cantidadCompras=0;
	}
	public void agregarVeedor(Veedor nuevo) {
		for (int i = 0; i < compradores.length; i++) {
			if(compradores[i]==null) {
				compradores[i]=nuevo;
				break;
			}
		}
	}
	public void ingresarEntrada(Entrada nueva) {
		for (int i = 0; i < entradas.length; i++) {
			if(entradas[i]==null) {
				entradas[i]=nueva;
				break;
			}
		}
	}
	
	public Boolean realizarCompra(Entrada aComprar, Veedor comprador) {
		Veedor veedorBuscado= buscarVeedor(comprador);
		Boolean seVendio=false;
		
		if(veedorBuscado!=null) {
			if(aComprar.getEsEnVenta().equals(Boolean.TRUE)) {
				aComprar.setEsEnVenta(Boolean.FALSE);
				aComprar.setComprador(comprador);
				cantidadCompras++;
				seVendio=true;
			}
		}
		return seVendio;
	}
	
	public Integer getCantidadCompras() {
		return cantidadCompras;
	}
	public Veedor buscarVeedor(Veedor comprador) {
		for (int i = 0; i < compradores.length; i++) {
			if(compradores[i]!=null) {
				if(compradores[i].equals(comprador)) {
					return compradores[i];
				}
			}
		}
		return null;
	}

	public void imprimirTicket() {
		for (int i = 0; i < entradas.length; i++) {
			if(entradas[i]!=null) {
				System.out.println(" La entrada numero: "+this.entradas[i].getNroEntrada() + " fue comprada por: "
						           + entradas[i].getComprador().getNombre() +" "+ entradas[i].getComprador().getApellido()
						           + " Precio: "+ entradas[i].getTotalPrecio());
			}
		}
	}
	
}
