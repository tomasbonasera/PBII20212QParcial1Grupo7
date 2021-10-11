package parcial1pb2.dominio;

public class Usuario {

	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasena;
	private TipoUsuario tipo;

	public Usuario(String usuario, String contrasena, String nombre, String apellido, TipoUsuario tipoUsuario) {
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.apellido = apellido;
		this.nombre = nombre;
		this.tipo = tipoUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

}
