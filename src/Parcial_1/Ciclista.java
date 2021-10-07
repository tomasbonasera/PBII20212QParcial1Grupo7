package Parcial_1;

import enums.TipoDeBicicleta;
import enums.TipoDeDeportista;

public class Ciclista extends Socio {
	private TipoDeBicicleta tipoDeBicicleta;

	public Ciclista(Integer nroSocio, String nombre, String apellido, TipoDeBicicleta tipoDeBicicleta) {
		super(nroSocio, nombre, apellido);
		this.setTipoDeBicicleta(tipoDeBicicleta);
		super.setTipoDeDeportista(TipoDeDeportista.CICLISTA);
	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

}
