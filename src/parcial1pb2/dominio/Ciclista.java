package parcial1pb2.dominio;

public class Ciclista extends Socio {
	private TipoDeBicicleta tipoDeBicicleta;

	public Ciclista(String usuario,String contrasena, String nombre, String apellido, TipoDeBicicleta tipoDeBicicleta) {
		super(nombre, apellido);
		this.tipoDeBicicleta=tipoDeBicicleta;
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

