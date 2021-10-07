package parcial1.pb2.tm.dominio;

public class Evento {
	private String nombre;
	private Socio [] participantes;
	private Veedor [] publico;
	private TipoDeCompetencia tipoDeCompetencia;

	public Evento(String nombre, TipoDeCompetencia tipo, Integer cantidadDeParticipantes, Integer publicoHabilitado) {
		this.nombre = nombre;
		this.tipoDeCompetencia = tipo;
		participantes = new Socio [cantidadDeParticipantes];
		publico = new Veedor [publicoHabilitado];
	}
	
	
	public Boolean anotarParticipante(Socio deportistaParticipante) {
		for(int i=0; i<participantes.length; i++) {
			if(buscarParticipante(deportistaParticipante)==null) {
				if(participantes[i]==null) {
					participantes[i]=deportistaParticipante;
					return true;
				}
			}
		}return false;
	}
	
	public Boolean removerParticipante(Socio deportistaParticipante) {
		for(int i=0; i<participantes.length; i++) {
			if(participantes[i].getNroSocio().equals(deportistaParticipante.getNroSocio())) {
				participantes[i]=null;
				return true;
			}
		}return false;
	}
	
	public Boolean anotarVeedor(Veedor personaAIngresar) {
		for(int i=0; i<publico.length; i++) {
			if(buscarVeedor(personaAIngresar)==null) {
				if(publico[i]==null) {
					publico[i]=personaAIngresar;
					return true;
				}
			}
		}return false;
	}

	public Socio buscarParticipante(Socio participanteABuscar) {
		for(int i=0; i<participantes.length; i++) {
			if(participantes[i]!=null) {
				if(participantes[i].getNroSocio().equals(participanteABuscar.getNroSocio())) {
					return participantes[i];
				}
			}
		}return null;
	}
	
	public Veedor buscarVeedor(Veedor veedorABuscar) {
		for(int i=0; i<publico.length; i++) {
			if(publico[i]!=null) {
				if(publico[i].getDni().equals(veedorABuscar.getDni()) && publico[i].getNroEntrada().equals(veedorABuscar.getNroEntrada())) {
					return publico[i];
				}
			}
		}return null;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Socio[] getParticipantes() {
		return participantes;
	}


	public Veedor[] getPublico() {
		return publico;
	}


	public TipoDeCompetencia getTipoDeCompetencia() {
		return tipoDeCompetencia;
	}
	
	
	
	
///////////////////////////////////////////////////	
}
