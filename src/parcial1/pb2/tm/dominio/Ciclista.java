package src.parcial1.pb2.tm.dominio;

import enums.parcial1.pb2.tm.dominio.TipoDeBicicleta;
import enums.parcial1.pb2.tm.dominio.TipoDeDeportista;

public class Ciclista extends Socio {
	private TipoDeBicicleta tipoDeBicicleta;

	public Ciclista(Integer nroSocio, String nombre, String apellido, TipoDeBicicleta tipoDeBicicleta) {
		super(nroSocio, nombre, apellido);
		this.tipoDeBicicleta = tipoDeBicicleta;
		setTipoDeDeportista(TipoDeDeportista.CICLISTA);
	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

}