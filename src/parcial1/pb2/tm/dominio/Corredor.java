
package src.parcial1.pb2.tm.dominio;

import enums.parcial1.pb2.tm.dominio.DistanciaPreferida;
import enums.parcial1.pb2.tm.dominio.TipoDeDeportista;

public class Corredor extends Socio {
	private DistanciaPreferida distanciaPreferida;

	public Corredor(Integer nroSocio, String nombre, String apellido, DistanciaPreferida distanciaPreferida) {
		super(nroSocio, nombre, apellido);

		super.setTipoDeDeportista(TipoDeDeportista.CORREDOR);
		this.distanciaPreferida = distanciaPreferida;

	}

	public DistanciaPreferida getTipoDeBicicleta() {
		return distanciaPreferida;
	}

	public void setTipoDeBicicleta(DistanciaPreferida distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

}
