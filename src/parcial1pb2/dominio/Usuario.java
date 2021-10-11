package parcial1pb2.dominio;

public class Usuario {


	private String usuario;
	private String contrasena;
	private TipoUsuario tipo;


	public Usuario(String usuario, String contrasena, TipoUsuario tipoUsuario) {
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.tipo=tipoUsuario;

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
