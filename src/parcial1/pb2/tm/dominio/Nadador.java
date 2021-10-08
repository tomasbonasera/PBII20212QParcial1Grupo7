package src.parcial1.pb2.tm.dominio;

import enums.parcial1.pb2.tm.dominio.EstiloPreferido;
import enums.parcial1.pb2.tm.dominio.TipoDeDeportista;

public class Nadador extends Socio {
	private EstiloPreferido estiloPreferido;

	public Nadador(String nombre, String apellido, String usuario, String contraseña, EstiloPreferido estiloPreferido) {
		super(nombre, apellido, usuario, contraseña);
		this.estiloPreferido = estiloPreferido;
		super.setTipoDeDeportista(TipoDeDeportista.NADADOR);
	}

	public EstiloPreferido getEstiloPreferido() {
		return estiloPreferido;
	}

	public void setEstiloPreferido(EstiloPreferido estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}

}
