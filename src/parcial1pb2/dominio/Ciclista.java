package parcial1pb2.dominio;

public class Ciclista extends Socio {
	private TipoDeBicicleta tipoDeBicicleta;

	public Ciclista(Integer nroSocio, String nombre, String apellido, TipoDeBicicleta tipoDeBicicleta) {
		super(nroSocio, nombre, apellido);
		this.tipoDeBicicleta=tipoDeBicicleta;
		
	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

}

