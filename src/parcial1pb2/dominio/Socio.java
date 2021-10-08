package parcial1pb2.dominio;

public abstract class Socio {
	private Integer nroSocio;
	private String nombre;
	private String apellido;
	private TipoDeDeportista tipoDeDeportista;

	public Socio(Integer nroSocio, String nombre, String apellido) {
		this.nroSocio = nroSocio;
		this.nombre = nombre;
		this.apellido = apellido;
	}

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

	public TipoDeDeportista getTipoDeportista() {
		return tipoDeDeportista;
	}
}


