package parcial1pb2.dominio;

public class Veedor {
	private Integer dni;
	private String nombre;
	private String apellido;
	private Integer nroEntrada;

	public Veedor(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getNroEntrada() {
		return nroEntrada;
	}

	public void setNroEntrada(Integer nroEntrada) {
		this.nroEntrada = nroEntrada;
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

	//Cuando el DNI y el nro de entrada son iguales significa que es la misma persona
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nroEntrada == null) ? 0 : nroEntrada.hashCode());
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
		if (nroEntrada == null) {
			if (other.nroEntrada != null)
				return false;
		} else if (!nroEntrada.equals(other.nroEntrada))
			return false;
		return true;
	}

}
