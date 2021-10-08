package parcial1pb2.dominio;

import static org.junit.Assert.*;

import org.junit.Test;


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
		Socio socio1 = new Ciclista("asd","123", "Juan", "Martinez", TipoDeBicicleta.RUTA);
		assertNotNull(evento1);
		assertNotNull(socio1);
		assertTrue(evento1.anotarParticipante(socio1));
	}
	
	@Test
	public void queSePuedaRemoverUnParticipanteIngresado() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Socio socio1 = new Ciclista("asd","123", "Juan", "Martinez", TipoDeBicicleta.RUTA);
		evento1.anotarParticipante(socio1);
		assertTrue(evento1.removerParticipante(socio1));
	}
	
	@Test
	public void queSePuedaCrearUnVeedorEIngresarloAlEvento() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Veedor publico1 = new Veedor("asd", "123", 12345678, "Pedro", "Fernandez");
		assertNotNull(publico1);
		assertTrue(evento1.anotarVeedor(publico1));
	}
	
	@Test
	public void queSePuedaRemoverUnVeedorIngresado() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Veedor publico1 = new Veedor("asd", "123", 12345678, "Pedro", "Fernandez");
		evento1.anotarVeedor(publico1);
		assertTrue(evento1.removerVeedor(publico1));
	}
	
	@Test
	public void queNoSePuedanRegistrarDosVeedoresConElMismoDNI() {
		Evento evento1 = new Evento("Evento de prueba", TipoDeCompetencia.CICLISMO, 10, 150);
		Veedor publico1 = new Veedor("asd", "123", 12345678, "Pedro", "Fernandez");
		Veedor publico2 = new Veedor("asdf", "1234", 12345678, "Martin", "Hernandez");
		assertTrue(evento1.anotarVeedor(publico1));
		//Al tener el mismo DNI, el ingreso no se realiza por lo que da como resultado false, dando verde el test general
		assertFalse(evento1.anotarVeedor(publico2));
	}
	
	@Test
	public void queNoSePuedanAgregarMasParticipantesDeLosPermitidos() {
		Evento evento1 = new Evento("Acuatrlon", TipoDeCompetencia.ACUATLON, 4, 100);
		Socio socio1 = new Nadador("asd1","123", "Juan", "Martinez", EstiloPreferido.CROLL);
		Socio socio2 = new Nadador("asd2","1234", "Pedro", "Sanchez", EstiloPreferido.ESPALDA);
		Socio socio3 = new Corredor("asd3","12345", "Sergio", "Gonzales", DistanciaPreferida.CINCO_KM);
		Socio socio4 = new Corredor("asd4","123456", "Martin", "Juarez", DistanciaPreferida.CINCO_KM);
		assertTrue(evento1.anotarParticipante(socio1));
		assertTrue(evento1.anotarParticipante(socio2));
		assertTrue(evento1.anotarParticipante(socio3));
		assertTrue(evento1.anotarParticipante(socio4));
		Socio socio5 = new Corredor("asd5","1234567", "Socio5", "Socio5", DistanciaPreferida.CUARENTA_Y_DOS_KM);
		//Al solo poder anotarse 4 participantes, el 5to debería dar falso, dando verde el test general.
		assertFalse(evento1.anotarParticipante(socio5));
	}
	
	@Test
	public void queNoSePuedaAgregarMasPublicoDelPermitido() {
		Evento evento1 = new Evento("Acuatrlon", TipoDeCompetencia.ACUATLON, 4, 5); //4 son los participantes, 5 el publico permitido
		Veedor publico1 = new Veedor("asd1","1", 12345678, "Pedro", "Sanchez");
		Veedor publico2 = new Veedor("asd2","12", 1234567, "Juan", "Juarez");
		Veedor publico3 = new Veedor("asd3","123", 123456, "Sergio", "Fernandez");
		Veedor publico4 = new Veedor("asd4","1234", 12345, "Martin", "Gonzales");
		Veedor publico5 = new Veedor("asd5","12355", 1234, "Alma", "Martinez");
		assertTrue(evento1.anotarVeedor(publico1));
		assertTrue(evento1.anotarVeedor(publico2));
		assertTrue(evento1.anotarVeedor(publico3));
		assertTrue(evento1.anotarVeedor(publico4));
		assertTrue(evento1.anotarVeedor(publico5));
		Veedor publico6 = new Veedor("asd5","12355", 123456789, "Maria", "Hernandez");
		//Al solo poder anotarse 5 veedores, el 6to debería dar falso, dando verde el test general.
		assertFalse(evento1.anotarVeedor(publico6));
	}

}
