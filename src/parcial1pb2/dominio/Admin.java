package parcial1pb2.dominio;

public class Admin {

	private String usuarioAdminDefault;
	private String contrasenaAdminDefault;
	private Evento[] eventos;
	private Usuario[] usuarios;

	public Admin() {
		this.usuarioAdminDefault = "admin";
		this.contrasenaAdminDefault = "2468";
		this.eventos = new Evento[100];
		this.usuarios = new Usuario[1000];
		this.usuarios[0] = new Usuario(usuarioAdminDefault, contrasenaAdminDefault, TipoUsuario.ADMIN);
	}

	public Boolean agregarUsuarioRegistrado(Usuario usuarioRegistrado) {
		Boolean verificar = false;

		for (int i = 0; i < usuarios.length; i++) {
			if (this.usuarios[i] == null) {
				this.usuarios[i] = usuarioRegistrado;
				verificar = true;
				break;
			}
		}
		return verificar;
	}

	public Boolean verificarIngresoDeUsuario(String usuario, String contrasena) {
		Boolean verificar = false;

		for (int i = 0; i < usuarios.length; i++) {
			if (this.usuarios[i] != null) {
				if (this.usuarios[i].getUsuario().equals(usuario) && this.usuarios[i].getContrasena().equals(contrasena)) {
					verificar = true;
					break;
				}
			}
		}
		return verificar;
	}
	public Boolean verificarUsuarioRepetido(String usuario) {
		Boolean rt=false;
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i]!=null) {
				if (usuarios[i].getUsuario().equals(usuario) || usuario.equals(usuarioAdminDefault)) {
					rt=true;
					break;
				}
			}
		}
		return rt;
	}
	public Usuario buscarPorUsuarioYContrasena(String usuario, String contrasena) {
		Usuario usuarioBuscado=null;
		if (usuarioAdminDefault.equals(usuario) && contrasenaAdminDefault.equals(contrasena)) {
			usuarioBuscado=usuarios[0];
		} else {
			for (int i = 0; i < usuarios.length; i++) {
				if (this.usuarios[i] != null) {
					if (this.usuarios[i].getUsuario().equals(usuario) && this.usuarios[i].getContrasena().equals(contrasena)) {
						usuarioBuscado=usuarios[i];
						break;
					}
				}
			}
		}
		return usuarioBuscado;
	}



}
