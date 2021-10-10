package parcial1pb2.dominio;

public class Ciclista extends Socio {
	private TipoDeBicicleta tipoDeBicicleta;

	public Ciclista(String usuario, String contrasena, String nombre, String apellido, TipoDeBicicleta tipoDeBicicleta,
			TipoUsuario tipoUsuario) {
		super(usuario, contrasena, nombre, apellido, tipoUsuario);
		this.tipoDeBicicleta = tipoDeBicicleta;
		setTipoDeDeportista(TipoDeDeportista.CICLISTA);
		setUsuario(usuario);
		setContrasena(contrasena);

	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

}
