package Parcial_1;

import enums.EstiloPreferido;
import enums.TipoDeDeportista;

public class Nadador extends Socio {
	private EstiloPreferido estiloPreferido;

	public Nadador(Integer nroSocio, String nombre, String apellido, EstiloPreferido estiloPreferido) {
		super(nroSocio, nombre, apellido);
		this.setEstiloPreferido(estiloPreferido);
		super.setTipoDeDeportista(TipoDeDeportista.NADADOR);
	}

	public EstiloPreferido getEstiloPreferido() {
		return estiloPreferido;
	}

	public void setEstiloPreferido(EstiloPreferido estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}

}
