package src.parcial1.pb2.tm.dominio;

public class Administracion {

	private Socio[] participantes;
	private String usuario;
	private String contraseņa;

	public Administracion() {
		this.usuario = "administrador";
		this.contraseņa = "1234";
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

	public Boolean VerificarIngreso(String usuario, String contraseņa) {
		Boolean verificar = false;
		if (usuario == this.usuario && contraseņa == this.contraseņa) {
			verificar = true;
		}
		return verificar;
	}
}
