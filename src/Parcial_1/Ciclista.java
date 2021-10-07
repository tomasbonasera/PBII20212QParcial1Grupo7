package Parcial_1;

import enums.TipoDeBicicleta;

public class Ciclista extends Socio {
	private TipoDeBicicleta tipoDeBicicleta;

	public Ciclista(Integer nroSocio, String nombre, String apellido, TipoDeBicicleta tipoDeBicicleta) {
		super(nroSocio, nombre, apellido);
		this.setTipoDeBicicleta(tipoDeBicicleta);
	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

}
