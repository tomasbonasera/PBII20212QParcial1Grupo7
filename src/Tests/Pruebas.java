package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Parcial_1.Ciclista;
import Parcial_1.Evento;
import Parcial_1.Socio;
import Parcial_1.Veedor;
import enums.TipoDeBicicleta;
import enums.TipoDeCompetencia;

public class Pruebas {

	@Test
	public void queSePuedaCrearUnEvento() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		final TipoDeCompetencia TIPO_ESPERADO = TipoDeCompetencia.CICLISMO;
		assertEquals (TIPO_ESPERADO, evento1.getTipoDeCompetencia());
	}
	
	@Test
	public void queSePuedaCrearUnParticipanteEIngresarloAlEvento() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Socio socio1 = new Ciclista(1234, "Juan", "Martinez", TipoDeBicicleta.RUTA);
		assertNotNull(evento1);
		assertNotNull(socio1);
		assertTrue(evento1.anotarParticipante(socio1));
	}
	
	@Test
	public void queSePuedaRemoverUnParticipanteIngresado() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Socio socio1 = new Ciclista(1234, "Juan", "Martinez", TipoDeBicicleta.RUTA);
		evento1.anotarParticipante(socio1);
		assertTrue(evento1.removerParticipante(socio1));
	}
	
	@Test
	public void queSePuedaCrearUnVeedorEIngresarloAlEvento() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Veedor publico1 = new Veedor(12345678, "Pedro", "Fernandez");
		assertNotNull(publico1);
		assertTrue(evento1.anotarVeedor(publico1));
	}

}
