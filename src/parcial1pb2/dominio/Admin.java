package parcial1pb2.dominio;

public class Admin {

	private String usuario;
	private String contrasena;
	private Evento[] eventos;
	private Usuario[] usuarios;

	public Admin() {
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.eventos = new Evento[10];
		this.usuarios = new Usuario[1000];
		this.usuarios[0] = new Usuario("pepito", "perez", "admin", "2468", TipoUsuario.ADMIN);
	}

	public Boolean agregarUsuarioRegistrado(Usuario usuarioRegistrado) {
		Boolean verificar = false;

		for (int i = 0; i < usuarios.length; i++) {
			if (this.usuarios[i] == null) {
				this.usuarios[i] = usuarioRegistrado;
				verificar = true;
			}
		}
		return verificar;
	}

	public Boolean verificarIngresoDeUsuario(String usuario, String contrasena) {
		Boolean verificar = false;

		for (int i = 0; i < usuarios.length; i++) {
			if (this.usuarios[i] != null) {
				if (this.usuarios[i].getUsuario() == usuario && this.usuarios[i].getContrasena() == contrasena) {
					verificar = true;
				}
			}
		}
		return verificar;
	}

}
