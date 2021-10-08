package src.parcial1.pb2.tm.dominio;

public class Administracion {

	private Socio[] participantes;
	private String usuario;
	private String contraseña;

	public Administracion() {
		this.usuario = "administrador";
		this.contraseña = "1234";
		participantes = new Socio[1000];
	}

	public Boolean realizarRegistroDeUsuario(Socio usuario) {
		for (int i = 0; i < participantes.length; i++) {
			if (participantes[i] == null) {
				participantes[i] = usuario;
				return true;
			}
		}
		return false;
	}

	public Boolean VerificarIngreso(String usuario, String contraseña) {
		Boolean verificar = false;
		if (usuario == this.usuario && contraseña == this.contraseña) {
			verificar = true;
		}
		return verificar;
	}
}
