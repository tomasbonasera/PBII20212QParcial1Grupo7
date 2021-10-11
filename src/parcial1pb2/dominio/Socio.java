package parcial1pb2.dominio;

public class Socio extends Usuario {
	private Integer nroSocio=0;
	private String nombre;
	private String apellido;
	private TipoDeDeportista tipoDeDeportista;
	private TipoDeDeportista[] DeportesQuePuedeRealizar=new TipoDeDeportista[3];
	private static Integer cantidadSocios = 0;
	public Socio(String usuario, String contrasena, String nombre, String apellido, TipoUsuario tipoUsuario) {
		super(usuario, contrasena, tipoUsuario);
		this.nombre = nombre;
		this.apellido = apellido;
		setTipo(TipoUsuario.DEPORTISTA);
		this.nroSocio = cantidadSocios++;
	}
	
	public void establecerDeportePrimario() {
		this.DeportesQuePuedeRealizar[0]=tipoDeDeportista;
	}
	public boolean agregarDeporteQuePuedeRealizar(TipoDeDeportista tipo) {
		Boolean rt=false;
		for (int i = 0; i < DeportesQuePuedeRealizar.length; i++) {
			if (DeportesQuePuedeRealizar[i]==null && tipo!=DeportesQuePuedeRealizar[0] && tipo!=DeportesQuePuedeRealizar[1] && tipo!=DeportesQuePuedeRealizar[2]) {
				DeportesQuePuedeRealizar[i]=tipo;
				rt=true;
				break;
			}
		}
		return rt;
	}
	public boolean puedeRealizarDeterminadoDeporte(TipoDeDeportista tipo) {
		Boolean rt=false;
		for (int i = 0; i < DeportesQuePuedeRealizar.length; i++) {
			if (DeportesQuePuedeRealizar[i]!=null && DeportesQuePuedeRealizar[i].equals(tipo)) {
				rt=true;
				break;
			}
		}
		return rt;
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
	

	public TipoDeDeportista[] getDeportesQuePuedeRealizar() {
		return DeportesQuePuedeRealizar;
	}

	public void setDeportesQuePuedeRealizar(TipoDeDeportista[] deportesQuePuedeRealizar) {
		DeportesQuePuedeRealizar = deportesQuePuedeRealizar;
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




	@Override
	public String toString() {
		return "Numero de Socio=" + nroSocio + ", Nombre=" + nombre + ", Apellido=" + apellido + ", Tipo De Deportista="
				+ tipoDeDeportista + "]";
	}
	
}
