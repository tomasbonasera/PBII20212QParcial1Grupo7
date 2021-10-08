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
		Boolean rt=false;
		if(buscarParticipantePorNumeroDeSocio(deportistaParticipante.getNroSocio())==null) {	
			for(int i=0; i<participantes.length; i++) {
				if(participantes[i]==null) {
					participantes[i]=deportistaParticipante;
					rt=true;
					break;
				}
			}
		}
		return rt;
	}
	
	public Boolean removerParticipante(Socio deportistaParticipante) {
		Boolean rt=false;
		for(int i=0; i<participantes.length; i++) {
			if(participantes[i].getNroSocio().equals(deportistaParticipante.getNroSocio())) {
				participantes[i]=null;
				rt=true;
				break;
			}
		}return rt;
	}
	
	public Boolean anotarVeedor(Veedor personaAIngresar) {
		Boolean rt=false;
		if(buscarVeedor(personaAIngresar)==null) {
			for(int i=0; i<publico.length; i++) {
				if(publico[i]==null) {
					publico[i]=personaAIngresar;
					rt=true;
					break;
				}
			}
		}
		return rt;
	}

	public Socio buscarParticipantePorNumeroDeSocio(Integer nmroSocioABuscar) {
		Socio participanteEncontrado=null;
		for(int i=0; i<participantes.length; i++) {
			if(participantes[i]!=null) {
				if(participantes[i].getNroSocio().equals(nmroSocioABuscar)) {
					participanteEncontrado=participantes[i];
					break;
				}
			}
		}return participanteEncontrado;
	}
	
	public Veedor buscarVeedor(Veedor veedorABuscar) {
		Veedor veedorencontrado=null;
		for(int i=0; i<publico.length; i++) {
			if(publico[i]!=null) {
				if(publico[i].getDni().equals(veedorABuscar.getDni()) && publico[i].getNroEntrada().equals(veedorABuscar.getNroEntrada())) {
					veedorencontrado=publico[i];
					break;
				}
			}
		}return veedorencontrado;
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
