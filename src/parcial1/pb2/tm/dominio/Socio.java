package src.parcial1.pb2.tm.dominio;

import enums.parcial1.pb2.tm.dominio.TipoDeDeportista;

public class Socio {
	private Integer nroSocio;
	private String nombre;
	private String apellido;
	private String usuario;

	public Socio(String nombre, String apellido, String usuario, String contraseña) {
		this.nroSocio++;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	private String contraseña;
	private TipoDeDeportista tipoDeDeportista;

	public Integer getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(Integer nroSocio) {
		this.nroSocio = nroSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// Cuando el nro de socio es el mismo significa que es la misma persona
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroSocio == null) ? 0 : nroSocio.hashCode());
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
		Socio other = (Socio) obj;
		if (nroSocio == null) {
			if (other.nroSocio != null)
				return false;
		} else if (!nroSocio.equals(other.nroSocio))
			return false;
		return true;
	}

	public void setTipoDeDeportista(TipoDeDeportista deportista) {
		this.tipoDeDeportista = deportista;
	}

}
