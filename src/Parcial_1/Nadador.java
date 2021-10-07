package Parcial_1;

import enums.DistanciaPreferida;

public class Nadador extends Socio {
	private DistanciaPreferida distanciaPreferida; 

	public Nadador(Integer nroSocio, String nombre, String apellido, DistanciaPreferida distanciaPreferida) {
		super(nroSocio, nombre, apellido);
		this.setDistanciaPreferida(distanciaPreferida);
	}

	public DistanciaPreferida getDistanciaPreferida() {
		return distanciaPreferida;
	}

	public void setDistanciaPreferida(DistanciaPreferida distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

}
