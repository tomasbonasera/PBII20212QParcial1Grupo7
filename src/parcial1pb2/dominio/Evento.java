package parcial1pb2.dominio;

public class Evento {
	private String nombre;
	private Socio[] participantes;
	private Veedor[] publico;
	private TipoDeCompetencia tipoDeCompetencia;
	private static Integer cantidadDeEventos = 0;
	private Integer identificador;

	public Evento(String nombre, TipoDeCompetencia tipo, Integer cantidadDeParticipantes, Integer publicoHabilitado) {
		this.nombre = nombre;
		this.tipoDeCompetencia = tipo;
		participantes = new Socio[cantidadDeParticipantes];
		publico = new Veedor[publicoHabilitado];
		this.identificador = cantidadDeEventos++;
	}

	public Boolean anotarParticipante(Socio deportistaParticipante) {
		Boolean rt = false;
		if (buscarParticipantePorNumeroDeSocio(deportistaParticipante.getNroSocio()) == null) {

			if (esApto(deportistaParticipante)) {
				for (int i = 0; i < participantes.length; i++) {
					if (participantes[i] == null) {
						participantes[i] = deportistaParticipante;
						rt = true;
						break;
					}
				}

			} // esApto

		}
		return rt;
	}

	public Boolean removerParticipanteConNroSocio(Integer nroSocio) {
		Boolean rt = false;
		for (int i = 0; i < participantes.length; i++) {
			if (participantes[i] != null) {
				if (participantes[i].getNroSocio().equals(nroSocio)) {
					participantes[i] = null;
					rt = true;
					break;
				}
			}

		}
		return rt;
	}

	public Boolean esApto(Socio deportistaParticipante) {
		Boolean socioApto = false;
		switch (this.tipoDeCompetencia) {
		case NATACION:
			if(deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.NADADOR)) {
				socioApto=true;
			}
			break;
		case RUNNING:
			if(deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.CORREDOR)) {
				socioApto=true;
			}
			break;
		case CICLISMO:
			if(deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.CICLISTA)) {
				socioApto=true;
			}
			break;

		case ACUATLON:
			if(deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.NADADOR) && 
			deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.CORREDOR)) {
				socioApto=true;
			}
			break;
		case DUATLON:
			if(deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.CICLISTA) && 
			deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.CORREDOR)) {
				socioApto=true;
			}
			break;
		case TRIATLON:
			if(deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.NADADOR) && 
			deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.CORREDOR) &&
			deportistaParticipante.puedeRealizarDeterminadoDeporte(TipoDeDeportista.CICLISTA)) {
				socioApto=true;

			}
			break;
		}
		return socioApto;
	}

	public Boolean anotarVeedor(Veedor personaAIngresar) {
		Boolean rt = false;
		if (buscarVeedorConDni(personaAIngresar.getDni()) == null) {
			for (int i = 0; i < publico.length; i++) {
				if (publico[i] == null) {
					publico[i] = personaAIngresar;
					rt = true;
					break;
				}
			}
		}
		return rt;
	}

	public Boolean removerVeedorConDni(Integer dni) {
		Boolean rt = false;
		for (int i = 0; i < publico.length; i++) {
			if (publico[i] != null) {
				if (publico[i].getDni().equals(dni)) {
					publico[i] = null;
					rt = true;
					break;
				}
			}

		}
		return rt;
	}

	public Socio buscarParticipantePorNumeroDeSocio(Integer nmroSocioABuscar) {
		Socio participanteEncontrado = null;
		for (int i = 0; i < participantes.length; i++) {
			if (participantes[i] != null) {
				if (participantes[i].getNroSocio().equals(nmroSocioABuscar)) {
					participanteEncontrado = participantes[i];
					break;
				}
			}
		}
		return participanteEncontrado;
	}

	public Veedor buscarVeedorConDni(Integer dni) {
		Veedor veedorencontrado = null;
		for (int i = 0; i < publico.length; i++) {
			if (publico[i] != null) {
				if (publico[i].getDni().equals(dni)) {
					veedorencontrado = publico[i];
					break;
				}
			}
		}
		return veedorencontrado;
	}

	public void setParticipantes(Socio[] participantes) {
		this.participantes = participantes;
	}

	public void setPublico(Veedor[] publico) {
		this.publico = publico;
	}

	public void setTipoDeCompetencia(TipoDeCompetencia tipoDeCompetencia) {
		this.tipoDeCompetencia = tipoDeCompetencia;
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

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	@Override
	public String toString() {
		return "Código=" + identificador + ", Tipo De Competencia=" + tipoDeCompetencia + ", Nombre=" + nombre;
	}

}
