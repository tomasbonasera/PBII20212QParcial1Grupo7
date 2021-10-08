package Tests.parcial1.pb2.tm.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import enums.parcial1.pb2.tm.dominio.TipoDeBicicleta;
import enums.parcial1.pb2.tm.dominio.TipoDeCompetencia;
import src.parcial1.pb2.tm.dominio.Ciclista;
import src.parcial1.pb2.tm.dominio.Evento;
import src.parcial1.pb2.tm.dominio.Socio;
import src.parcial1.pb2.tm.dominio.Veedor;

public class Pruebas {

	@Test
	public void queSePuedaCrearUnEvento() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		final TipoDeCompetencia TIPO_ESPERADO = TipoDeCompetencia.CICLISMO;
		assertEquals(TIPO_ESPERADO, evento1.getTipoDeCompetencia());
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
