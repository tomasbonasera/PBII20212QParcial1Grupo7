package parcial1pb2.dominio;

public class Veedor extends Usuario {

	private Integer dni;
	private String nombre;
	private String apellido;

	
	public Veedor(String usuario, String contrasena, Integer dni, String nombre, String apellido,
			TipoUsuario tipoUsuario) {
		super(usuario, contrasena, tipoUsuario,dni);
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		setUsuario(usuario);
		setContrasena(contrasena);

	}

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}


	// Cuando el dni es el mismo significa que es la misma persona
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veedor other = (Veedor) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}	

}
