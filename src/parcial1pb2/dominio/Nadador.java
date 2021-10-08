package parcial1pb2.dominio;

public class Nadador extends Socio {
	private EstiloPreferido estiloPreferido;

	public Nadador(String usuario,String contrasena, String nombre, String apellido, EstiloPreferido estiloPreferido) {
		super(nombre, apellido);
		this.estiloPreferido=estiloPreferido;
		setTipoDeDeportista(TipoDeDeportista.NADADOR);
		setUsuario(usuario);
		setContrasena(contrasena);
	}

	public EstiloPreferido getEstiloPreferido() {
		return estiloPreferido;
	}

	public void setEstiloPreferido(EstiloPreferido estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}

}
