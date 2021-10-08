package parcial1pb2.dominio;

public class Nadador extends Socio {
	private EstiloPreferido estiloPreferido;

	public Nadador(Integer nroSocio, String nombre, String apellido, EstiloPreferido estiloPreferido) {
		super(nroSocio, nombre, apellido);
		this.estiloPreferido=estiloPreferido;
		setTipoDeDeportista(TipoDeDeportista.NADADOR);
	}

	public EstiloPreferido getEstiloPreferido() {
		return estiloPreferido;
	}

	public void setEstiloPreferido(EstiloPreferido estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}

}
