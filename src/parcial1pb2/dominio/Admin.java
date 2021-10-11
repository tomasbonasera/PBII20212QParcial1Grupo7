package parcial1pb2.dominio;

import java.util.Iterator;

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
	public boolean agregarEvento(Evento eventoAAgregar) {
		Boolean rt=false;
		if (eventoAAgregar!=null) {
			for (int i = 0; i < eventos.length; i++) {
				if (eventos[i]==null) {
					eventos[i]=eventoAAgregar;
					rt=true;
					break;
				}
			}
		}
		return rt;
	}
	public Integer obtenerCantidadDeEventosExistentes() {
		Integer cantidad=0;
		for (int i = 0; i < eventos.length; i++) {
			if (eventos[i]!=null) {
				cantidad++;
			}
		}
		return cantidad;
	}
	public Evento[] obtenerListaDeEventosExistentes() {
		Evento[] eventosExistentes=new Evento[obtenerCantidadDeEventosExistentes()];
		int posicionEvento=0;
		for (int i = 0; i < eventos.length; i++) {
			if (eventos[i]!=null) {
				eventosExistentes[posicionEvento]=eventos[i];
				posicionEvento++;
			}
		}
		return eventosExistentes;
	}
	public Boolean eliminarEvento(Integer codigo) {
		Boolean rt=false;
		for (int i = 0; i < eventos.length; i++) {
			if (eventos[i]!=null) {
				if (eventos[i].getIdentificador().equals(codigo)) {
					eventos[i]=null;
					rt=true;
					break;
				}
			}

		}
		return rt;
	}
	public Evento buscarEventoPorCodigo(Integer codigo) {
		Evento eventoBuscado=null;
		for (int i = 0; i < eventos.length; i++) {
			if (eventos[i]!=null) {
				if (eventos[i].getIdentificador().equals(codigo)) {
					eventoBuscado=eventos[i];
					break;
				}
			}

		}
		return eventoBuscado;
	}

}
