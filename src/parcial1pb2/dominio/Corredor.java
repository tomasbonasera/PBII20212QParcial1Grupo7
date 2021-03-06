package parcial1pb2.dominio;

public class Corredor extends Socio {
	private DistanciaPreferida distanciaPreferida;

	public Corredor(String usuario, String contrasena, String nombre, String apellido,
			DistanciaPreferida distanciaPreferida, TipoUsuario tipoUsuario) {
		super(usuario, contrasena, nombre, apellido, tipoUsuario);
		this.distanciaPreferida = distanciaPreferida;
		setTipoDeDeportista(TipoDeDeportista.CORREDOR);
		setUsuario(usuario);
		setContrasena(contrasena);
	}

	public DistanciaPreferida getDistanciaPreferida() {
		return distanciaPreferida;
	}

	public void setDistanciaPreferida(DistanciaPreferida distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

}