package Parcial_1;

import enums.DistanciaPreferida;

public class Corredor extends Socio {
	private DistanciaPreferida distanciaPreferida;

	public Corredor(Integer nroSocio, String nombre, String apellido, DistanciaPreferida distanciaPreferida) {
		super(nroSocio, nombre, apellido);
		this.setTipoDeBicicleta(distanciaPreferida);
	}

	public DistanciaPreferida getTipoDeBicicleta() {
		return distanciaPreferida;
	}

	public void setTipoDeBicicleta(DistanciaPreferida distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

	
}
