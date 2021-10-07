package parcial1.pb2.tm.dominio;

public class Nadador extends Socio {
	private EstiloPreferido estiloPreferido;

	public Nadador(Integer nroSocio, String nombre, String apellido, EstiloPreferido estiloPreferido) {
		super(nroSocio, nombre, apellido);
		this.estiloPreferido=estiloPreferido;
		super.setTipoDeDeportista(TipoDeDeportista.NADADOR);
	}

	public EstiloPreferido getEstiloPreferido() {
		return estiloPreferido;
	}

	public void setEstiloPreferido(EstiloPreferido estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}

}
